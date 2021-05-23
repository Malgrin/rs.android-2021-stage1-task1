package subtask1

/*  Массив целых чисел «печален», поскольку содержит плохие элементы.
    Элемент массива считается плохим, если сумма ближайших элементов меньше его значения.
* */

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray): IntArray {
        val buffer = sadArray.toMutableList()
        var sad = true
        while (sad && buffer.size > 2) {
            for (i in 1..buffer.size - 2) {
                if (buffer[i] > buffer[i - 1] + buffer[i + 1]) {
                    buffer.removeAt(i)
                    break
                } else if (i == buffer.size - 2 || buffer.size < 3){
                    sad = false
                }
            }
        }
        return buffer.toIntArray()
    }
}

