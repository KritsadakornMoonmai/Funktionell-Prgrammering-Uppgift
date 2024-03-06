package UnusedQuestions.Fråga3

import java.io.File

data class ways(val countries: String, val distances: Int)
class Funcs {
    fun readCountries(text: String) {
        var i: Int = 0
        var country = text.split(" = ")
        val deleteNewLine: MutableList<String> = mutableListOf()
        var cToC: MutableList<String> = mutableListOf()
        var distance: MutableList<String> = mutableListOf()
        for (a in country) {
            if (a.contains("\n")) {
                deleteNewLine += a.split('\n')
            } else if (a.contains(',')) {
                deleteNewLine += a.split(',')
            } else {
                deleteNewLine += a
            }
        }

        //println(deleteNewLine)

        for (i in deleteNewLine.indices) {
            if (i % 2 == 1) {
                distance.add(deleteNewLine[i])
            } else {
                cToC.add(deleteNewLine[i])
            }
        }


        println(cToC)
        println(distance)


        fun PlaceToPlace(): List<ways> = cToC.zip(distance) { cToC, distance -> ways(cToC, distance.toInt()) }

        //println(PlaceToPlace())
        println(PlaceToPlace().sortedBy { it.distances }.first())


    }
}
fun main() {
    var f3 = Funcs()

    try {
        val filepath = "src/main/kotlin/Fråga3/Fråga3Input"
        //Läser input från filen med bufferedReader
        fun Reader(file: String): String =
            File(file).bufferedReader().readLines().toString()

        var text = Reader(filepath).filter { it != '[' }.filter { it != ']' }

        //println(Reader(filepath))
        //println(text)

        f3.readCountries(text)

    } catch (e: Exception) {
        e.stackTrace
    }

}