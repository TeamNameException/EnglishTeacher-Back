package ru.teamnameexception.plugins.entities.catalog

import kotlinx.serialization.Serializable

@Serializable
data class CatalogReceive(
    val limit: Int,
    val offset: Int
)
