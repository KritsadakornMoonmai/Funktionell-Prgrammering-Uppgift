package Fråga2

import UnusedQuestions.Fråga2.Fråga2Main
import UnusedQuestions.Fråga2.RowsAndColsClass
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class MainKtTest {
    var input:String = "Sabqponm\n" +
            "abcryxxl\n" +
            "accszExk\n" +
            "acctuvwj\n" +
            "abdefghi"


    @Test
    fun alfabetToListTest() {
        var f2M = Fråga2Main()

        f2M.alfabetArray(input)
        //f2M.Switch(input)

    }

    @Test
    fun rowTest() {
        var fråga2Main = Fråga2Main()

        println(fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)).lists)
    }
    @Test
    fun PositionTest() {
        var fråga2Main = Fråga2Main()

        println("ans1,1 = S:"+fråga2Main.findElementInRowAndCol(
            fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 1, 1))

        println("ans2,1 = a:"+fråga2Main.findElementInRowAndCol(
            fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 2, 1))
        println("ans3,4 = s:"+fråga2Main.findElementInRowAndCol(
                fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 3, 4))

        println("ans3,1 = a:"+fråga2Main.findElementInRowAndCol(
            fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 3, 1))

        println("ans3,8 = k:"+fråga2Main.findElementInRowAndCol(
            fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 3, 8))

        println("ans4,5 = u:"+fråga2Main.findElementInRowAndCol(
            fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 4, 5))

        println("ans5,4 = e:"+fråga2Main.findElementInRowAndCol(
            fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 5, 4))


        assertTrue(
            fråga2Main.findElementInRowAndCol(
                fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 3, 1) == 'a')

        assertTrue(
            fråga2Main.findElementInRowAndCol(
                fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 3, 8) == 'k'
        )
        assertTrue(
            fråga2Main.findElementInRowAndCol(
                fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 4, 5) == 'u'
        )

        assertTrue(
            fråga2Main.findElementInRowAndCol(
                fråga2Main.rowAndCol(fråga2Main.alfabetArray(input)), 5, 4) == 'e'
        )

    }

    @Test
    fun moveTest() {
        var f2 = Fråga2Main()

        println(f2.moveSet(RowsAndColsClass(1, 1, f2.alfabetArray(input))))
    }
}