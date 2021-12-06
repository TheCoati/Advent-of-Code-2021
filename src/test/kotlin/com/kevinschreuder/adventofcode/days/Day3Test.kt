package com.kevinschreuder.adventofcode.days

import com.kevinschreuder.adventofcode.FileInput
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Day3Test
{
    private val day = Day3()
    private val input = FileInput("day3")

    @Test
    fun part1()
    {
        val result = this.day.part1(this.input)

        assertEquals("198", result)
    }

    @Test
    fun part2()
    {
        val result = this.day.part2(this.input)

        assertEquals("230", result)
    }
}