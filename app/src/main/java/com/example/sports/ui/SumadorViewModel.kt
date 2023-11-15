/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.sports.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.sports.data.LocalRegistrosDataProvider
import com.example.sports.data.LocalRegistrosDataProvider.lista
import com.example.sports.model.Registro
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


class SumadorViewModel : ViewModel() {



    var sum1 by mutableStateOf(0)
        private set

    var sum2 by mutableStateOf(0)
        private set


    fun updateCurrentSum1(num1: Int){
        sum1 = num1
    }

    fun updateCurrentSum2(num2: Int){
        sum2 = num2
    }

    fun agregarLista() {
        var index: Int = 0
        if (lista.size > 0){
            index = lista.last().id+1
        }
        lista.add(Registro(index, sum1, sum2, sum1 + sum2))
    }
}


