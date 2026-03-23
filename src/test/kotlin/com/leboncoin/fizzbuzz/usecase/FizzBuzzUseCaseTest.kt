package com.leboncoin.fizzbuzz.usecase

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FizzBuzzUseCaseTest {

    private val useCase = FizzBuzzUseCase()

    @Test
    fun `should replace multiples of int1 with str1`() {
        val result = useCase.execute(int1 = 3, int2 = 5, limit = 6, str1 = "fizz", str2 = "buzz")
        assertEquals("fizz", result[2])
        assertEquals("fizz", result[5])
    }

    @Test
    fun `should replace multiples of int2 with str2`() {
        val result = useCase.execute(int1 = 3, int2 = 5, limit = 10, str1 = "fizz", str2 = "buzz")
        assertEquals("buzz", result[4])
        assertEquals("buzz", result[9])
    }

    @Test
    fun `should replace multiples of both int1 and int2 with str1 and str2`() {
        val result = useCase.execute(int1 = 3, int2 = 5, limit = 15, str1 = "fizz", str2 = "buzz")
        assertEquals("fizzbuzz", result[14])
    }

    @Test
    fun `should keep number as string when not a multiple of int1 or int2`() {
        val result = useCase.execute(int1 = 3, int2 = 5, limit = 5, str1 = "fizz", str2 = "buzz")
        assertEquals("1", result[0])
        assertEquals("2", result[1])
        assertEquals("4", result[3])
    }

    @Test
    fun `should return correct full sequence for classic fizzbuzz`() {
        val result = useCase.execute(int1 = 3, int2 = 5, limit = 15, str1 = "fizz", str2 = "buzz")
        val expected = listOf(
            "1", "2", "fizz", "4", "buzz",
            "fizz", "7", "8", "fizz", "buzz",
            "11", "fizz", "13", "14", "fizzbuzz"
        )
        assertEquals(expected, result)
    }

    @Test
    fun `should return a list of size limit`() {
        val result = useCase.execute(int1 = 3, int2 = 5, limit = 20, str1 = "fizz", str2 = "buzz")
        assertEquals(20, result.size)
    }

    @Test
    fun `should return empty list when limit is negative`() {
        val result = useCase.execute(int1 = 3, int2 = 5, limit = -1, str1 = "fizz", str2 = "buzz")
        assertEquals(emptyList<String>(), result)
    }
}
