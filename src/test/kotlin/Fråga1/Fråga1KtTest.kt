package Fråga1

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import java.io.File

class Fråga1KtTest {

    @org.junit.jupiter.api.Test
    fun collectCaloriesTest() {
        var f1: CalculatorF1 = CalculatorF1()
        var numbs:List<String> = listOf("1000", "2000", "3000","","4000","5000")

        println(f1.Calculator(numbs))

    }

    @Test
    fun SortedNumTest() {
        var cals = CalculatorF1()
        try {
            val filepath = "src/main/kotlin/Fråga1/PuzzleInput"
            var line: String?
            var text: String

            fun Reader(file: String): List<String> =
                File(file).bufferedReader().readLines()

            //Reader(filepath).forEach { println(it) }


            var resultList: List<Int> = cals.Calculator(Reader(filepath))
            //println(resultList)
            // Anropa värde som 3 Elf håller i sambandet (AoC 2022 day 1 part 2 svar)
            println(cals.FindThreeMostNumbCombine(resultList))
            // Anropa värde som Största Elf håller (AoC 2022 day 1 part 1 svar)
            var theMostCal: Int = cals.FindMostNumb(resultList)
            println("Elf:$theMostCal has most calories")

        } catch (e: Exception) {
            e.stackTrace
        }
    }


}