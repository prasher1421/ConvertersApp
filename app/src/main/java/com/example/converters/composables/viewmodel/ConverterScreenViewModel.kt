package com.example.converters.composables.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.example.converters.composables.util.ConverterUtil
import com.example.converters.composables.util.ConverterUtil.ConverterTypes
class ConverterScreenViewModel: ViewModel() {
    val converterTypes = ConverterTypes
    var result = mutableStateOf(0.0f)
    fun getConverterValues(
        converterType : String
    ): List<String>{
        return ConverterUtil.getConverterValues(converterType = converterType)
    }
    fun validateFields(//checking empty fields
        converterType: String,
        convertFrom: String,
        convertTo: String
    ):Boolean{
        return (converterType.isBlank() or convertFrom.isBlank() or convertTo.isBlank())
    }

    fun calculateResult(
        converterType: String,
        convertFrom: String,
        convertTo: String,
        amount:Double =0.0
    ){
        result.value = ConverterUtil.unitConvert(
            converterType = converterType,
            convertFrom = convertFrom,
            convertTo = convertTo,
            amount = amount
        ).toBigDecimal().toFloat()
    }
}