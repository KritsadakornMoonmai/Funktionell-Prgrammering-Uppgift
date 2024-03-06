package UnusedQuestions.Fråga2

class RowsAndColsClass(var rows:Int, var columns:Int, val lists: List<Char>) {
    var f2M = Fråga2Main()
    fun getNewRows(value: Int): RowsAndColsClass {
        var newRow:Int = this.rows + value
        return RowsAndColsClass(newRow, columns, lists)
    }

    fun getNewCol(value: Int): RowsAndColsClass {
        var newColumn:Int = this.columns + value
        return RowsAndColsClass(rows, newColumn, lists)
    }

    fun getValue(): Char {
        println("Get row: ${this.rows}")
        println("Get col: ${this.columns}")
        return f2M.findElementInRowAndCol(this, this.rows, this.columns)
    }
}

class Fråga2Main {

    fun alfabetArray(input: String): List<Char> {
        var alf: MutableList<Char> = mutableListOf()

        for (i in input) {
            alf.add(i)
        }
        return alf
    }

    fun rowAndCol(lists: List<Char>): RowsAndColsClass {
        var row: Int = 1
        var column: Int = 1

        for (element in lists) {
            if (element == '\n') {
                row += 1
                column = 0
            } else {
                column += 1
            }
        }
        return RowsAndColsClass(row, column, lists)
    }

    fun findElementInRowAndCol(rowsAndCols: RowsAndColsClass, inputRow:Int, inputColumn: Int): Char {
        var position: Int
        if (inputRow > 1 && inputRow == 2 && inputColumn < rowsAndCols.columns) {
            position = ((inputRow - 1) * rowsAndCols.columns) + inputColumn
            println("if:$position")
        } else if (inputRow > 2) {
            position = ((inputRow - 1) * rowsAndCols.columns) + inputColumn + (inputRow - 2)
            println("elif:$position")
        /*} else if (inputRow > 2 && inputColumn == rowsAndCols.colums) {
                position = ((inputRow - 1) * rowsAndCols.colums + 1) + inputColumn
                println("elif2:$position")*/
        } else {
            position = inputRow * inputColumn - 1
            println("else:$position")
        }

        println("$inputRow $inputColumn")
        return rowsAndCols.lists[position]
    }

    fun getCounter(num: Int): Int {
        return num
    }

    fun moveSet(rowsAndCols: RowsAndColsClass): RowsAndColsClass {
        var charList: List<Char> = listOf('S','a','b','c','d','e','f','g','h','i','j','k','l','m',
            'n','o','p','q','r','s','t','u','v','w','x','y','z','E')
        var rAndC: RowsAndColsClass = rowsAndCols
        var count: Int = 0
        var value:Char = 'S'
        while (value != 'E') {
            println(charList.size)
            println("round")
            var up: RowsAndColsClass = rAndC.getNewRows(-1)
            var left: RowsAndColsClass = rAndC.getNewCol(-1)
            var right: RowsAndColsClass = rAndC.getNewCol(+1)
            var down: RowsAndColsClass = rAndC.getNewRows(+1)
            for (i in charList.indices) {
                if (up.rows != 0) {
                    if (up.getValue() == charList[i + 1] || up.getValue() == charList[i]) {
                        println("In Up")
                        value = up.getValue()
                        count += 1
                        break
                    } else {
                        rAndC = down
                        value = down.getValue()
                        count -= 1
                        break
                    }
                } else if (left.columns != 0) {
                    if (left.getValue() == charList[i + 1] || left.getValue() == charList[i]) {
                        println("In left")
                        rAndC = left
                        value = left.getValue()
                        count += 1
                        break
                    } else {
                        rAndC = right
                        value = right.getValue()
                        count -= 1
                        break
                    }
                } else if (right.columns != 0) {
                    if (right.getValue() == charList[i + 1] || right.getValue() == charList[i]) {
                        println("In right")
                        rAndC = left
                        value = left.getValue()
                        count += 1
                        break
                    } else {
                        rAndC = left
                        value = left.getValue()
                        count -= 1
                        break
                    }
                } else if (down.rows != 0) {
                    if (down.getValue() == charList[i + 1] || down.getValue() == charList[i]) {
                        println("In down")
                        rAndC = down
                        value = down.getValue()
                        count += 1
                        break
                    } else {
                        rAndC = up
                        value = up.getValue()
                        count -= 1
                        break
                    }
                }
            }

        }
        println("C: "+count)
        return rAndC
    }
    fun Switch(input: String) {
        var counter: Int = 0
        var count: Int = 0
        var savedChar: Char = ' '
        for (a in 'a'..'z') {

        }

    }
}

fun main() {

}