package models

data class Note(var noteTitle: String,
                var notePriority: Int,
                var noteCategory: String,
                var isNoteArchived :Boolean,
                var noteContents : String,
                var noteStatus : String,
                var noteDate : String )


//3 new fields added noteContents, noteDate and noteStatus