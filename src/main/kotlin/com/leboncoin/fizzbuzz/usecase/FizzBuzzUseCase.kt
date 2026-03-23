package com.leboncoin.fizzbuzz.usecase

import org.springframework.stereotype.Service

@Service
class FizzBuzzUseCase {

    fun execute(int1: Int, int2: Int, limit: Int, str1: String, str2: String): List<String> =
        (1..limit).map { i ->
            when {
                i % (int1 * int2) == 0 -> str1 + str2
                i % int1 == 0          -> str1
                i % int2 == 0          -> str2
                else                   -> i.toString()
            }
        }
}
