package com.example.week8_todo_mvvm_api.model

import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://jsonplaceholder.typicode.com"

interface TodosApi {
    @GET("todos")
    suspend fun getTodos(): List<ToDo>

    companion object {
        var todosService: TodosApi? = null

        fun getInstance(): TodosApi {
            if (todosService === null) {
                todosService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(TodosApi::class.java)
            }

            return todosService!!
        }
    }
}