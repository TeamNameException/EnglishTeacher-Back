package ru.teamnameexception.plugins.entities.favorite

import kotlinx.serialization.Serializable
import ru.teamnameexception.domain.entities.CatalogLessonEntity


@Serializable
data class FavoriteResponse(
    val favorites : List<CatalogLessonEntity>
)
