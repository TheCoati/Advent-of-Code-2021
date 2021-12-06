package com.kevinschreuder.adventofcode.days

import com.kevinschreuder.adventofcode.FileInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day4Test
{
    private val day = Day4()
    private val input = FileInput("day4")

    @Test
    fun part1()
    {
        val result = this.day.part1(this.input)

        assertEquals("4512", result)
    }

    @Test
    fun part2()
    {
        val result = this.day.part2(this.input)

        assertEquals("1924", result)
    }
}