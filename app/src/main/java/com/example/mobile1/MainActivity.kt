package com.example.mobile1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobile1.ui.theme.Mobile1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Mobile1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Box(modifier = Modifier
            .size(400.dp)
            .fillMaxSize()
            .background(Color.LightGray),
       contentAlignment = Alignment.Center
        ){
        Text(
            text = "Texto Nuevo",
            color = Color.White,
            fontSize = 20.sp
        )
    }
    Column (
        modifier= Modifier
            .background(Color.Red)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Hello $name!",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .background(Color.Red)
                .padding(16.dp)
                .background(Color.Blue)
                .border(width = 2.dp, color = Color.Black)
        )
        Text(
            text = "Esta es otro texto",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier
                .background(Color.Red)
                .border(width = 2.dp, color = Color.Black)
                .padding(16.dp)
                .background(Color.Blue)
        )
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Text(
                text = "Texto",
                color = Color.White,
                fontSize = 20.sp
            )
            Text(
                text = "Texto",
                color = Color.White,
                fontSize = 20.sp
            )
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    Mobile1Theme {
        Greeting("Android, mi primera APP")
    }
}