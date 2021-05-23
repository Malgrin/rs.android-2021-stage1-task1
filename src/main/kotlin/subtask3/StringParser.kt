package subtask3

/*  Дана строка с открывающими-закрывающими скобками, то есть [], <> или (). Найдите все подстроки подстроки,
которые встречаются между скобками.
Обратите внимание, что подстрока должна находиться между первой встреченной открытой и закрывающей скобками.
Например, для «(вот) какой-то текст)» ввод будет «вот», а не «(вот) какой-то текст)» из-за второй скобки «)».

Вход: строка, которая может содержать следующие скобки: [], <>, ()

Выход: массив строк. Каждый элемент массива должен содержать подстроку между открывающей-закрывающей скобкой.

Пример ввода:

«Это [пример] (строка)»

Пример вывода:

[«Ан», «пример», «строка»]

Nota Bene: Пожалуйста, не забывайте обрабатывать ситуацию с вложенными скобками (например, «(ipsum [dolor <] amet)>»).
* */

class StringParser {

    // TODO: Complete the following function
    fun getResult(inputString: String): Array<String> {
        val buffer = mutableListOf<String>()
        var treatStr: String
        var symbolEnd: Char
        var symbolStart: Char
        var index = 0
        var check = 0
        for (i in inputString.indices) {
            if (inputString[i] == '(' || inputString[i] == '<' || inputString[i] == '[') {
                symbolStart = inputString[i]
                symbolEnd = if (symbolStart == '(') {
                    inputString[i] + 1
                } else {
                    inputString[i] + 2
                }

                treatStr = inputString.substring(i + 1)
                for (y in treatStr.indices) {
                    if (treatStr[y] == symbolStart) {
                        check += 1
                    }
                }
                for (j in treatStr.indices) {

                    if (treatStr[j] == symbolEnd) {
                        check -= 1
                        if (check == 0 || check == -1) {
                            index = j
                            check = 0
                            break
                        }
                    }
                }
                buffer.add(treatStr.substring(0,index))
            }

        }
        for (i in buffer.indices) {
            println(buffer[i])
        }
        return buffer.toTypedArray()
    }
}
