package com.example.namecompability

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.namecompability.ui.theme.Red500

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutPage()
        }
    }
}

@Composable
fun LayoutPage() {
    LittleHeartsAnimation()
    FormLayout()

}

@Composable
fun LittleHeartsAnimation(){
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(R.raw.heart)
    )
    val progress by animateLottieCompositionAsState(
        composition,

        // LottieConstants.IterateForever
        iterations = 2,

        // pass isPlaying we created above,
        // changing isPlaying will recompose
        // Lottie and pause/play
        isPlaying = true,

        // pass speed we created above,
        // changing speed will increase Lottie
        speed = 1f,

        // this makes animation to restart
        // when paused and play
        // pass false to continue the animation
        // at which is was paused
        restartOnPlay = false
    )

    LottieAnimation(
        composition,
        progress,
        modifier = Modifier.fillMaxHeight()
    )
}

@Composable
fun FormLayout() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(20.dp),
        horizontalArrangement = Arrangement.Center) {
        Column {
            NameTextField(title = "Primeiro nome")
            NameTextField(title = "Segundo nome")
            Button(onClick = { /*TODO*/ }, colors = ButtonDefaults.buttonColors(backgroundColor = Red500)) {
                Text(text = "Calcular", color = Color.White)
            }
        }
    }
}

@Composable
fun NameTextField(title: String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(title) },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Red500,
            focusedLabelColor = Red500,
            cursorColor = Red500
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LayoutPage()
}