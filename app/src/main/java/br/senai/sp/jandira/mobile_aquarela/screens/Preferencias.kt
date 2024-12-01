package br.senai.sp.jandira.mobile_aquarela.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.mobile_aquarela.R

val lightBlue = Color(0xFFB8CED4)
val Ciano = Color(0xFF5DA5B7)

@Composable
fun Preferencias(controleDeNavegacao: NavHostController) {
    var selectedPreferences by remember { mutableStateOf<Set<String>>(emptySet()) }

    val preferenceLabels = listOf(
        "Arte Digital", "Pinturas", "Gravura", "Esculturas", "Desenho", "Bijuterias"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.aquarelaazul),
                    contentDescription = "Aquarela",
                    modifier = Modifier
                        .size(160.dp)
                        .padding(bottom = 0.dp)
                )
            }

            Text(
                text = "Quais temas te interessam?",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 18.dp),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Ciano
            )

            for (i in preferenceLabels.indices step 2) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    PreferenciaButton(
                        label = preferenceLabels[i],
                        modifier = Modifier.weight(1f),
                        isSelected = preferenceLabels[i] in selectedPreferences,
                        selectedPreferences = selectedPreferences
                    ) { label, isSelected ->
                        selectedPreferences = if (isSelected) {
                            selectedPreferences + label
                        } else {
                            selectedPreferences - label
                        }
                    }
                    if (i + 1 < preferenceLabels.size) {
                        PreferenciaButton(
                            label = preferenceLabels[i + 1],
                            modifier = Modifier.weight(1f),
                            isSelected = preferenceLabels[i + 1] in selectedPreferences,
                            selectedPreferences = selectedPreferences
                        ) { label, isSelected ->
                            selectedPreferences = if (isSelected) {
                                selectedPreferences + label
                            } else {
                                selectedPreferences - label
                            }
                        }
                    }
                }
            }
        }
        Log.i("a", selectedPreferences.toString())

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 48.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Pular",
                color = Color.Gray,
                modifier = Modifier.clickable {}
            )

            Button(
                onClick = { controleDeNavegacao.navigate("feed/{id}") },
                colors = ButtonDefaults.buttonColors(containerColor = Ciano),
                modifier = Modifier.padding(start = 80.dp)
            ) {
                Text("PROXIMA", color = Color.White)
            }
        }
    }
}

@Composable
fun PreferenciaButton(
    label: String,
    modifier: Modifier = Modifier,
    isSelected: Boolean,
    selectedPreferences: Set<String>,
    onSelectionChange: (String, Boolean) -> Unit
) {
    val backgroundColor = if (isSelected) Color.Black else lightBlue
    val preferenceNumber = getPreferenceNumber(label, selectedPreferences)

    val gradientColors = listOf(Color(0xFF90C1CE), Color(0xFFB8CED4))

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .padding(8.dp)
            .clickable { onSelectionChange(label, !isSelected) },
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(140.dp)
                .background(
                    brush = Brush.linearGradient(colors = gradientColors),
                    shape = RoundedCornerShape(16.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = label,
                color = Color(0xFF3E7D8D),
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            preferenceNumber?.let {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .background(Color.White, RoundedCornerShape(4.dp))
                ) {
                    Text(
                        text = it.toString(),
                        color = Color.Black,
                        modifier = Modifier.padding(2.dp)
                    )
                }
            }
        }
    }
}

fun getPreferenceNumber(label: String, selectedPreferences: Set<String>): Int? {
    return if (label in selectedPreferences) {
        selectedPreferences.indexOf(label) + 1
    } else {
        null
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewPreferenciasScreen() {
    Preferencias(controleDeNavegacao = NavHostController(LocalContext.current))
}