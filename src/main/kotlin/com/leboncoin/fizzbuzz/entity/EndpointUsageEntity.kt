package com.leboncoin.fizzbuzz.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.Instant

@Entity
@Table(name = "endpoint_usage")
class EndpointUsageEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val url: String,

    @Column(nullable = false)
    val params: String,

    @Column(nullable = false)
    val hash: String,

    @Column(nullable = false)
    val calledAt: Instant = Instant.now()
)
