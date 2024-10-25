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
val board = mutableListOf<String>()
var size = 0

fun main() {
    val players = initPlayers()
    initBoard()
    while (true) {
        for (player in players) {
            displayBoard()
            print("$player - select a coin to (re)move: ")
            while (moveCoin() != 1) {
                moveCoin()
            }
        }
    }
}

fun initPlayers(): MutableList<String> {
    val players = mutableListOf<String>()
    print("Player 1 - enter your name: ")
    players.add(readln())
    print("Player 2 - enter your name: ")
    players.add(readln())
    println("${players[0]} and ${players[1]} - welcome to Old Gold!")
    return players
}

fun initBoard() {
    print("Enter a board size: ")
    var tempSize = readln().toIntOrNull()
    while (tempSize == null || tempSize !in 3..999) {
        print("You can't play on a board of that size. Pick a different size: ")
        tempSize = readln().toIntOrNull()
    }
    size = tempSize

    print("How many coins would you like? ~${size / 2} recommended: ")
    var coins = readln().toIntOrNull()
    while (coins == null || coins !in 1..size) {
        print("You can't play with that number of coins. Pick a different amount:")
        coins = readln().toIntOrNull()
    }

    // Add coins in order then shuffle the board
    repeat(size - coins) { board.add("_") }
    repeat(coins - 1) { board.add("c") }
    board.add("g".yellow())
    board.shuffle()
}

fun displayBoard() {
    print(" ")
    for (i in 1..size) {
        if (i < 10) {print(" $i  ")}
        else {print("$i  ")}
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

fun moveCoin(): Int {
    var coinSlot = readln().toIntOrNull()
    while (coinSlot == null || coinSlot !in 1..size) {
        print("That slot doesn't exist. Please select a coin to (re)move: ")
        coinSlot = readln().toIntOrNull()
    }
    coinSlot -= 1 // -1 because zero indexing

    // Check to ensure valid move
    if (board[coinSlot] == "_") {
        print("Slot ${coinSlot+1} is empty. Please select a coin to (re)move: ")
        return 0
    }

    // Take coin off board if applicable
    if (coinSlot == 0) {
        when (board[coinSlot]) {
            "c" -> {board[0] = "_"; return 1}
            "g".yellow() -> return 2
        }
    }

    // Count how many slots the coin can be moved
    var freeSlots = 0
    for (i in (coinSlot - 1) downTo 0) {
        if (board[i] == "_") {freeSlots ++}
        else {
            break
        }
    }
    var moveSlot: Int?
    when (freeSlots) {
        0 -> {print("That coin has no valid moves. Try selecting a different coin to move:  "); return 0}
        1 -> moveSlot = coinSlot - 1
        else -> {
            print("Slot to move to: (down to slot ${coinSlot + 1 - freeSlots}): ")
            // Input validation
            moveSlot = readln().toIntOrNull()
            while (moveSlot == null || moveSlot !in 1..freeSlots) {
                print("You can't move to that slot. Try again: ")
                moveSlot = readln().toIntOrNull()
            }
            moveSlot -= 1
        }
    }

    board[moveSlot] = board[coinSlot]
    board[coinSlot] = "_"
    return 1
}