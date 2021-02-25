package ca.qc.cstj.s05localdatasource.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contact(
    @ColumnInfo(name = "firstName") val firstName: String,
    @ColumnInfo(name = "lastName") val lastName: String,
    @ColumnInfo(name = "isOnline") val isOnline: Boolean
) {
    @PrimaryKey(autoGenerate = true) var idContact: Int = 0
}
