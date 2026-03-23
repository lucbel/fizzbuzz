package com.leboncoin.fizzbuzz.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1")
open class FizzBuzzController {




    @GetMapping("/fizzbuzz")
    fun fizzbuzz(
        @RequestParam("int1") int1:Int,
        @RequestParam("int2") int2:Int,
        @RequestParam("limit") limit:Int,
        @RequestParam("str1") str1:String,
        @RequestParam("str2") str2:String
        ):List<String> {
        return listOf("1","2")
    }


}