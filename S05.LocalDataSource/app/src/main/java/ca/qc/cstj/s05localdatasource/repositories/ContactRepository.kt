package ca.qc.cstj.s05localdatasource.repositories

import ca.qc.cstj.s05localdatasource.models.Contact
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ContactRepository {

    fun retrieveAll(numContacts: Int): Flow<List<Contact>> {

        val contacts = mutableListOf<Contact>()
        for (i in 1..numContacts) {
            contacts.add(Contact("FirstName $i", "LastName $i", i % 2 == 0))
        }

        return flow {
            emit(contacts)
        }
    }
}