package com.leboncoin.fizzbuzz.repository

import com.leboncoin.fizzbuzz.entity.EndpointUsageEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface EndpointUsageRepository : JpaRepository<EndpointUsageEntity, Long> {

    fun countByHash(hash: String): Long

    @Query(
        """
        SELECT e FROM EndpointUsageEntity e
        WHERE e.hash = (
            SELECT e2.hash FROM EndpointUsageEntity e2
            GROUP BY e2.hash
            ORDER BY COUNT(e2.hash) DESC
            LIMIT 1
        )
        ORDER BY e.calledAt DESC
        LIMIT 1
        """
    )
    fun findMostUsed(): EndpointUsageEntity?
}
