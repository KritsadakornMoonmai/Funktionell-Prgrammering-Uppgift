package Fråga2_2

import java.io.File

//Frågan tas från Advent of Code 2022 dag 2 både a och b delarna

enum class Choice {
    ROCK,
    PAPER,
    SCISSOR
}

enum class Result {
    WIN,
    LOSE,
    DRAW,
    NONE
}

class Fråga2_2Main {

    // Returnera enum Choice när karaktären sätter i funktionen. Används för både del 1 och del 2
    fun player1(mark: Char): Choice {

        if (mark == 'A') return Choice.ROCK
        else if (mark == 'B') return Choice.PAPER
        else return Choice.SCISSOR
    }
    // Returnera enum Choice när karaktären sätter i funktionen. Används för del 1
    fun player2(mark: Char): Choice {
        if (mark == 'X') return Choice.ROCK
        else if (mark == 'Y') return Choice.PAPER
        else return Choice.SCISSOR

    }
    //Returnera enum Result med funktion player 1 och player 2. Används för del 1
    fun rule(choice1: Choice, choice2: Choice): Result{
        return if (choice1 == Choice.ROCK && choice2 == Choice.PAPER) {
            Result.WIN
        } else if (choice1 == Choice.PAPER && choice2 == Choice.SCISSOR) {
            Result.WIN
        } else if (choice1 == Choice.SCISSOR && choice2 == Choice.ROCK) {
            Result.WIN
        } else if (choice1 == choice2) {
            Result.DRAW
        } else {
            Result.LOSE
        }
    }

    //Returnera värde för enum Choice man väljer. Används till del 2(troligtvis är också användbar i del 1
    // men jag skrev det efter jag klarade del1)
    fun markPoint(choices: Choice): Int {
        return if (choices == Choice.ROCK) 1 else if (choices == Choice.PAPER) 2 else 3
    }

    //Returnera värde för enum Result man väljer. Används till del 2(troligtvis är också användbar i del 1
    // men jag skrev det efter jag klarade del1)
    fun resultPoint(result: Result): Int {
        return if (result == Result.WIN) 6 else if (result == Result.DRAW) 3 else 0
    }

    //Förutser vad P2(spelaren) ska välja med P1 alternativ och resultat. Används för del 2
    fun predictedMark(choiceP1: Choice, result: Result): Choice {
        if (result == Result.DRAW)
            return choiceP1
        else if (result == Result.WIN)
            return Choice.entries[(Choice.entries.indexOf(choiceP1) + 1) % Choice.entries.size]
        else
            return Choice.entries[(Choice.entries.indexOf(choiceP1) + (Choice.entries.size - 1)) % Choice.entries.size]
    }

    //Används för att deklarera om P1 vinnar eller förlorar.
    // Funktionen sätts mittemot från P2 eftersom funktionen används för P1.
    // Används för del2
    fun rule2P1(result: Char): Result{
        return if (result == 'X') {
            Result.WIN
        } else if (result == 'Z') {
            Result.LOSE
        } else {
            Result.DRAW
        }
    }


    //Används för att deklarera om P2 vinnar eller förlorar.
    // Används för del2
    fun rule2P2(result: Char): Result{
        return if (result == 'X') {
            Result.LOSE
        } else if (result == 'Z') {
            Result.WIN
        } else {
            Result.DRAW
        }
    }

    //Huvudplattform för p1
    fun game(p1: List<Char>, p2: List<Char>): Int {
        var pointP1 = 0
        var pointP2 = 0
        for (i in 0..<p1.size) {
            fun givenPoint(choice: Choice): Int {
                return if (choice == Choice.ROCK) 1
                else if (choice == Choice.PAPER) 2
                else if (choice == Choice.SCISSOR) 3
                else 0
            }

            if (rule(player1(p1[i]), player2(p2[i])) == Result.WIN) {
                pointP2 += 6 + givenPoint(player2(p2[i]))
                pointP1 += givenPoint(player1(p1[i]))
            } else if (rule(player1(p1[i]), player2(p2[i])) == Result.LOSE) {
                pointP1 += 6 + givenPoint(player1(p1[i]))
                pointP2 += givenPoint(player2(p2[i]))
            } else {
                pointP1 += 3 + givenPoint(player1(p1[i]))
                pointP2 += 3 + givenPoint(player2(p2[i]))
            }
        }

        //println("Result P1: $pointP1 \nResult P2: $pointP2")

        return pointP2
    }

    //Prova med Mattias Schenk metod (when) kombineras med Dev stories från Fråga 3. Använd för del 1
    fun Char.P2Move(): Choice? {
        when (this) {
            'X' -> return Choice.ROCK
            'Y' -> return Choice.PAPER
            'Z' -> return Choice.SCISSOR

        }
        return null
    }

    fun Char.P2Predict(): Result {
        when (this) {
            'X' -> return Result.LOSE
            'Y' -> return Result.DRAW
            'Z' -> return Result.WIN
        }
        return Result.NONE
    }

    //Process med Mattias Schenk metod Använd för del 1
    fun gameEx(p1: List<Char>, p2: List<Char>): Int {
        var pointP1 = 0
        var pointP2 = 0
        for (i in 0..<p1.size) {
            fun givenPoint(choice: Choice): Int {
                return if (choice == Choice.ROCK) 1
                else if (choice == Choice.PAPER) 2
                else if (choice == Choice.SCISSOR) 3
                else 0
            }

            if (p2[i].P2Move()?.let { rule(player1(p1[i]), it) } == Result.WIN) {
                pointP2 += 6 + givenPoint(player2(p2[i]))
                pointP1 += givenPoint(player1(p1[i]))
            } else if (p2[i].P2Move()?.let { rule(player1(p1[i]), it) } == Result.LOSE) {
                pointP1 += 6 + givenPoint(player1(p1[i]))
                pointP2 += givenPoint(player2(p2[i]))
            } else {
                pointP1 += 3 + givenPoint(player1(p1[i]))
                pointP2 += 3 + givenPoint(player2(p2[i]))
            }
        }

        //println("Result P1: $pointP1 \nResult P2: $pointP2")

        return pointP2
    }



    //Huvudplattform för del2
    fun game2(p1: List<Char>, predictedResult: List<Char>): Int {
        var scoreP1: Int = 0
        var scoreP2: Int = 0

        for (i in p1.indices) {
            scoreP1 += resultPoint(rule2P1(predictedResult[i])) + markPoint(player1(p1[i]))
            scoreP2 += resultPoint(rule2P2(predictedResult[i])) + markPoint(predictedMark(player1(p1[i]), rule2P2(predictedResult[i])))
        }

        return scoreP2
    }

    fun game2Ex(p1: List<Char>, predictedResult: List<Char>): Int {
        var scoreP1: Int = 0
        var scoreP2: Int = 0

        for (i in p1.indices) {
            scoreP1 += resultPoint(rule2P1(predictedResult[i])) + markPoint(player1(p1[i]))
            scoreP2 += resultPoint(predictedResult[i].P2Predict()) + markPoint(predictedMark(player1(p1[i]), predictedResult[i].P2Predict()))
        }

        return scoreP2
    }


}


fun main() {
    var f2_2 = Fråga2_2Main()
    try {
        //file path
        val filepath = "src/main/kotlin/Fråga2_2/Input2_2"
        //Läser input från filen med bufferedReader
        fun Reader(file: String): String =
            File(file).bufferedReader().readLines().toString()

        //Skapa list för player 1 och player 2(eller resultat för P2)
        var toListP1: MutableList<Char> = mutableListOf()
        var toListP2: MutableList<Char> = mutableListOf()
        //addera till P1 list
        Reader(filepath).forEach { if (it == 'A' || it == 'B' || it == 'C') toListP1.add(it)}
        //addera till P2(eller resultat för P2) list
        Reader(filepath).forEach { if (it == 'X' || it == 'Y' || it == 'Z') toListP2.add(it)}

        //Skriva ut resultat för del 1
        println("My normal code: ${f2_2.game(toListP1, toListP2)}")
        //Resultat del 1 efter lösning
        println("From Ex : ${f2_2.gameEx(toListP1, toListP2)}")
        //Skriva ut resultat för del 2
        println("Puzzle2.2 = ${f2_2.game2(toListP1, toListP2)}")
        //Resultat del 2 efter lösning
        println("Puzzle2.2 Ex = ${f2_2.game2Ex(toListP1, toListP2)}")

        GinsbergMetod()




    } catch (e: Exception) {
        e.stackTrace
    }
}

fun GinsbergMetod() {

    //file path
    val filepath = "src/main/kotlin/Fråga2_2/Input2_2"
    //Läser input från filen med bufferedReader
    fun Reader(file: String): List<String> =
        File(file).bufferedReader().readLines()

    //Ginsberg metod skrev direkt värde och matchningskaraktär i variabeln. Han använder map och kombinerar värde

    var mapOfPart1: Map<String, Int> =
        mapOf(
            "A X" to 4,
            "A Y" to 8,
            "A Z" to 3,
            "B X" to 1,
            "B Y" to 5,
            "B Z" to 9,
            "C X" to 7,
            "C Y" to 2,
            "C Z" to 6,
        )
    //efter println ser kombination av nummer
    //println(mapOfPart1.values)
    //{A X=4, A Y=8, A Z=3, B X=1, B Y=5, B Z=9, C X=7, C Y=2, C Z=6}
    var sum: Int = 0
    Reader(filepath).forEach { if (it.equals(mapOfPart1.entries)) sum += mapOfPart1.values.count() }

    println("Ginsberg Svar del1: ${Reader(filepath).sumOf { mapOfPart1[it] ?: 0 }}")

}

