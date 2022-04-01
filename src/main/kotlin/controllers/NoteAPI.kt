package controllers
import models.Note
import persistence.Serializer
import utils.NoteUtilities.isValidListIndex
import utils.NoteUtilities.status

class NoteAPI(serializerType: Serializer) {
    private var notes = ArrayList<Note>()
        private var serializer: Serializer = serializerType

    fun add(note: Note): Boolean{
        return notes.add(note)
    }

    fun deleteNote(indexToDelete: Int): Note? {
        return if (isValidListIndex(indexToDelete, notes)) {
            notes.removeAt(indexToDelete)
        } else null
    }

    fun updateNote(indexToUpdate: Int, note: Note?): Boolean {
        //find the note object by the index number
        val foundNote = findNote(indexToUpdate)

        //if the note exists, use the note details passed as parameters to update the found note in the ArrayList.
        if ((foundNote != null) && (note != null)) {
            foundNote.noteTitle = note.noteTitle
            foundNote.notePriority = note.notePriority
            foundNote.noteCategory = note.noteCategory
            foundNote.noteContents = note.noteContents
            foundNote.noteStatus = note.noteStatus
            foundNote.noteDate = note.noteDate
            return true
        }

        //if the note was not found, return false, indicating that the update was not successful
        return false
    }


    fun listAllNotes(): String =
        if  (notes.isEmpty()) "No notes stored"
        else formatListString(notes)

    fun listActiveNotes(): String =
        if  (numberOfActiveNotes() == 0)  "No active notes stored"
        else formatListString(notes.filter { note -> !note.isNoteArchived})

    fun listArchivedNotes(): String =
        if  (numberOfArchivedNotes() == 0) "No archived notes stored"
        else formatListString(notes.filter { note -> note.isNoteArchived})


    fun numberOfNotes(): Int {
        return notes.size
    }

    fun findNote(index: Int): Note? {
        return if (isValidListIndex(index, notes)) {
            notes[index]
        } else null
    }


    fun numberOfArchivedNotes(): Int = notes.count { note: Note -> note.isNoteArchived }

    fun numberOfActiveNotes(): Int =
         notes.count() {note: Note -> !note.isNoteArchived}



 /*   fun listNotesBySelectedPriority(priority: Int): String {
        return if (notes.isEmpty()) {
            "No notes stored"
        } else {
            var listOfNotes = ""
            for (i in notes.indices) {
                if (notes[i].notePriority == priority) {
                    listOfNotes +=
                        """$i: ${notes[i]}
                        """.trimIndent()
                }
            }
            if (listOfNotes.equals("")) {
                "No notes with priority: $priority"
            } else {
                "${numberOfNotesByPriority(priority)} notes with priority $priority: $listOfNotes"
            }
        }
    }

*/
    /*   fun listNotesBySelectedCategory(category: String): String {
           return if (notes.isEmpty()) {
               "No notes stored"
           } else {
               var listOfNotes = ""
               for (i in notes.indices) {
                   if (notes[i].noteCategory == category) {
                       listOfNotes +=
                           """$i: ${notes[i]}
                           """.trimIndent()
                   }
               }
               if (listOfNotes.equals("")) {
                   "No notes with category: $category"
               } else {
                   "${numberOfNotesByCategory(category)} notes with category $category: $listOfNotes"
               }
           }
       }
   */

//    This method has been refactored to make the function contain less code but still work as intended. If the priority choosen by the user matches 0 meaning if no priority
//    exists in the system that the user has picked "no notes for this priority" is printed else filter the notes that have that priority and print to screen for user
    fun listNotesBySelectedPriority(priority: Int): String {
     return if (notes.isEmpty()) {
         "No notes stored"
     } else {
         if (numberOfNotesByPriority(priority) == 0)
              "no notes for this priority"
         else{
             formatListString(notes.filter { note -> note.notePriority==priority})
         }
     }
 }


    fun numberOfNotesByPriority(priority: Int): Int =
        notes.count() { note:Note -> note.notePriority == priority}


    //    Own Created Functions
    //    This method has been refactored to make the function contain less code but still work as intended. If the category choosen by the user matches 0 meaning if no category
    //    exists in the system that the user has picked "no notes for this category" is printed else filter the notes that have that category and print to screen for user
    fun listNotesBySelectedCategory(category: String): String {
        return if (notes.isEmpty()) {
            "No notes stored"
        } else {
            if (numberOfNotesByCategory(category) == 0)
                "no notes for this category"
            else{
                formatListString(notes.filter { note -> note.noteCategory==category})
            }
        }
    }

    fun numberOfNotesByCategory(category: String): Int =
        notes.count() { note:Note -> note.noteCategory == category}

     //   This method has been refactored to make the function contain less code but still work as intended. If the status choosen by the user matches 0 meaning if no status
    //    exists in the system that the user has picked "no notes for this status" is printed else filter the notes that have that status and print to screen for user
    fun listNotesBySelectedStatus(status: String): String {
        return if (notes.isEmpty()) {
            "No notes stored"
        } else {
            if (numberOfNotesByStatus(status) == 0)
                "no notes for this status"
            else{
                formatListString(notes.filter { note -> note.noteStatus==status})
            }
        }
    }

    fun numberOfNotesByStatus(status: String): Int =
        notes.count() { note:Note -> note.noteStatus == status}

     //   This method has been refactored to make the function contain less code but still work as intended. If the priority date by the user matches 0 meaning if no date
    //    exists in the system that the user has picked "no notes for this date" is printed else filter the notes that have that date and print to screen for user
    fun listNotesBySelectedDate(date: String): String {
        return if (notes.isEmpty()) {
            "No notes stored"
        } else {
            if (numberOfNotesByDate(date) == 0)
                "no notes for this date"
            else{
                formatListString(notes.filter { note -> note.noteDate==date})
            }
        }
    }

    fun numberOfNotesByDate(date: String): Int =
        notes.count() { note:Note -> note.noteDate == date}


    fun archiveNote(indexToArchive: Int): Boolean {
        if (isValidListIndex(indexToArchive, notes)) {
            val noteToArchive = notes[indexToArchive]
            if (!noteToArchive.isNoteArchived)
            {
                noteToArchive.isNoteArchived = true
                return true
            }
        }
        return false
    }

    // searches for notes by NotesTitle and uses the formatListString to print the note in a clean format
    fun searchByTitle (searchString : String) =
        formatListString(
            notes.filter { note -> note.noteTitle.contains(searchString, ignoreCase = true) })


    fun isValidIndex(index: Int) :Boolean{
        return isValidListIndex(index, notes);
    }

    @Throws(Exception::class)
    fun load() {
        notes = serializer.read() as ArrayList<Note>
    }

    @Throws(Exception::class)
    fun store() {
        serializer.write(notes)
    }

//    This function will format the way the string is printed to te screen so that it is cleaner rather than adding code to format your strings this method is called instead
    fun formatListString(notesToFormat : List<Note>) : String =
        notesToFormat
            .joinToString (separator = "\n") { note ->
                notes.indexOf(note).toString() + ": " + note.toString() }


    }
