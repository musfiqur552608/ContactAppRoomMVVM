package org.freedu.mvmvroom

import androidx.lifecycle.LiveData


class ContactRepository(val dao : ContactDao)
{
    // function to get all contacts from the database
    fun getAllContacts() : LiveData<List<Contacts>> {
        return dao.getAllContacts()
    }

    // function to insert a contact in the database
    fun insertContact(contact : Contacts) {
        dao.insertContact(contact)
    }

    // function to delete a contact from the database
    fun deleteContact(contact: Contacts) {
        dao.delete(contact)
    }
}