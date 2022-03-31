package utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import utils.NoteUtilities.categories
import utils.NoteUtilities.isValidCategory
import utils.NoteUtilities.isValidStatus
import utils.NoteUtilities.status
import utils.NoteUtilities.validRange

internal class NoteUtilitiesTest {

    @Test
    fun validRangeWorksWithPositiveTestData() {
        Assertions.assertTrue(validRange(1, 1, 1))
        Assertions.assertTrue(validRange(1, 1, 2))
        Assertions.assertTrue(validRange(1, 0, 1))
        Assertions.assertTrue(validRange(1, 0, 2))
        Assertions.assertTrue(validRange(-1, -2, -1))
    }

    @Test
    fun validRangeWorksWithNegativeTestData() {
        Assertions.assertFalse(validRange(1, 0, 0))
        Assertions.assertFalse(validRange(1, 1, 0))
        Assertions.assertFalse(validRange(1, 2, 1))
        Assertions.assertFalse(validRange(-1, -1, -2))
    }

    @Test
    fun categoriesReturnsFullCategoriesSet(){
        Assertions.assertEquals(5, categories.size)
        Assertions.assertTrue(categories.contains("Home"))
        Assertions.assertTrue(categories.contains("College"))
        Assertions.assertTrue(categories.contains("Work"))
        Assertions.assertTrue(categories.contains("Travel"))
        Assertions.assertTrue(categories.contains("Finances"))
    }

    @Test
    fun isValidCategoryTrueWhenCategoryExists(){
        Assertions.assertTrue(isValidCategory("Home"))
        Assertions.assertTrue(isValidCategory("home"))
        Assertions.assertTrue(isValidCategory("COLLEGE"))
        Assertions.assertTrue(isValidCategory("college"))
        Assertions.assertTrue(isValidCategory("WoRk"))
        Assertions.assertTrue(isValidCategory("work"))
        Assertions.assertTrue(isValidCategory("WORK"))
        Assertions.assertTrue(isValidCategory("TRAVEL"))
        Assertions.assertTrue(isValidCategory("tRAVel"))
        Assertions.assertTrue(isValidCategory("travel"))
        Assertions.assertTrue(isValidCategory("FINANCES"))
        Assertions.assertTrue(isValidCategory("finances"))
        Assertions.assertTrue(isValidCategory("FINancES"))

    }

    @Test
    fun isValidCategoryFalseWhenCategoryDoesNotExist(){
        Assertions.assertFalse(isValidCategory("Hom"))
        Assertions.assertFalse(isValidCategory("colllege"))
        Assertions.assertFalse(isValidCategory("werk"))
        Assertions.assertFalse(isValidCategory("travle"))
        Assertions.assertFalse(isValidCategory("financees"))

    }

    @Test
    fun statusesReturnsFullStatusSet(){
        Assertions.assertEquals(3, status.size)
        Assertions.assertTrue(status.contains("todo"))
        Assertions.assertTrue(status.contains("doing"))
        Assertions.assertTrue(status.contains("done"))

    }

    @Test
    fun isValidStatusTrueWhenStatusExists(){
        Assertions.assertTrue(isValidStatus("TODO"))
        Assertions.assertTrue(isValidStatus("todo"))
        Assertions.assertTrue(isValidStatus("ToDo"))
        Assertions.assertTrue(isValidStatus("tODO"))
        Assertions.assertTrue(isValidStatus("doing"))
        Assertions.assertTrue(isValidStatus("DOING"))
        Assertions.assertTrue(isValidStatus("DOing"))
        Assertions.assertTrue(isValidStatus("doiNG"))
        Assertions.assertTrue(isValidStatus("done"))
        Assertions.assertTrue(isValidStatus("DONE"))
        Assertions.assertTrue(isValidStatus("DOne"))
        Assertions.assertTrue(isValidStatus("donE"))




    }

    @Test
    fun isValidStatusFalseWhenStatusDoesNotExist(){
        Assertions.assertFalse(isValidStatus("toodo"))
        Assertions.assertFalse(isValidStatus("todoo"))
        Assertions.assertFalse(isValidStatus("toddo"))
        Assertions.assertFalse(isValidStatus("doingg"))
        Assertions.assertFalse(isValidStatus("doiing"))
        Assertions.assertFalse(isValidStatus("dong"))
        Assertions.assertFalse(isValidStatus("donee"))
        Assertions.assertFalse(isValidStatus("donne"))
        Assertions.assertFalse(isValidStatus("dine"))

    }
}