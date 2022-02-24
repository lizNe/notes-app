import java.lang.System.exit
import java.util.*

val scanner = Scanner(System.`in`)

fun main(args: Array<String>) {
    runMenu()
}


fun mainMenu() : Int{
    println("")
    println("---------------------")
    println("NOTE KEEPER APP")
    println("--------------------")
    println("NOTE MENU")
    println(" 1) Add a Note")
    println(" 2) List all Notes")
    println(" 3) Update a Note")
    println(" 4) Delete a Node")
    println("--------------------")
    println(" 0) Exit")
    println("--------------------")
    println("==>> ")
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
            else -> System.out.println("Invalid option entered: " + option)
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
