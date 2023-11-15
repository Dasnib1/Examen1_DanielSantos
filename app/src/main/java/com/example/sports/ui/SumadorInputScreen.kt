package com.example.sports.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sports.R



@Composable
fun SumadorInputScreen(
    onSumButtonClick: () -> Unit,


) {
    var sumador1 by remember { mutableStateOf("") }
    var sumador2 by remember { mutableStateOf("") }
    val viewModel: SumadorViewModel = viewModel()

    Column (
        modifier = Modifier
            .padding(
                top = 300.dp,
                start = 24.dp,
                end = 24.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        ) {
        Text(text = stringResource(R.string.sumador_1))
        EditNumberField(
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            value = sumador1,
            onValueChanged = { sumador1 = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
        )

        Text(text = stringResource(R.string.sumador_2))
        EditNumberField(
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            value = sumador2,
            onValueChanged = { sumador2 = it },
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth(),
        )

        Button(
            modifier = Modifier,
            onClick = {
                viewModel.updateCurrentSum1(sumador1.toInt())
                viewModel.updateCurrentSum2(sumador2.toInt())
                viewModel.agregarLista()
                onSumButtonClick()
            }


        ) {
            Text(
                text = stringResource(R.string.sum),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun EditNumberField(
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        singleLine = true,
        modifier = modifier,
        onValueChange = onValueChanged,
        keyboardOptions = keyboardOptions,
        textStyle = LocalTextStyle.current.copy(color = Color.Black)
    )
}
