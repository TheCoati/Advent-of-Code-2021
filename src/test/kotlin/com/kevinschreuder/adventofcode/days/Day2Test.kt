package com.kevinschreuder.adventofcode.days

import com.kevinschreuder.adventofcode.FileInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day2Test
{
    private val day = Day2()
    private val input = FileInput("day2")

    @Test
    fun part1()
    {
        val result = this.day.part1(this.input)

        assertEquals("150", result)
    }

    @Test
    fun part2()
    {
        val result = this.day.part2(this.input)

        assertEquals("900", result)
    }
}