package com.example.mobile1

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource


@Composable
fun TapCounter(){
/* esta accion requiere de value
    var counter = remember {
        mutableStateOf(0)
    }
*/
    val imageVector: Painter = painterResource(id = R.drawable.sincronizar)
    var counter by remember {
        mutableIntStateOf(0)
    }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ){
        //counter.value.toString() cuando se usa el value
        Text(text = counter.toString(),
            fontSize = 30.sp)
        Button(onClick = {
            //counter.value++
            counter++
            })
        {
            Icon(imageVector = Icons.Default.Build,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp))
            Spacer(modifier = Modifier
                .size(16.dp))
            Text(text = "Tap me!")
        }
        Button(onClick = {
            //counter.value++
            counter=0
        })
        {
            Icon(
                painter = imageVector,
                contentDescription = null,
                modifier = Modifier
                    .size(16.dp))
            Spacer(modifier = Modifier
                .size(16.dp))
            Text(text = "Reload")
        }
    }

}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TapPreview(){
    TapCounter()
}