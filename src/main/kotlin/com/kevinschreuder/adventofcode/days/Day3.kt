package com.kevinschreuder.adventofcode.days

import com.kevinschreuder.adventofcode.FileInput

/**
 * Day 3: Binary Diagnostic
 * @see <a href="https://adventofcode.com/2021/day/3">Advent of code</a>
 */

class Day3 : Day
{
    private val input = FileInput("day3")

    @Override
    override fun title(): String
    {
        return "Day 3 - Binary Diagnostic"
    }

    @Override
    override fun input(): FileInput
    {
        return this.input
    }

    @Override
    override fun part1(input: FileInput): String
    {
        var gammaStr = ""
        var epsilonStr = ""

        for (i in 0 until input[0].chars().count())
        {
            val count = input.map { it[i.toInt()] }.groupingBy { it }.eachCount()

            when (count.maxByOrNull { it.value }!!.key)
            {
                '0' -> {
                    gammaStr += 0
                    epsilonStr += 1
                }
                '1' -> {
                    gammaStr += 1
                    epsilonStr += 0
                }
            }
        }

        val gamma = Integer.parseInt(gammaStr, 2)
        val epsilon = Integer.parseInt(epsilonStr, 2)

        return (gamma * epsilon).toString()
    }

    @Override
    override fun part2(input: FileInput): String
    {
        var oxygenInput: List<String> = input
        var co2Input: List<String> = input

        var oxygenIndex = 0
        var co2Index = 0

        while (oxygenInput.size > 1)
        {
            val count = oxygenInput.map { it[oxygenIndex] }.groupingBy { it }.eachCount()
            val min = count.minByOrNull { it.value }!!.key
            val max = count.maxByOrNull { it.value }!!.key

            val key = if (min == max) '1' else max

            oxygenInput = oxygenInput.filter { it[oxygenIndex] == key }
            oxygenIndex++
        }

        while (co2Input.size > 1)
        {
            val count = co2Input.map { it[co2Index] }.groupingBy { it }.eachCount()
            val min = count.minByOrNull { it.value }!!.key
            val max = count.maxByOrNull { it.value }!!.key

            val key = if (min == max) '0' else min

            co2Input = co2Input.filter { it[co2Index] == key }
            co2Index++
        }

        val oxygen = Integer.parseInt(oxygenInput[0], 2)
        val co2 = Integer.parseInt(co2Input[0], 2)

        return (oxygen * co2).toString()
    }
}