package ru.demchuk.messenger.ui.recyclerStreams.elm

import ru.demchuk.messenger.domain.useCase.streams.model.StreamModelUseCase


data class State(
    val progressBarShow : Boolean = false,
    val errorShow : Boolean = false,
    val recyclerViewShow : Boolean = false,
    val listStreams : List<StreamModelUseCase>? = null,
    )


sealed class Event {
    sealed class Ui : Event() {
        class SearchStreams(val query: String) : Ui()
        object Init : Ui()
        object LoadingAllStreams : Ui()
        object LoadingSubscribedStreams : Ui()
    }

    sealed class Internal : Event() {

        data class StreamsLoaded(val items: List<StreamModelUseCase>) : Internal()

        data class ErrorLoading(val error: Throwable) : Internal()

        object Init : Internal()
    }
}

sealed class Command {
    object LoadAllStreams : Command()
    object LoadSubscribedStreams : Command()
    object Init : Command()

    class SearchStreams(val query: String) : Command()

    class DefineActualOperation(val flagOperation : Boolean) : Command()

}

sealed class Effect {
    data class NextPageLoadError(val error: Throwable) : Effect()

}
