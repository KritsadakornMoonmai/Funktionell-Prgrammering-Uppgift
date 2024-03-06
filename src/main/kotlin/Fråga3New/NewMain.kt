package Fråga3New

import java.io.File

class NewMain {

    //Skapa lista som har summa av tre nummer
    fun tripleNumList(lists: List<Int>): List<Int> {
        var newList:MutableList<Int> = mutableListOf()
        var num: Int = 0
        for (i in 0..<lists.size) {
            if ((lists.size - i) > 2) {
                num = lists[i] + lists[i + 1] + lists[i + 2]
                newList.add(num)
                //println(num)
            }
        }
        //println(newList)
        return newList
    }

    //Beräkna nuvarande värde med främmande värde
    fun measurement(numList: List<Int>): Int {
        var count: Int = 0
        var nums = 0
        fun counter(counter: Int, toMax: Int): Int {
            //returnerar antal nummer som är Increment mellan 2 nummer
            return if (toMax == numList.size - 1) counter
            else counter(
                if (numList[toMax] < numList[toMax + 1]) counter + 1 else counter, toMax + 1
            )
        }
        return counter(count, 0)
    }

}

fun main() {

    var nm = NewMain()
    // läser fil
    try {
        val filePath = "src/main/kotlin/Fråga3New/F3NewInput"

        fun Reader(file: String): List<String> =
            File(file).bufferedReader().readLines()


        //Ändra till List<Int>
        var listToInt: MutableList<Int> = mutableListOf()
        Reader(filePath).forEach { listToInt.add(it.toInt()) }

        //Svar för day1 2021
        println(nm.measurement(listToInt))

        //Svar för day1 part2 2021, läser med tripleNumList först än listToInt direkt
        println(nm.measurement(nm.tripleNumList(listToInt)))


        LösningarFrånDevStories()
    } catch (e: Exception) {
        e.stackTrace
    }

}

fun LösningarFrånDevStories() {
    var nm = NewMain()
    try {
        val filePath = "src/main/kotlin/Fråga3New/F3NewInput"

        fun Reader(file: String): List<String> =
            File(file).bufferedReader().readLines()

        var listToInt: MutableList<Int> = mutableListOf()
        Reader(filePath).forEach { listToInt.add(it.toInt()) }

        //Svar med Dev Stories metod
        println("Del 1 Dev Stories: ${listToInt.measurement()}")

        //Svar 2 med Dev Stories metod
        println("Del 2 Dev Stories: ${nm.tripleNumList(listToInt).measurement()}")

        println("From Jetbrains Del 1:${listToInt.testFromJetBrainsDel1()}")

        println("From Jetbrains: Del 2:${listToInt.testFromJetBrainsDel2()}")



    } catch (e: Exception) {
        e.stackTrace
    }
}


//teknik från dev stories add man sätter list.measurement() så man få värde nummer som är högre än förra nummer
// Inner funktion är mitt Rekursion samband med list.measurement metod från dev stories
fun List<Int>.measurement(): Int {
    var count: Int = 0
    var nums = 0
    fun counter(counter: Int, toMax: Int): Int {
        //returnerar antal nummer som är Increment mellan 2 nummer
        return if (toMax == this.size - 1) counter
        else counter(
            if (this[toMax] < this[toMax + 1]) counter + 1 else counter, toMax + 1
        )
    }
    return counter(count, 0)
}

fun List<Int>.testFromJetBrainsDel1():Int {
    //funktionen tar 2 framme från listan och kallas resultat av window(2)
    return this.windowed(2).count { it[0] < it[3] }
}

fun List<Int>.testFromJetBrainsDel2():Int {
    //funktionen tar 3 framme från listan och kallas resultat av window(4)
    return this.windowed(4).count { it[0] < it[3] }
}