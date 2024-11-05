# Test Plan and Evidence / Results of Testing

## Game Description

The project involves the programming of the two player game 'Old Gold'. The game is played on a one-dimensional board with coins randomly distributed across it. Players take turns moving a coin any amount of spaces to the left without jumping over other coins. If a coin is in the leftmost slot it can be removed from the board. There is also one gold coin on the board - and the player to remove from the board it is the winner.

### Game Features and Rules

When the game is run, players enter:
- Their names
- The size of the board they want to play on
- The amount of coins they would like to use

Players take turns making moves. A move consists of the player either moving a coin left, or removing it from the board. Below are the rules regarding these moves:

Moving coins left. Any coin can be moved if it has at least one valid slot to move to. A slot is valid if:
- It if left of the coin being moved
- It is empty
- There are no other coins between it and the coin being moved

Removing coins:
- Any coin in slot 1 (the leftmost slot) can be removed from the board.
- If a player removes the gold coin, they win the game.

---

## Test Plan

The following game features / functionality and player actions will need to be tested:

- Initialisation; the setup of the players' names and the placement of coins on the board
  - Initialisation of player names
  - Initialisation of board
- Game functionality; players taking turns making moves.
  - Moving coins left
  - Removing coins from the left-most slot
  - Players taking turns
- Win state

The following tests will be run against the completed game. The tests should result in the expected outcomes shown.


### Initialisation of player names

Checking that the setup of the players works as intended.

#### Test Data / Actions to Use

- Expected inputs (e.g. John, Dave)
- The edge case of a one character name (as players could choose to use initials or numbers instead of names)
- Pressing enter without typing anything

#### Expected Outcome

Provided the players type something (a name, number, initial, etc.) the game should progress as usual after getting names from both players. If the player hits enter without typing anything, the game should keep asking the player for their name until they enter a valid result.

### Initialisation of the board

Checking the board gets correctly configured and set up.

#### Test Data / Actions to Use

The game will ask the players what board size and amount of coins to use. I'll need to test:
- Expected inputs, (e.g. 16 slots and 6 coins)
- Invalid inputs (e.g 5 slots and 10 coins, < 3 slots, 0 coins, > 99 slots)
- Edge case inputs of:
  - 3 slots (the minimum)
  - 99 slots (the maximum)
  - 1 coin
  - Same amount of coins as slots (both this and 1 coin would make for quite stale gameplay, but there's no reason you shouldn't be able to play with these setups - perhaps they'd result in interesting strategies?)

#### Expected Outcome

Provided the players enter a valid number for the amount of slots and coins to play with, the game should start; player 1 should be asked what move they would like to make. If the player enters an invalid number of slots or coins, the game should tell that exactly what is wrong (e.g. "you can't have more coins that slots. 5 coins is recommended") so they know how to fix that issue. If the player accidentally hits enter before entering a number, the game should ask again.

The game also shouldn't start the board with the gold coin on slot 1 - this wouldn't even give the other player a chance.

### (Re)moving coins

The player should be able to pick a coin to remove from the board or move a chosen amount of spaces left (only if the move is valid though)

#### Test Data / Actions to Use

- Valid moves
  - Removing a coin from slot 1
  - Moving a coin a given amount of slots left. This includes edge cases, such as
    - If it is the only valid move, moving a coin 1 slot left
    - Moving a coin 1 slot left if there are multiple valid moves
    - Moving a coin as far as left as validly possible
- Invalid moves
    - Moving a coin that doesn't exist
    - Moving a coin to the right
    - Moving a coin 0 slots
    - Moving to a slot that already has a coin in it
    - Jumping over another coin
    - Moving a coin that has no valid moves
    - Moving a coin to a slot that doesn't exist

#### Expected Outcome

If picked coin has only 1 valid move, this should immediately be carried out without error.

If the picked coin has multiple valid moves, the player should be asked which slot to move the coin to.

If the picked coin doesn't exist, has no valid moves, or the player attempts to make an invalid move, the game should tell the player that their move is invalid, and that they should try a different move.


### Taking turns

Once player 1 has made a valid move, player 2 should be prompted to move, then player 1 and so on until somebody wins.

#### Test Data / Actions to Use

Each player will make a move, one after the other until for multiple rounds.

#### Expected Outcome

Once player 1 makes their move, the game should prompt player 2 to move, then player 1 and so on. This should continue until either player wins by removing the gold coin from the board.

### Winning the game

Once a player removes the gold coin from the board, the game should show which player won, then stop.

#### Test Data / Actions to Use

Playing multiple games resulting in either player winning. (Checking that both player 1 and 2 are able to win)

#### Expected Outcome

When a player wins by removing the gold coin from the board, the game should show that player won, then stop.


---


## Evidence / Results of Testing

### Setup of players

As the video below shows, the setup of players works as expected.

[oldgold_players.mkv](media%2Foldgold_players.mkv)


### Setup and configuration of bard

As seen in the videos below, the setup and player-configuration of the board works as intended.

[oldgold_board.mkv](media%2Foldgold_board.mkv)  
[oldgold_board2.mp4](media%2Foldgold_board2.mp4)

### (Re)moving coins

The video below shows that moving and removing coins, as well as attempting lots of invalid moves, all works properly.

[oldgold_moving.mp4](media%2Foldgold_moving.mp4)


### Taking turns

The video below shows that the turn-based system works properly.

[oldgold_turns.mkv](media%2Foldgold_turns.mkv)

### Winning

The video below (same video as above) also shows that the game responds as expected when either player wins.

[oldgold_turns.mkv](media%2Foldgold_turns.mkv)