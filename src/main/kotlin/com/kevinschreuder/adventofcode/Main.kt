package com.kevinschreuder.adventofcode

import kotlin.jvm.JvmStatic

object Main
{
    @JvmStatic
    fun main(args: Array<String>)
    {
        val story = Story()
        story.load("com.kevinschreuder.adventofcode.days")
        story.output()
    }
}