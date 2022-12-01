package dev.heemskerk.aoc.day1

import java.io.File

/**
 * https://adventofcode.com/2022/day/1
 */
fun main() {
    val input = File("src/main/resources/day/1/input").getCalories()

    val part1 = input.map {
        it.sum()
    }.maxOf { it }

    println("How many total Calories is that Elf carrying? [$part1]")

    val part2 = input.map {
        it.sum()
    }.sortedDescending().take(3).sum()

    println("How many Calories are those Elves carrying in total? [$part2]")
}

private fun File.getCalories(): List<List<Int>> {
    return this.readText().split("\n\n").map { elf ->
        elf.split("\n").map { calories ->
            calories.toInt()
        }
    }
}
