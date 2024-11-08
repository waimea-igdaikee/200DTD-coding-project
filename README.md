# Old Gold

### Level 2 Programming Project by Indiana Daikee

This project is assessed against [AS91896](https://www.nzqa.govt.nz/nqfdocs/ncea-resource/achievements/2019/as91896.pdf)

## Project Description

This project is a kotlin implementation of the two-player game 'Old Gold'. The game consists of a 1-dimensional board of coins, one of which is gold. Players take turns moving a coin any number of spaces left, though they cannot jump over other coins. Any coin can be removed from the board if it is in the leftmost slot. The winner is whoever removes the gold coin.


## Source Code

The project is written in [Kotlin](https://kotlinlang.org/)

The main source file is [Main.kt](src/Main.kt)


## Documentation

Evidence of testing can be found in [testing.md](testing.md)


## Running the Program

You can either clone this whole repo, open it using [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) and run from source; or you can run the compiled program:

1. Install the [Java runtime (JRE)](https://www.java.com/en/download/) installed to run the program.
2. Go to the [out/artifacts](out/artifacts) folder
3. Locate and download the compiled **JAR file** (e.g. FILENAME.jar)
4. Run the following command:
    ```bash
    java -jar FILENAME.jar
    ```
