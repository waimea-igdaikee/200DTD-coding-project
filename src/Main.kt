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


/**
 * Program entry point
 */
val coins = 4
fun main() {
    val board = initBoard(10, coins)
    displayBoard(board)
}


fun initBoard(size: Int, coins: Int): Map<Int, Char> {
    val board = mutableMapOf<Int, Char>()
    repeat(size) { i -> board[i + 1] = '_' }

    // Coin init - inits and shuffles a list from 1 to size then inserts coins in these spots
    val coinPositions = mutableListOf<Int>()
    repeat(size) { index -> coinPositions.add(index + 1) }
    coinPositions.shuffle()
    board[coinPositions[1]] = 'g'
    repeat(coins - 1) { i -> board[coinPositions[i + 2]] = 'c' }
    return(board)
}

fun displayBoard(board: Map<Int, Char>) {
    print("┌")
    repeat(coins) {print("─")}
    println("┐")

    print("│")
    repeat(coins)
}






//    val board = mutableListOf<String>()
//    repeat(size) {board.add("_")} // Add size amount of spaces
//
//    // Coin init
















