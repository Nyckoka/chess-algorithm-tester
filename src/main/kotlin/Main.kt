import algorithm_tester.extractNGamesFromPGN
import algorithm_tester.getMonthPGNList
import algorithm_tester.getMonthlyArchives
import algorithm_tester.getPlayersFromTitle
import kotlinx.coroutines.*
import java.io.File

const val DEFAULT_NUMBER_OF_GAMES = 100

fun main(vararg args: String) {
    require(args.size in 0..1) { "At most 1 argument accepted: number of games to extract" }

    val numberOfGames = if (args.size == 1) args[0].toIntOrNull() else DEFAULT_NUMBER_OF_GAMES

    require(numberOfGames != null) { "Number of games to extract should be an integer." }
    require(numberOfGames in 0..10000) { "The number of games should be at max 10000." }

    extractNGames(numberOfGames)
}


fun extractNGames(numberOfGames: Int) {
    val grandMasters = getPlayersFromTitle("GM").take(1)

    val monthlyArchives = grandMasters.flatMap { getMonthlyArchives(it) }
    val pgnList = monthlyArchives.flatMap { getMonthPGNList(it) }

    val extractedGames = runBlocking(Dispatchers.Default) {
        extractNGamesFromPGN(pgnList, numberOfGames)
    }

    println(extractedGames.size)

    val fileWriter = File("extracted/extracted.txt").printWriter()

    extractedGames.forEach {
        fileWriter.println(it)
    }

    fileWriter.close()
}
