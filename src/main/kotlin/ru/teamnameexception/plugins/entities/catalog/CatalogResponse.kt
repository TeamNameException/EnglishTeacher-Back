package ru.teamnameexception.plugins.entities.catalog

import kotlinx.serialization.Serializable
import ru.teamnameexception.domain.entities.CatalogLessonEntity


@Serializable
data class CatalogResponse(
    val lessons: List<CatalogLessonEntity>
)