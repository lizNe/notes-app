package controllers

import models.Note

class NoteAPI {
    private var notes = ArrayList<Note>()

    fun add(note: Note): Boolean{
        return notes.add(note)
    }

    fun listAllNotes(): String {
        return if(notes.isEmpty()){
            "No notes stores"
        }else{
            var listOfNotes = ""
            for (i in notes.indices) {
                listOfNotes += "${i}: ${notes[i]} \n"
            }
            listOfNotes
        }
    }


    fun numberOfNotes(): Int {
        return notes.size
    }

    fun findNote(index: Int): Note? {
        return if (isValidListIndex(index, notes)) {
            notes[index]
        } else null
    }

    //utility method to determine if an index is valid in a list.
    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }

    fun listActiveNotes(): String {
        var active = ""
        for (i in notes.indices) {
            if( notes[i].isNoteArchived.not())
                active += "${i}: ${notes[i]} \n"
        }
        return active
    }


    fun listArchivedNotes(): String {
            var archived = ""
            for (i in notes.indices) {
              if( notes[i].isNoteArchived)
                archived += "${i}: ${notes[i]} \n"
            }
        return archived
        }

    fun numberOfArchivedNotes(): Int {
        //helper method to determine how many archived notes there are
        return listArchivedNotes().count()
    }

    fun numberOfActiveNotes(): Int {
        //helper method to determine how many active notes there are
        return listActiveNotes().count()
    }
}