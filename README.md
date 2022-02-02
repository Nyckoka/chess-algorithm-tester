# Chess Games Extractor
Extracts chess games to a file.

The main goal is presenting an easy way to test your chess algorithm, for any special cases, by sending thousands of
games to you for you to use as you please (but specially testing your chess algorithm).

<!--Instructions of what you may want to implement to use said games for tests are presented in this README. -->

All games are taken from Chess.com by using the official [Chess.com API](https://www.chess.com/news/view/published-data-api).

# Instructions
Just run the .jar with the argument being how many games you want to obtain, and the .txt with all the games
will appear in the location the .jar was executed.

<!--
# Options
Whether you'll be able to immediately start testing depends entirely on the options you choose and if those options are
the adequate ones for the chess algorithm you implemented.

### Show Check/Checkmate characters
If each move comes with the information on whether the move is a move for a check
or checkmate. This information id displayed through the characters '+', for check and '#' for checkmate.

### Full move information
If the move comes with the full information, including full 'from' position and 'to' position.

Example: First move of the game, played by white, is Pawn from e2 to e4.
A full information representation of the move is "Pe2e4", but the move can be identified by "e4".

**NOT IMPLEMENTED FOR NOW! ALL MOVES COME DIRECTLY FROM CHESS.COM API, AND DO NOT COME WITH THE
FULL INFORMATION.**
-->


# Why
I myself (plus my group) made a chess game/algorithm as a project for college,
more specifically for the subject of "Software Development Techniques", where testing was an important part of the
goals of that subject. Unit tests where a thing we used a lot, of course, and every software developer should use them
to assure a good functioning of each part of the code.

However, since I'm a perfectionist, I wasn't too fond of only testing my chess algorithm though unit tests, as a lot of
specific cases still might not be tested for. And chess has the possibility of basically infinite different games.
The solution was implementing this exact code, were data from Chess.com API is retrieved, and then creating a simple
function to play the moves in order. [This is the chess project in question]() (Still not available)



