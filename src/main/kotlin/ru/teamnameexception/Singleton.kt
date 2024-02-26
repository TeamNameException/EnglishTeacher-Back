package ru.teamnameexception

import ru.teamnameexception.data.*
import ru.teamnameexception.data.sources.authication.AuthDataSourceImpl
import ru.teamnameexception.data.sources.catalog.CatalogDataSourceImpl
import ru.teamnameexception.data.sources.favorite.FavoriteDataSourceImpl
import ru.teamnameexception.data.sources.game.GameDataSourceImpl
import ru.teamnameexception.data.sources.subscribe.SubscribeDataSourceImpl
import ru.teamnameexception.data.sources.user.UserDataSourceImpl
import ru.teamnameexception.data.sources.word.WordDataSourceImpl
import ru.teamnameexception.domain.*

object Singleton {

    //Repositories
    private val userRepository = UserRepositoryImpl(UserDataSourceImpl)
    private val authRepository = AuthRepositoryImpl(AuthDataSourceImpl)
    private val subscribersRepository = SubscribersRepositoryImpl(SubscribeDataSourceImpl)
    private val gameRepository = GameRepositoryImpl(GameDataSourceImpl, CatalogDataSourceImpl, WordDataSourceImpl)
    private val catalogRepository = CatalogRepositoryImpl(CatalogDataSourceImpl, FavoriteDataSourceImpl)
    private val lessonRepository = LessonRepositoryImpl(CatalogDataSourceImpl, WordDataSourceImpl)

    //UseCases
    val addFavoriteUseCase = AddFavoriteUseCase(catalogRepository)
    val deleteFavoriteUseCase = DeleteFavoriteUseCase(catalogRepository)
    val getCatalogUseCase = GetCatalogUseCase(catalogRepository)
    val getLessonUseCase = GetLessonUseCase(gameRepository)
    val getSubscribersUseCase = GetSubscribersUseCase(subscribersRepository)
    val getUserIdUseCase = GetUserIdUseCase(userRepository)
    val getUserUseCase = GetUserUseCase(userRepository)
    val getWordsUseCase = GetWordsUseCase(gameRepository)
    val isLoggedUseCase = IsLoggedUseCase(authRepository)
    val loginUseCase = LoginUseCase(authRepository)
    val logOutUseCase = LogOutUseCase(authRepository)
    val renameUserUseCase = RenameUserUseCase(userRepository)
    val resultUseCase = ResultUseCase(gameRepository)
    val signUpUseCase = SignUpUseCase(userRepository)
    val subscribeUseCase = SubscribeUseCase(subscribersRepository)
    val unsubscribeUseCase = UnsubscribeUseCase(subscribersRepository)
    val redactLessonUseCase = RedactLessonUseCase(lessonRepository)
    val deleteWordUseCase = DeleteWordUseCase(lessonRepository)
    val deleteLessonUseCase = DeleteLessonUseCase(lessonRepository)
    val createLessonUseCase = CreateLessonUseCase(lessonRepository)
    val addWordUseCase = AddWordUseCase(lessonRepository)


}