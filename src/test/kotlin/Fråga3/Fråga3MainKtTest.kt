package Fråga3

import Fråga3New.NewMain
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class Fråga3MainKtTest {

    var input: List<Int> = listOf(199,200,208,210,200,207,240,269,260,263)
    @Test
    fun measureTest() {
        var m3 = NewMain()

        println(m3.measurement(input))

        assertTrue(m3.measurement(input) == 7)
    }

    @Test
    fun tripleTest() {
        var m3 = NewMain()

        println(m3.measurement(m3.tripleNumList(input)))
        //assertTrue(m3.measurement(m3.tripleNumList(input)) == 5)
    }


}
