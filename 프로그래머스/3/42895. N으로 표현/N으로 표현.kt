fun main() {
    println(Solution().solution(5, 12))
    //println(Solution().solution(3, 11))
}

val minRecord = mutableMapOf<Int, Int>() // <node.number, node.depth> 저장
val queue = SmartQueue()

class Solution {
    fun solution(N: Int, number: Int): Int {
        queue.addIfNeeded(Node(N, 1))
        while (!queue.isEmpty()) {
            val node = queue.remove()
            addNexts(node, N)
        }

        // log
        minRecord.forEach { (key, value) ->
            println("$key: $value")
        }

        minRecord.forEach { (number, depth) ->
            queue.add(Node(number, depth))
        }
        while (!queue.isEmpty()) {
            val node = queue.remove()
            addNexts2(node)
        }

        return minRecord[number] ?: -1
    }
}

data class Node(
    val number: Int,
    val depth: Int
)

class SmartQueue {
    private val queue = ArrayDeque<Node>()

    fun addIfNeeded(node: Node) {
        if (isAddNeeded(node)) {
            queue.add(node)
            minRecord[node.number] = node.depth
        }
    }

    fun add(node: Node) {
        queue.add(node)
        minRecord[node.number] = node.depth
    }

    fun remove(): Node {
        return queue.removeFirst()
    }

    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }

    private fun isAddNeeded(new: Node): Boolean {
        return (minRecord[new.number] == null) // queue에 들어온 적 없거나
                || (new.depth < (minRecord[new.number]!!)) // depth 갱신이 필요한 경우
    }
}

fun addNexts(old: Node, N: Int) {
    val depth = old.depth + 1
    if (8 < depth) {
        return
    }
    queue.addIfNeeded(Node(old.number + N, depth))
    queue.addIfNeeded(Node(old.number - N, depth))
    queue.addIfNeeded(Node(old.number * N, depth))
    queue.addIfNeeded(Node(old.number / N, depth))
    queue.addIfNeeded(Node(getRepeatedNumber(N, depth), depth))
}

fun addNexts2(old: Node) {
    val oldNumber = old.number
    val oldDepth = old.depth

    minRecord.filter { new ->
        val newDepth = new.value
        old.depth + newDepth <= 8
    }.forEach { new ->
        val newNumber = new.key
        val newDepth = new.value
        val nextDepth = oldDepth + newDepth

        queue.addIfNeeded(Node(oldNumber + newNumber, nextDepth))
        queue.addIfNeeded(Node(oldNumber - newNumber, nextDepth))
        queue.addIfNeeded(Node(oldNumber * newNumber, nextDepth))
        if(newNumber != 0) {
            queue.addIfNeeded(Node(oldNumber / newNumber, nextDepth))
        }
    }
}

fun getRepeatedNumber(N: Int, depth: Int): Int {
    var result = 0
    for (i: Int in 1..depth) {
        var operand = 1
        repeat(i - 1) {
            operand *= 10
        }
        result += N * operand
    }
    return result
}