package com.greemoid.habittracker.data

interface Mapper<out O> {
    fun map(): O
}

interface ListMapper<in I, out O> {
    fun map(input: I): O
}