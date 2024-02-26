package ru.teamnameexception.plugins.entities.result

import kotlinx.serialization.Serializable
import ru.teamnameexception.domain.entities.ResultEntity

@Serializable
data class GetResultResponse(
    val results: List<ResultEntity>
)
