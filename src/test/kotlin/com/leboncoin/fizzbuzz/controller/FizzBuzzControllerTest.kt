package com.leboncoin.fizzbuzz.controller

import com.leboncoin.fizzbuzz.usecase.FizzBuzzUseCase
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`

class FizzBuzzControllerTest {

    private val fizzBuzzUseCase: FizzBuzzUseCase = mock()
    private val controller = FizzBuzzController(fizzBuzzUseCase)

    @Test
    fun `should return comma-separated fizzbuzz result`() {
        `when`(fizzBuzzUseCase.execute(3, 5, 15, "fizz", "buzz"))
            .thenReturn(listOf("1", "2", "fizz", "4", "buzz", "fizz", "7", "8", "fizz", "buzz", "11", "fizz", "13", "14", "fizzbuzz"))

        val result = controller.fizzbuzz(3, 5, 15, "fizz", "buzz")

        assertEquals("1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz", result)
        verify(fizzBuzzUseCase).execute(3, 5, 15, "fizz", "buzz")
    }

    @Test
    fun `should return empty string when use case returns empty list`() {
        `when`(fizzBuzzUseCase.execute(3, 5, -1, "fizz", "buzz"))
            .thenReturn(emptyList())

        val result = controller.fizzbuzz(3, 5, -1, "fizz", "buzz")

        assertEquals("", result)
    }
}
