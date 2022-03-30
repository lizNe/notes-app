package utils

object NoteUtilities {

    //NOTE: JvmStatic annotation means that the categories variable is static (i.e. we can reference it through the class
    //      name; we don't have to create an object of CategoryUtility to use it.
    @JvmStatic
    val categories = setOf ("Home", "College")  //add more categories in here.

    @JvmStatic
    fun isValidCategory(categoryToCheck: String?): Boolean {
        for (category in categories) {
            if (category.equals(categoryToCheck, ignoreCase = true)) {
                return true
            }
        }
        return false
    }

    //NOTE: JvmStatic annotation means that the methods are static (i.e. we can call them over the class
    //      name; we don't have to create an object of Utilities to use them.

    @JvmStatic
    fun validRange(numberToCheck: Int, min: Int, max: Int): Boolean {
        return numberToCheck in min..max
    }

    @JvmStatic
    fun isValidListIndex(index: Int, list: List<Any>): Boolean {
        return (index >= 0 && index < list.size)
    }








}