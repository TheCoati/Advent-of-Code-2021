package com.kevinschreuder.adventofcode.days

import com.kevinschreuder.adventofcode.FileInput

/**
 * Day 1: Sonar Sweep
 * @see <a href="https://adventofcode.com/2021/day/1">Advent of code</a>
 * @see <a href="https://blog.jetbrains.com/kotlin/2021/12/advent-of-code-2021-in-kotlin-day-1/">Jetbrains solution</a>
 */

class Day1 : Day
{
    private val input = FileInput("day1")

    @Override
    override fun title(): String
    {
        return "Day 1 - Sonar Sweep"
    }

    @Override
    override fun input(): FileInput
    {
        return this.input
    }

    @Override
    override fun part1(input: FileInput): String
    {
        val readings: List<Int> = input.map { it.toInt() }

        var previous = 0
        var result = 0

        for (current in readings)
        {
            if (previous != 0 && current > previous)
            {
                result++
            }

            previous = current
        }

        return result.toString()
    }

    @Override
    override fun part2(input: FileInput): String
    {
        val readings: List<Int> = input.map { it.toInt() }

        var previous = 0
        var result = 0

        if (readings.size < 3)
        {
            return result.toString()
        }

        for (i in 0 until readings.size - 2)
        {
            val current = readings[i] + readings[i + 1] + readings[i + 2]

            if (previous != 0 && current > previous)
            {
                result++
            }

            previous = current
        }

        return result.toString()
    }
}