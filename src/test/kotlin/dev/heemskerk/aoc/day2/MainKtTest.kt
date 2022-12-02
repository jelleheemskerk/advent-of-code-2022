package dev.heemskerk.aoc.day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun `Opponent plays A (rock) and you respond with X (rock)`() {
        assertEquals(3 + 1, calculateScore(prediction = "A", response = "X"))
    }

    @Test
    fun `Opponent plays A (rock) and you respond with Y (paper)`() {
        assertEquals(6 + 2, calculateScore(prediction = "A", response = "Y"))
    }

    @Test
    fun `Opponent plays A (rock) and you respond with Z (scissors)`() {
        assertEquals(0 + 3, calculateScore(prediction = "A", response = "Z"))
    }

    @Test
    fun `Opponent plays B (paper) and you respond with X (rock)`() {
        assertEquals(0 + 1, calculateScore(prediction = "B", response = "X"))
    }

    @Test
    fun `Opponent plays B (paper) and you respond with Y (paper)`() {
        assertEquals(3 + 2, calculateScore(prediction = "B", response = "Y"))
    }

    @Test
    fun `Opponent plays B (paper) and you respond with Z (scissors)`() {
        assertEquals(6 + 3, calculateScore(prediction = "B", response = "Z"))
    }


    @Test
    fun `Opponent plays C (scissors) and you respond with X (rock)`() {
        assertEquals(6 + 1, calculateScore(prediction = "C", response = "X"))
    }

    @Test
    fun `Opponent plays C (scissors) and you respond with Y (paper)`() {
        assertEquals(0 + 2, calculateScore(prediction = "C", response = "Y"))
    }

    @Test
    fun `Opponent plays C (scissors) and you respond with Z (scissors)`() {
        assertEquals(3 + 3, calculateScore(prediction = "C", response = "Z"))
    }
}
