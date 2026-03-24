package com.leboncoin.fizzbuzz.dto

data class EndpointUsageStatsDto(
    val url: String,
    val params: String,
    val count: Long
)
