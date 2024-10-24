package com.example.week8_todo_mvvm_api.model

data class ToDo(
    var userId: Int,
    var id: Int,
    var title: String,
    var completed: Boolean
)
