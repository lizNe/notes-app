import java.lang.System.exit
import java.util.*

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    runMenu()
}


fun mainMenu() : Int{
    """
          ----------------------------------
          |        NOTE KEEPER APP         |
          ----------------------------------
          | NOTE MENU                      |
          |   1) Add a note                |
          |   2) List all notes            |
          |   3) Update a note             |
          |   4) Delete a note             |
          ----------------------------------
          |   0) Exit                      |
          ----------------------------------
          ==>> """
    return scanner.nextInt()

}

fun runMenu(){
    do{
        val option = mainMenu()
        when(option){
            1 -> addNote()
            2 -> listNotes()
            3 -> updateNotes()
            4 -> deleteNote()
            0 -> exitApp()
            else -> System.out.println("Invalid option entered: $option ")
        }

    }
    while(true)

}

fun addNote(){
    println("You choose Add Note")
}

fun listNotes(){
    println("You choose Add Note")
}

fun updateNotes(){
    println("You choose Add Note")
}

fun deleteNote(){
    println("You choose Add Note")
}

fun exitApp() {
    println("Exiting...Goodbye")
    exit(0)
}
