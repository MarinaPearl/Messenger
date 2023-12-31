package ru.demchuk.messenger.ui.recyclerStreams.elm

import vivid.money.elmslie.core.store.dsl_reducer.DslReducer

object Reducer : DslReducer<Event, State, Effect, Command>() {

    override fun Result.reduce(event: Event) = when (event) {
        is Event.Ui.LoadingAllStreams -> {
            state { copy(progressBarShow = true, errorShow = false, recyclerViewShow = false) }
            commands { +Command.LoadAllStreams }
            commands { +Command.DefineActualOperation(false) }
        }
        is Event.Ui.Init -> {
            state { copy(progressBarShow = true, errorShow = false, recyclerViewShow = false) }
            commands { +Command.Init}
            commands { +Command.LoadSubscribedStreams }
        }
        is Event.Ui.LoadingSubscribedStreams -> {
            state { copy(progressBarShow = true, errorShow = false, recyclerViewShow = false) }
            commands { +Command.LoadSubscribedStreams}
            commands { +Command.DefineActualOperation(true) }
        }
        is Event.Ui.SearchStreams -> {
            state { copy(progressBarShow = true, errorShow = false, recyclerViewShow = false) }
            commands { +Command.SearchStreams(event.query)}
        }
        is Event.Internal.StreamsLoaded -> {
            state { copy(progressBarShow = false, errorShow = false, recyclerViewShow = true, listStreams = event.items) }
        }
        is Event.Internal.ErrorLoading -> {
            state { copy(progressBarShow = false, errorShow = true, recyclerViewShow = false) }
        }
        else -> {}
    }
}