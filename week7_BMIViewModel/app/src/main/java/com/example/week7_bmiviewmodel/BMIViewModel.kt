package com.example.week7_bmiviewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BMIViewModel: ViewModel() {
    var heightInput= mutableStateOf(value="")
        private set

    var weightInput= mutableStateOf(value = "")
        private set

    fun updateHeight(newValue: String) {
        heightInput.value = newValue
    }

    fun updateWeight(newValue: String) {
        weightInput.value = newValue
    }

    private val height: Float
        get() = heightInput.value.toFloatOrNull() ?: 0.0f

    private val weight: Float
        get() = weightInput.value.toFloatOrNull() ?: 0.0f

    val bmi: Float
        get() = if (height > 0 && weight > 0) {
            weight / (height * height)
        } else {
            0.0f
        }

}