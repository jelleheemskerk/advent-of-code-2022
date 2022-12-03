package dev.heemskerk.aoc.day3

import java.io.File

/**
 * https://adventofcode.com/2022/day/3
 */
fun main() {
    val input = File("src/main/resources/day/3/input").readLines()

    val priorities = (('a'..'z') + ('A' .. 'Z')).toList()

    val part1 = input.sumOf {
        val compartments = it.chunked(it.length / 2)
        val item = compartments[0].toList().intersect(
            compartments[1].toList().toSet()
        ).first()

        priorities.indexOf(item) + 1
    }

    println("What is the sum of the priorities of those item types? [$part1]")
    
    val part2 = input.windowed(3, 3).flatMap {
        it[0].toList().intersect(
            it[1].toList().toSet()
        ).intersect(
            it[2].toList().toSet()
        )
    }.sumOf {
        priorities.indexOf(it) + 1
    }

    println("What is the sum of the priorities of those item types? [$part2]")
}
