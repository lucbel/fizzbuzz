package com.leboncoin.fizzbuzz.filter

import com.leboncoin.fizzbuzz.usecase.EndpointUsageUseCase
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class EndpointUsageFilter(private val endpointUsageUseCase: EndpointUsageUseCase) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val url = request.requestURI
        val params = request.queryString.orEmpty()

        endpointUsageUseCase.execute(url, params)

        filterChain.doFilter(request, response)
    }
}
