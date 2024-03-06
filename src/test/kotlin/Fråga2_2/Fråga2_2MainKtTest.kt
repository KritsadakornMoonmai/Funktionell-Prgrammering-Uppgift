package Fråga2_2

import Fråga2_2.Result
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class Fråga2_2MainKtTest {

    val mark = "A Y\n" +
            "B X\n" +
            "C Z"


    @Test
    fun enumIndexTest() {


        println(Choice.entries.get(0))
        println()
        //if (f2_2.player1() == f2_2.player2())
    }
    @Test
    fun winOrLoseTest() {
        var f2_2 = Fråga2_2Main()

        assertTrue(f2_2.rule(Choice.ROCK, Choice.PAPER) == Result.WIN)
        assertTrue(f2_2.rule(Choice.SCISSOR, Choice.ROCK) == Result.WIN)
        assertTrue(f2_2.rule(Choice.ROCK, Choice.ROCK) == Result.DRAW)
        assertFalse(f2_2.rule(Choice.ROCK, Choice.ROCK) == Result.WIN)
        assertFalse(f2_2.rule(Choice.ROCK, Choice.PAPER) == Result.LOSE)
    }

    @Test
    fun gameTest() {
        var f2_2 = Fråga2_2Main()
        var toList: MutableList<Char> = mutableListOf()
        mark.forEach { if (it != ' ' && it != '\n') toList.add(it) }

        var p1List: MutableList<Char> = mutableListOf()
        var p2List: MutableList<Char> = mutableListOf()

        fun Char.P2Move(): Choice? {
            when (this) {
                'X' -> return Choice.ROCK
                'Y' -> return Choice.PAPER
                'Z' -> return Choice.SCISSOR

            }
            return null
        }


        for (i in 0..<toList.size) {
            if (i % 2 == 0) {
                p1List.add(toList[i])

            } else {
                p2List.add(toList[i])
            }
        }
        println("P1:${p1List}")
        println("P2:$p2List")
        println("P2M${ p2List[0].P2Move() }")
        println(f2_2.game(p1List, p2List))

        assertTrue(f2_2.game(p1List, p2List) == 15)
    }

    @Test
    fun PresdictedMarkTest() {
        var f2_2 = Fråga2_2Main()

        println(f2_2.predictedMark(Choice.ROCK, Result.WIN).name)
        println(f2_2.predictedMark(Choice.ROCK, Result.LOSE).name)
        println(f2_2.predictedMark(Choice.ROCK, Result.DRAW).name)
        println(f2_2.predictedMark(Choice.SCISSOR, Result.WIN).name)

        assertTrue(f2_2.predictedMark(Choice.ROCK, Result.WIN) == Choice.PAPER)
        assertTrue(f2_2.predictedMark(Choice.SCISSOR, Result.WIN) == Choice.ROCK)
    }
}