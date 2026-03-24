package com.leboncoin.fizzbuzz.usecase

import com.leboncoin.fizzbuzz.entity.EndpointUsageEntity
import com.leboncoin.fizzbuzz.repository.EndpointUsageRepository
import org.springframework.stereotype.Service
import java.security.MessageDigest

@Service
class EndpointUsageUseCase(private val repository: EndpointUsageRepository) {

    fun execute(url: String, params: String) {
        val hash = md5("$url?$params")
        repository.save(
            EndpointUsageEntity(
                url = url,
                params = params,
                hash = hash
            )
        )
    }

    private fun md5(input: String): String =
        MessageDigest.getInstance("MD5")
            .digest(input.toByteArray())
            .joinToString("") { "%02x".format(it) }
}
