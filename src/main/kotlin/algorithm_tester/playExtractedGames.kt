package algorithm_tester

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking


///**
// * Plays extracted games, catching [IllegalMoveException]s.
// *
// * If an [IllegalMoveException] is caught, prints to the console that that move in the game was illegal.
// *
// * At the end of playing all games, returns the percentage of successfully played games.
// * @return percentage of successfully played games
// */
//fun MonthExtraction.playExtractedGames(): Float {
//    var successfullyPlayedGames = 0
//
//    games.forEachIndexed { gameNum, extractedGame ->
//        try {
//            if (extractedGame.movesToMake.isNotEmpty())
//                extractedGame.game.makeMoves(extractedGame.movesToMake.split(" "))
//
//            successfullyPlayedGames++
//        } catch (err: IllegalMoveException) {
//            println("\nMonth $month - Move \"${err.move}\" in game ${gameNum + 1} considered illegal: ${err.message}")
//        }
//    }
//
//    val percentage = (successfullyPlayedGames.toFloat() / games.size * 100)
//
//    return percentage.takeUnless { it.isNaN() } ?: 100.0f
//}
//
///**
// * Plays extracted games.
// * 
// * Uses multi-threading to play multiple games at once.
// *
// * @return percentage of successfully played games
// */
//fun PlayerExtraction.playExtractedGames() =
//    runBlocking(Dispatchers.Default) {
//        monthExtractions.map {
//            async {
//                it.playExtractedGames()
//            }
//        }.awaitAll().average()
//    }
