package com.kevinschreuder.adventofcode.days

import com.kevinschreuder.adventofcode.FileInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day1Test
{
    private val day = Day1()
    private val input = FileInput("day1")

    @Test
    fun part1()
    {
        val result = this.day.part1(this.input)

        assertEquals("7", result)
    }

    @Test
    fun part2()
    {
        val result = this.day.part2(this.input)

        assertEquals("5", result)
    }
}