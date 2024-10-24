package com.example.week8_todo_mvvm_api.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week8_todo_mvvm_api.model.ToDo
import com.example.week8_todo_mvvm_api.model.TodosApi
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    val todos = mutableStateListOf<ToDo>()

    init {
        getTodosList()
    }

    private fun getTodosList() {
        viewModelScope.launch {
            var todosApi: TodosApi? = null
            try {
                todosApi = TodosApi!!.getInstance()
                todos.clear()
                todos.addAll(todosApi.getTodos())
            } catch (e: Exception){
                Log.d("TODOVIEWMODEL", e.message.toString())
            }
        }
    }
}