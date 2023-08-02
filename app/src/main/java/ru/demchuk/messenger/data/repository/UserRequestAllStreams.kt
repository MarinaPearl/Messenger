package ru.demchuk.messenger.data.repository

import ru.demchuk.messenger.data.Client
import ru.demchuk.messenger.ui.recyclerStreams.repository.UserRequestRepository
import ru.demchuk.messenger.ui.recyclerStreams.use_case.model.StreamModelUseCase

class UserRequestAllStreams : UserRequestRepository {
    override suspend fun receiveAnswerOnRequest(): List<StreamModelUseCase> {
        val result = Client.getRetrofitStreams().getAllStreams()
        return result.listStreams.toListByDomain()
    }
}