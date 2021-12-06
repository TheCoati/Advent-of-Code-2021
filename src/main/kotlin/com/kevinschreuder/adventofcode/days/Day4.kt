package com.kevinschreuder.adventofcode.days

import com.kevinschreuder.adventofcode.FileInput
import kotlin.collections.ArrayList

/**
 * Day 4: Giant Squid
 * @see <a href="https://adventofcode.com/2021/day/4">Advent of code</a>
 */

class Day4 : Day
{
    private val input = FileInput("day4")

    @Override
    override fun title(): String
    {
        return "Day 4 - Giant Squid"
    }

    @Override
    override fun input(): FileInput
    {
        return this.input
    }

    @Override
    override fun part1(input: FileInput): String
    {
        val values = input[0].split(",")
        val clone = input.toMutableList()

        clone.removeFirst()
        clone.removeIf { it == "" }

        val cards = clone.chunked(5).map { it -> it.map { it.trim().split("\\s+".toRegex()) } }

        for (i in values.indices)
        {
            for (card in cards)
            {
                val drawn = values.subList(0, i + 1)

                for (row in card.indices)
                {
                    val horizontal = card[row]

                    // Horizontal Match
                    if (drawn.containsAll(horizontal))
                    {
                        return this.sum(card, drawn, values[i])
                    }

                    // Rotate matrix 90 degrees
                    val vertical = ArrayList<String>()

                    for (k in 0 until card[row].size)
                    {
                        vertical.add(card[k][row])
                    }

                    // Vertical Match
                    if (drawn.containsAll(vertical))
                    {
                        return this.sum(card, drawn, values[i])
                    }
                }
            }
        }

        return "No result found"
    }

    @Override
    override fun part2(input: FileInput): String
    {
        val values = input[0].split(",")
        val clone = input.toMutableList()

        clone.removeFirst()
        clone.removeIf { it == "" }

        var cards = clone.chunked(5).map { it -> it.map { it.trim().split("\\s+".toRegex()) } }

        for (i in values.indices)
        {
            for (card in cards)
            {
                val drawn = values.subList(0, i + 1)

                for (row in card.indices)
                {
                    val horizontal = card[row]

                    // Horizontal Match
                    if (drawn.containsAll(horizontal))
                    {
                        if (cards.size == 1)
                        {
                            return this.sum(cards[0], drawn, values[i])
                        }

                        cards = cards.filter { it != card }
                        break
                    }

                    // Rotate matrix 90 degrees
                    val vertical = ArrayList<String>()

                    for (k in 0 until card[row].size)
                    {
                        vertical.add(card[k][row])
                    }

                    // Vertical Match
                    if (drawn.containsAll(vertical))
                    {
                        if (cards.size == 1)
                        {
                            return this.sum(cards[0], drawn, values[i])
                        }

                        cards = cards.filter { it != card }
                        break
                    }
                }
            }
        }

        return "No result found"
    }

    /**
     * Calculate the sum of the remaining numbers times the last called number
     */

    private fun sum(card: List<List<String>>, drawn: List<String>, last: String): String
    {
        val flatten = card.flatten().filter { !drawn.contains(it) }
        val sum = flatten.sumOf { it.toInt() }

        return (last.toInt() * sum).toString()
    }
}