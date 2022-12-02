package dev.heemskerk.aoc.day2

import java.io.File

/**
 * https://adventofcode.com/2022/day/2
 */
enum class HandShape {
    ROCK,
    PAPER,
    SCISSORS,
}

val predictionCodes = listOf(
    "A",
    "B",
    "C",
)

val responseCodes = listOf(
    "X",
    "Y",
    "Z",
)

val outcomePayoff = responseCodes.mapIndexed { index, code ->
    code to index - 1
}.toMap()

val payoffMatrix = listOf(
    listOf(0, -1, 1),
    listOf(1, 0, -1),
    listOf(-1, 1, 0),
)

fun main() {
    val input = File("src/main/resources/day/2/input").getGuideLines()

    val part1 = input.sumOf {
        calculateScore(it.second, it.first)
    }

    println("What would your total score be if everything goes exactly according to your strategy guide? [$part1]")

    val part2 = input.sumOf {
        calculateScore(
            findShapeForPayoff(it.first.toHandShape(predictionCodes), outcomePayoff[it.second] ?: 0)
                .toCode(responseCodes),
            it.first,
        )
    }

    println("Following the Elf's instructions for the second column, what would your total score be if everything goes exactly according to your strategy guide? [$part2]")
}

fun File.getGuideLines() = readLines().map {
    Pair(
        it.first().toString(),
        it.last().toString(),
    )
}

fun calculateScore(response: String, prediction: String): Int {
    val you = response.toHandShape(responseCodes).ordinal
    val opponent = prediction.toHandShape(predictionCodes).ordinal

    return when (payoffMatrix[you][opponent]) {
        -1 -> 0 + you + 1
        0 -> 3 + you + 1
        1 -> 6 + you + 1
        else -> throw IllegalStateException()
    }
}

fun String.toHandShape(codes: List<String>) = codes.mapIndexed { index, code ->
    code to HandShape.values()[index] }.toMap()[this] 
        ?: throw IllegalStateException()

fun findShapeForPayoff(shape: HandShape, payoff: Int) =
    HandShape.values().find { payoffMatrix[it.ordinal][shape.ordinal] == payoff }
        ?: throw IllegalStateException()

fun HandShape.toCode(codes: List<String>) = codes[this.ordinal]
