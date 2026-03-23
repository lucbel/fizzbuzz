package com.leboncoin.fizzbuzz.repository

import com.leboncoin.fizzbuzz.entity.EndpointUsageEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EndpointUsageRepository : JpaRepository<EndpointUsageEntity, Long>
