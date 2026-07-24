/* <헷갈리는 조건>
메시지의 스포 방지 구간이 아닌 구간
(= 어떤 스포 방지 구간에도 속하지 않는 모든 구간: 각 구간의 앞·사이·뒤 포함)
에 등장한 적이 없어야 합니다.
*/

const val START = 0
const val END = 1

class Solution {
    fun solution(message: String, spoiler_ranges: Array<IntArray>): Int {
        val wordValues = message.split(" ")
        val exposedWordValueSet = LinkedHashSet<String>()

        var startIndex = 0
        val words = Array(wordValues.size) {
            val wordValue = wordValues[it]
            
            val word = Word(wordValues[it], startIndex, startIndex + wordValue.length - 1)
            word.setSpoilerPrevented(spoiler_ranges)
            if (!word.isSpoilerPrevented) {
                exposedWordValueSet.add(word.value)
            }

            startIndex += wordValue.length + 1

            word
        }

        for (word in words) {
            if (!word.isSpoilerPrevented) {
                continue
            }

            if (exposedWordValueSet.contains(word.value)) {
                continue
            } else {
                exposedWordValueSet.add(word.value)
            }

            word.isImportant = true
        }

        return words.count { it.isImportant }
    }
}

class Word(val value: String, val startIndex: Int, val endIndex: Int) {
    var isSpoilerPrevented = false
    var isImportant = false

    fun setSpoilerPrevented(spoiler_ranges: Array<IntArray>) {
        for (spoiler_range in spoiler_ranges) {
            if ((startIndex <= spoiler_range[END]) && (endIndex >= spoiler_range[START])) {
                isSpoilerPrevented = true
                return
            }
        }
        isSpoilerPrevented = false
    }
}