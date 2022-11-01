package com.example.whitelabelpdi.domain.models

import com.example.whitelabelpdi.view.model.ScheduleEvent

data class EventsDomain(
    val title: String,
    val description: String,
    val id: Int,
    val data : String
)

fun EventsDomain.asView(): ScheduleEvent {
    return ScheduleEvent(
        title = this.title,
        description = this.description,
        id = this.id,
        data = this.data
    )
}