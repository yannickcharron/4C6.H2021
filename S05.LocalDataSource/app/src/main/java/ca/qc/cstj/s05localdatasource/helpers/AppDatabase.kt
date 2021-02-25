package ca.qc.cstj.s05localdatasource.helpers

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ca.qc.cstj.s05localdatasource.models.Contact
import ca.qc.cstj.s05localdatasource.repositories.ContactRepository
import java.util.concurrent.Executors

@Database(entities = [Contact::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    //TODO: Add Rooms Repository (DAO) here
    //abstract fun zzzRepository(): zzzRepository
    abstract fun contactRepository() : ContactRepository

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "s05_database" //TODO: RENAME database_name
            )
                // prepopulate the database after onCreate was called
                .addCallback(object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        //insert the data on the IO Thread
                        ioThread {
                            //TODO: Add prepopulated call here
                            val PREPOPULATE_DATA = listOf(
                                Contact("Yannick", "Charron", true),
                                Contact("Robert", "Turenne", true),
                                Contact("Karine", "Moreau", false),
                                Contact("Joël", "Beaudet", true)
                            )

                            getInstance(context).contactRepository().insert(PREPOPULATE_DATA)
                        }
                    }
                })
                .build()

        /**
         * Utility method to run blocks on a dedicated background thread, used for io/database work.
         */
        private val IO_EXECUTOR = Executors.newSingleThreadExecutor()
        fun ioThread(f: () -> Unit) {
            IO_EXECUTOR.execute(f)
        }
    }

}
