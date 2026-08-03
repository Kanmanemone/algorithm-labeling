class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var maxLongSideLength = -1
        var maxShortSideLength = -1
        
        for((w, h) in sizes) {       
            maxLongSideLength = maxOf(maxLongSideLength, maxOf(w, h))
            maxShortSideLength = maxOf(maxShortSideLength, minOf(w, h))
        }

        return maxLongSideLength * maxShortSideLength
    }
}