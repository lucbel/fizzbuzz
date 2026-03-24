package com.leboncoin.fizzbuzz.usecase

import com.leboncoin.fizzbuzz.dto.EndpointUsageStatsDto
import com.leboncoin.fizzbuzz.repository.EndpointUsageRepository
import org.springframework.stereotype.Service

@Service
class MostUsedEndpointUseCase(private val repository: EndpointUsageRepository) {

    fun execute(): EndpointUsageStatsDto? {
        val mostUsed = repository.findMostUsed() ?: return null

        val count = repository.countByHash(mostUsed.hash)

        return EndpointUsageStatsDto(
            url = mostUsed.url,
            params = mostUsed.params,
            count = count
        )
    }
}
