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
val coins = 7
val size = 16
val board = initBoard(size, coins)
fun main() {
    while (true) {
        displayBoard()
        moveCoin()
    }
}

fun initBoard(size: Int, coins: Int): MutableList<Char> {
    val board = mutableListOf<Char>()
    // Add coins in order then shuffle the board
    repeat(size - coins) { board.add('_') }
    repeat(coins - 1) { board.add('c') }
    board.add('g')
    board.shuffle()
    return board
}

fun displayBoard() {
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

fun moveCoin() {
    print("Move coin number: ")
    val coinSlot = readln().toInt() - 1 // -1 because zero indexing

    // Take coin off board
    if (coinSlot == 0) {
        board[0] = '_'
        return
    }

    // Count how many slots the coin can be moved
    var freeSlots = 0
    for (i in (coinSlot - 1) downTo 0) {
        if (board[i] == '_') {freeSlots ++}
        else {
            println()
            break
        }
    }
    when (freeSlots) {
        0 -> {println("Invalid move -_-"); return}
        else -> print("Slots to move left (max of $freeSlots): ")
    }
    val slots = readln().toInt() // Input validation!
    board[coinSlot - slots] =  board[coinSlot]
    board[coinSlot] = '_'
}