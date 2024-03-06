package Fråga1

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.util.Collections

class CalculatorF1 {

    //Returnerar 3 första calorievärde som hålls av varje 3 största Elf
    fun FindThreeMostNumbCombine(resultNumList: List<Int>): Int{
        var sortedResultNum: List<Int> = resultNumList.sortedDescending()

        tailrec fun Finder(num: Int, counter:Int):Int {
            return if (counter == 3) num
            else Finder(sortedResultNum[counter] + num, counter + 1)
        }
        return Finder(0, 0)
    }

    //Returnerar den största värde
    fun FindMostNumb(resultNumList: List<Int>): Int {
        var elfNumber = 0
        tailrec fun Finder(numbs: Int, elfNumber: Int, counter:Int): Int {
            return if (counter == resultNumList.size) numbs
            else Finder((if (resultNumList[counter] > numbs) resultNumList[counter] else numbs),
                (if (resultNumList[counter] > numbs) counter + 1 else elfNumber)
                ,counter + 1)
        }
        var numbs: Int = 0
        return Finder(numbs,elfNumber,0)
    }

    tailrec fun Calculator(string: List<String>): List<Int> {

        var reList: MutableList<Int> = mutableListOf()
        var value:Int = 0
        var loopAmount: Int = 0
        for (i in string) {

            //println(i)
            //println("v:$value")
            //println("str:$i")
            //println(loopAmount)
            if (i == "") {
                reList.add(value)
                value = 0
                loopAmount += 1
            } else {
                value += i.toInt()
                if (loopAmount + 1 == string.size) {
                    reList.add(value)
                    break
                }
                loopAmount += 1
            }
        }
        return reList
    }

}
fun main() {
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

        //Svar av dag 1 del 1
        var theMostCal: Int = cals.FindMostNumb(resultList)
        println("Elf:$theMostCal has most calories")

        //Svar av dag 1 del 2
        println("3 Elf combined: ${cals.FindThreeMostNumbCombine(resultList)}")

        var texts: String = ""
        Reader(filepath).forEach{ texts += "$it\n" }

        //Efter lösningar Nedan är Ginsbergs lösningar

        //De har trim för att radera tomda platser och split för att skilja mellan grupper av nummer
        //de har även map för att summera alla värde i nummergruppen och sortdescending() för att
        // ta den största summerade nummer framme och mindre värde bak
        //lines() fungerade inte utan .split("\n\n")
        fun StringToList(num: String):List<Int> =
            num.trim().split("\n\n").map { it.lines().sumOf (String::toInt) }.sortedDescending()

        //Lösningar av Todd Ginsberg. Ta den första värde av List<Int>
        fun lösningarFrånToddGinsBerg1():Int = StringToList(texts).first()

        //Lösningar av Todd Ginsberg. Ta den 3 första värde av List<Int>
        fun lösningarFrånToddGinsBerg2():List<Int> = StringToList(texts).take(3)

        //Summera värde från Ginsberg 2
        var summa: Int = lösningarFrånToddGinsBerg2().sum()

        println("Ginsbergs: Lösningar = ${lösningarFrånToddGinsBerg1()}")

        println("Ginsbergs: Lösningar 2 = $summa")

        //Efterlösningar till Mattias Schenk
        //Summera från Mattias Schenk
        //med max() tas direkt maxvärde från lista, behövs int skriva mer än min och Ginsbergs metod (ändrar förstås till List<Int>)
        println("ResultList Från Mattias Schenk del 1: ${resultList.max()}")
        //sortedDescending() sorterar med den största till minsta i listan, sedan tar 3 av dem från främmande värde och summera alltihop
        println("ResultList Från Mattias Schenk del 2: ${resultList.sortedDescending().take(3).sum()}")

    } catch (e: Exception) {
        e.stackTrace
    }




}