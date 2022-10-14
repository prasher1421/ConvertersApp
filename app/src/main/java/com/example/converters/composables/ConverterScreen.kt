package com.example.converters.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.SwapVert
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.*
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.converters.composables.viewmodel.ConverterScreenViewModel

@Composable
fun ConverterScreen(
    viewModel: ConverterScreenViewModel = ConverterScreenViewModel()
){

    val scrollState = rememberScrollState()
    var expanded by remember {
        mutableStateOf(listOf(false,false,false))
    }
    var converterTypeText by remember {
        mutableStateOf("")
    }
    var fromText by remember {
        mutableStateOf("")
    }
    var toText by remember {
        mutableStateOf("")
    }
    var amount by remember {
        mutableStateOf("")
    }
    var result by remember{
        viewModel.result
    }

    var resultantStringVisibility by remember {
        mutableStateOf(false)
    }
    val animatedResult by animateFloatAsState(targetValue = result, animationSpec = tween(50))

    val softKeyboardFocusManager = LocalFocusManager.current
    val converterTypes = viewModel.converterTypes
    val converterValues = viewModel.getConverterValues(converterTypeText)

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(15.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier.align(Alignment.Start),
            text = "Unit\nConverter",
            fontSize = 30.sp,
            style = MaterialTheme.typography.body2
        )
        Spacer(modifier = Modifier.height(20.dp))
        DropDownBox(
            dropDownList = converterTypes,
            textValue = converterTypeText,
            labelText = "Converter Type",
            scrollState = scrollState,
            isExpanded = expanded[0],
            expandStatus = {
                expanded = listOf(it, false, false)
            },
            valueChange = {
                resultantStringVisibility = false
                converterTypeText = it
                fromText=""
                toText=""
                amount =""
            }
        )
        Spacer(modifier = Modifier.height(15.dp))

        DropDownBox(
            dropDownList = converterValues,
            textValue = fromText,
            labelText = "Convert From",
            scrollState = scrollState,
            isExpanded = expanded[1],
            expandStatus = {
                if (converterTypeText.isNotEmpty()){
                    expanded = listOf(false, it, false)
                }
            },
            valueChange = {
                fromText = it
            }
        )
        Spacer(modifier = Modifier.height(8.dp))

        IconButton(onClick = {
            resultantStringVisibility = false
            fromText = toText.also {
                toText = fromText
            }
            result = 0.0f
        },
            enabled = fromText.isNotBlank() && toText.isNotBlank()
        ) {
            Icon(imageVector = Icons.Default.SwapVert,
                contentDescription = "SwapVert",
                modifier= Modifier.size(30.dp),
                tint = MaterialTheme.colors.primary
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        DropDownBox(
            dropDownList = converterValues,
            textValue = toText,
            labelText = "Convert To",
            scrollState = scrollState,
            isExpanded = expanded[2],
            expandStatus = {
                if (fromText.isNotEmpty()){
                    expanded = listOf(false, false, it)
                }
            },
            valueChange = {
                toText= it
            }
        )
        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = amount,
            onValueChange = {
                amount = it
            },
            label = {
                Text(text = "Amount")
            },
            placeholder = {
                Text(text = "1.0")
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    softKeyboardFocusManager.clearFocus()
                }
            ),
            enabled = toText.isNotBlank()
        )
        Spacer(modifier = Modifier.height(20.dp))

        //All Buttons
        ActionsButtons(
            viewModel = viewModel,
            converterTypeText = converterTypeText,
            fromText = fromText,
            toText = toText,
            amount = amount,
            onReset = {
                converterTypeText = ""
                fromText = ""
                toText= ""
                amount = ""
            }
        ){
            resultantStringVisibility = it
        }

        Spacer(modifier = Modifier.height(15.dp))

        if (resultantStringVisibility)
            ResultantString(value = animatedResult, unit = toText)
        Spacer(modifier = Modifier.height(25.dp))

    }
}
