package ca.qc.cstj.s05localdatasource.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contact(
    @ColumnInfo(name = "firstName") var firstName: String,
    @ColumnInfo(name = "lastName") var lastName: String,
    @ColumnInfo(name = "isOnline") var isOnline: Boolean
) {
    @PrimaryKey(autoGenerate = true) var idContact: Int = 0
}
