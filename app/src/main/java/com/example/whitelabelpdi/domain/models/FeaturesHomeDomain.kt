package com.example.whitelabelpdi.domain.models

import com.example.whitelabelpdi.view.model.HomeItemView

data class FeaturesHomeDomain(
    val title: String,
    val icon: Int
)

fun FeaturesHomeDomain.asView(): HomeItemView {
    return HomeItemView(
        title = this.title,
        icon = this.icon
    )
}