const val GREEN = 0
const val YELLOW = 1
const val RED = 2

class Solution {
    fun solution(signals: Array<IntArray>): Int {
        var notFound: Int = -1

        val n = signals.size
        val signalList = Array(n) {
            Signal(signals[it])
        }

        var lcmOfCycle = signalList[0].cycle
        for (i in 1 until n) {
            lcmOfCycle = lcm(lcmOfCycle, signalList[i].cycle)
        }

        secondLoop@ for (second in 1..lcmOfCycle) {
            for (signal in signalList) {
                if (signal.getColor(second) != YELLOW) {
                    continue@secondLoop
                }
            }
            return second
        }

        return notFound
    }
}

class Signal(val periods: IntArray) {
    val cycle = periods[GREEN] + periods[YELLOW] + periods[RED]

    fun getColor(second: Int): Int {
        val remainder = second % cycle
        return when {
            (0 < remainder) && (remainder <= periods[GREEN]) -> GREEN
            (periods[GREEN] < remainder) && (remainder <= periods[GREEN] + periods[YELLOW]) -> YELLOW
            else -> RED
        }
    }
}

fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
fun lcm(a: Int, b: Int): Int = (a * b) / gcd(a, b)