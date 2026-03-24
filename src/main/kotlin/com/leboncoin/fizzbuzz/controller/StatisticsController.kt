package com.leboncoin.fizzbuzz.controller

import com.leboncoin.fizzbuzz.dto.EndpointUsageStatsDto
import com.leboncoin.fizzbuzz.usecase.MostUsedEndpointUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/statistics")
class StatisticsController(private val mostUsedEndpointUseCase: MostUsedEndpointUseCase) {

    @GetMapping("/most-used-endpoint")
    fun mostUsedEndpoint(): ResponseEntity<EndpointUsageStatsDto> {
        val result = mostUsedEndpointUseCase.execute()
            ?: return ResponseEntity.noContent().build()
        return ResponseEntity.ok(result)
    }
}
