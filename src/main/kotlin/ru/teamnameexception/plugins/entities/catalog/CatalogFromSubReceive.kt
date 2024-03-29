package ru.teamnameexception.plugins.entities.catalog

import kotlinx.serialization.Serializable


@Serializable
data class CatalogFromSubReceive(
    val idCreator: String,
    val limit: Int,
    val offset: Int
)
