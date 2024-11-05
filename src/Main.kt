/**
 * ------------------------------------------------------------------------
 * Old Gold
 * Level 2 programming project
 *
 * by Indiana Daikee
 *
 * This project is a kotlin implementation of the two-player game 'Old Gold'. The game consists
 * of a 1-dimensional board of coins, one of which is gold. Players take turns moving a coin any
 * number of spaces left, though they cannot jump over other coins. A coin can be removed from
 * the board if it is in the leftmost slot. The winner is whoever removes the gold coin.
 * ------------------------------------------------------------------------
 */

val board = mutableListOf<String>()
var size = 0

fun main() {
    var success: Int
    val players = initPlayers()
    val winner: String
    initBoard()
    gameLoop@ while (true) {
        for (player in players) {
            displayBoard()
            print("$player - select a coin to (re)move: ")
            success = moveCoin()
            while (success == 0) {
                success = moveCoin()
            }

            // if success == 1 {move to next player's turn}

            if (success == 2) { // moveCoin() returns 2 when a player wins
                winner = player
                break@gameLoop
            }
        }
    }
    print("$winner has " +  "won the game!".yellow())
}

fun initPlayers(): MutableList<String> {
    val players = mutableListOf<String>()
    var player = ""
    while (player.isBlank()) {
        print("Player 1".blue() + " - enter your name: ")
        player = readln()
    }
    players.add(player.blue())

    player = ""
    while (player.isBlank()) {
        print("Player 2".red() + " - enter your name: ")
        player = readln()
    }
    players.add(player.red())

    println("${players[0]} and ${players[1]} - welcome to Old Gold!")
    return players
}

fun initBoard() {
    print("Enter a board size (~16 recommended): ")
    // a local variable `inputSize` is used because we don't to write to the
    // global variable `size` until we are sure it is valid
    var inputSize = readln().toIntOrNull()
    while (inputSize == null || inputSize !in 3..99) {
        print("You can't play on a board of that size. Pick a different size: ")
        inputSize = readln().toIntOrNull()
    }
    size = inputSize
    val suitableCoins = (size / 2.5).toInt() // I found this to be a good proportion of coins
    print("How many coins would you like (~$suitableCoins recommended): ")
    var coins = readln().toIntOrNull()
    while (coins == null || coins !in 1..size) {
        print("You can't play with that number of coins. Pick a different amount: ")
        coins = readln().toIntOrNull()
    }

    // Add coins in order then shuffle the board to randomize it
    board.add("⭘".yellow())
    repeat(size - coins) { board.add("_") }
    repeat(coins - 1) { board.add("⭘") }
    while (board[0] == "⭘".yellow()) { // Ensures that the game won't start with gold on slot 1
        board.shuffle()
    }

}

fun displayBoard() {
    // Prints the number row above the board
    print(" ")
    for (i in 1..size) {
        if (i < 10) {print(" $i  ")}
        else {print("$i  ")}
    }
    println()

    // Prints the actual board and the coins on it

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
    coinSlot -= 1 // -1 because of zero indexing

    // Check to ensure valid move
    if (board[coinSlot] == "_") {
        print("Slot ${coinSlot+1} is empty. Please select a coin to (re)move: ")
        return 0
    }

    // Take coin off board if applicable
    if (coinSlot == 0) {
        when (board[coinSlot]) {
            "⭘" -> {board[0] = "_"; return 1}
            "⭘".yellow() -> return 2
        }
    }

    // Count how many slots the coin can be moved
    var freeSlots = 0
    for (i in (coinSlot - 1) downTo 0) {
        if (board[i] == "_") {freeSlots ++}
        else {break}
    }
    var moveSlot: Int?
    when (freeSlots) {
        0 -> {print("That coin has no valid moves. Try selecting a different coin to move: "); return 0}
        1 -> moveSlot = coinSlot - 1
        else -> {
            val maxSlot = coinSlot - freeSlots + 1
            print("Slot to move to (maximum down to slot ${maxSlot }): ")
            // Input validation
            moveSlot = readln().toIntOrNull()
            while (moveSlot == null || moveSlot !in maxSlot..coinSlot) {
                print("You can't move to that slot. Try again: ")
                moveSlot = readln().toIntOrNull()
            }
            moveSlot -= 1
        }
    }
    // Actually move the coin
    board[moveSlot] = board[coinSlot]
    board[coinSlot] = "_"
    return 1
}