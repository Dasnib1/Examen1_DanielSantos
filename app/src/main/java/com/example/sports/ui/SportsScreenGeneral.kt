package com.example.sports.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sports.R
import com.example.sports.data.LocalRegistrosDataProvider
import com.example.sports.model.Registro
import com.example.sports.ui.theme.SportsTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SumadorRegistroScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    contentPadding: PaddingValues,
    onVolverButtonClick: () -> Unit,
    registros: List<Registro>
) {
    Column (
        modifier = Modifier
            .padding(
                top = 300.dp,
                start = 24.dp,
                end = 24.dp
            )
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = stringResource(R.string.resultado),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "${registros.last().sum1} + ${registros.last().sum2} = ${registros.last().resul}",
            )
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.registros),
            fontWeight = FontWeight.Bold
        )
        Box(
            modifier = Modifier.size(150.dp),
        ){
            LazyColumn(
                modifier = Modifier
                    .padding(top = 8.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(registros, key = { registro -> registro.id }) { registro ->
                    RegistroListItem(
                        registro = registro,
                        modifier
                    )
                }
            }
        }

        Button(
            modifier = Modifier
                .padding(top = 16.dp),
            onClick = onVolverButtonClick
        ) {
            Text(
                text = stringResource(R.string.volver),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun RegistroListItem(registro: Registro, modifier: Modifier) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(R.dimen.card_corner_radius)),
    ){
        Text(
            text = "${registro.sum1} + ${registro.sum2} = ${registro.resul}"
        )
    }
}

