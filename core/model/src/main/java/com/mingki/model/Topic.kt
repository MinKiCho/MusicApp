package com.mingki.model

data class Topic(
    val id : String,
    val title : String,
    val items : List<TopicItem>,
)