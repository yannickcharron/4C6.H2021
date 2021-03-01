package ca.qc.cstj.s05localdatasource.repositories

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import ca.qc.cstj.s05localdatasource.models.Contact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

@Dao
interface ContactRepository {

    @Query("SELECT * FROM Contacts")
    fun retrieveAll(): Flow<List<Contact>>

    @Insert
    fun insert(contacts: List<Contact>)

    @Insert
    suspend fun insert(contact: Contact)

    @Query("DELETE FROM Contacts WHERE idContact=:idContact")
    suspend fun delete(idContact: Int)

    @Update
    suspend fun update(contact:Contact)

}

//    fun retrieveAll(numContacts: Int): Flow<List<Contact>> {
//
//        val contacts = mutableListOf<Contact>()
//        for (i in 1..numContacts) {
//            contacts.add(Contact("FirstName $i", "LastName $i", i % 2 == 0))
//        }
//
//        return flow {
//            emit(contacts)
//        }
//    }