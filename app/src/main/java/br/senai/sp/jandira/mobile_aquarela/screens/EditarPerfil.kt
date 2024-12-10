package br.senai.sp.jandira.mobile_aquarela.screens

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.mobile_aquarela.R

@Composable
fun EditarPerfil() {
    Column {
        Row {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "",
                modifier = Modifier.width(16.dp).height(16.dp)
            )
            Text(text = "Editar perfil")
        }
        Image(painter = painterResource(id = R.drawable.logo1), contentDescription = "")
        Box { }
        val pickMedia =
            rememberLauncherForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                // Callback is invoked after the user selects a media item or closes the
                // photo picker.
                if (uri != null) {
                    Log.d("PhotoPicker", "Selected URI: $uri")
                } else {
                    Log.d("PhotoPicker", "No media selected")
                }
            }
        Button(onClick = {// Launch the photo picker and let the user choose only images.
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }) { }
        Text(text = "Nome")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                focusedContainerColor = Color(0xffB8CED4),
                unfocusedContainerColor = Color(0xffB8CED4),
                unfocusedBorderColor = Color.Transparent
            )
        )
        Text(text = "Usuario")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedContainerColor = Color(0xffB8CED4),
                unfocusedBorderColor = Color.Transparent,
                focusedBorderColor = Color.Transparent,
                unfocusedContainerColor = Color(0xffB8CED4)
            )
        )
        Text(text = "Biografia")
        OutlinedTextField(
            value = "",
            onValueChange = {},
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                focusedContainerColor = Color(0xffB8CED4),
                unfocusedBorderColor = Color.Transparent,
                unfocusedContainerColor = Color(0xffB8CED4)
            )
        )
        Box { }
    }

}
@Preview(showSystemUi = true)
@Composable
fun Editarperfilpreview(){
    EditarPerfil()
}