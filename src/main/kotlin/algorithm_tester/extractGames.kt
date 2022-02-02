package algorithm_tester

import kotlinx.coroutines.*


/**
 * Extract games given a list of PGN [pgnList].
 *
 * Removes information from moves:
 * - comments (timestamp included)
 * - turn number
 * - check character '+'
 * - checkmate character '#'
 * - who won
 *
 * @param pgnList list of PGN objects
 * @return list of extracted games (each game a string of moves)
 */
suspend fun extractNGamesFromPGN(pgnList: List<PGN>, numberOfGames: Int): List<String> {
    return coroutineScope {
        pgnList
            .filterIndexed { idx, pgn ->
                if (pgn["Variant"] != null) {
                    //logger?.println("Ignored game ${idx + 1} because it is of a different game variant.")
                }

                pgn["Variant"] == null && pgn.moves.substringBefore(" ") == "1."
            }
            .take(numberOfGames)
            .map { pgn ->
                async {
                    pgn.moves.replace(Regex("\\{.*?} "), "")
                        .replace(Regex("\\d+\\.(\\.\\.)? "), "")
                        .replace("+", "")
                        .replace("#", "")
                        .replace(Regex("( )?(0-1|1-0|1/2-1/2)"), "")
                }
            }.awaitAll()
    }
}
