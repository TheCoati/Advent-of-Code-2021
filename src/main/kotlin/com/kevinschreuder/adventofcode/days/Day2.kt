package com.kevinschreuder.adventofcode.days

import com.kevinschreuder.adventofcode.FileInput

/**
 * Day 2: Dive!
 * @see <a href="https://adventofcode.com/2021/day/2">Advent of code</a>
 */

class Day2 : Day
{
    private val input = FileInput("day2")

    @Override
    override fun title(): String
    {
        return "Day 2 - Dive!"
    }

    @Override
    override fun input(): FileInput
    {
        return this.input
    }

    @Override
    override fun part1(input: FileInput): String
    {
        var horizontal = 0;
        var depth = 0;

        for (instruction in input)
        {
            val split = instruction.split(" ")
            val direction = split[0]
            val amount = split[1].toInt()

            when (direction)
            {
                "forward" -> horizontal += amount
                "down" -> depth += amount
                "up" -> depth -= amount
            }
        }

        return (horizontal * depth).toString()
    }

    @Override
    override fun part2(input: FileInput): String
    {
        var aim = 0
        var horizontal = 0
        var depth = 0

        for (instruction in input)
        {
            val split = instruction.split(" ")
            val direction = split[0]
            val amount = split[1].toInt()

            when (direction)
            {
                "forward" -> {
                    horizontal += amount
                    depth += (aim * amount)
                }
                "down" -> aim += amount
                "up" -> aim -= amount
            }
        }

        return (horizontal * depth).toString()
    }
}