package ru.teamnameexception.domain

import ru.teamnameexception.domain.entities.LessonEntity
import ru.teamnameexception.domain.repositories.SubscribersRepository

class GetSubscriberLessonUseCase(
    private val subscribersRepository: SubscribersRepository
) {

    suspend fun getSubscriberLesson(id: Long) : List<LessonEntity> {
        return subscribersRepository.getSubscriberLesson(id)
    }
}