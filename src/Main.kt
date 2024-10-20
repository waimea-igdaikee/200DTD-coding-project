/**
 * ------------------------------------------------------------------------
 * PROJECT NAME HERE
 * Level 2 programming project
 *
 * by YOUR NAME HERE
 *
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * BRIEF PROJECT DESCRIPTION HERE
 * ------------------------------------------------------------------------
 */

val coins = 5
val size = 12
fun main() {
    val board = initBoard(size, coins)
    displayBoard(board)
}


fun initBoard(size: Int, coins: Int): Map<Int, Char> {
    val board = mutableMapOf<Int, Char>()
    repeat(size) { i -> board[i] = '_' }

    // Coin init - inits and shuffles a list from 1 to size then inserts coins in these spots
    val coinPositions = mutableListOf<Int>()
    repeat(size-1) { index -> coinPositions.add(index + 1) }
    coinPositions.shuffle()
    board[coinPositions[0]] = 'g'
    repeat(coins - 1) { i -> board[coinPositions[i + 1]] = 'c' }
    return(board)
}

fun displayBoard(board: Map<Int, Char>) {
    print(" ")
    for (i in 1..size) {
        if (i < 10) {print(" ${i}  ")}
        else {print("${i}  ")}
    }
    println()
    
    print("┌─")
    repeat(size-1) {print("──┬─")}
    println("──┐")

    print("│")
    repeat(size) { i -> print(" ${board[i]} │")}
    println()
    
    print("└─")
    repeat(size-1) {print("──┴─")}
    println("──┘")
}
