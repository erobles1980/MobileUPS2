package com.example.mobile1

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun PersonList(
    persons: List<Person>,
    onAddPerson: (Person) -> Unit
) {
    var timeLeft by remember {
        mutableStateOf(10)
    }
    var isPaused by remember {
        mutableStateOf(false)
    }
LaunchedEffect(key1 = timeLeft) {
    while (timeLeft>0 && !isPaused){
        delay(1000L)
        timeLeft--
    }
}

    var nameTF by remember {
        mutableStateOf("")
    }
    var ageTF by remember {
        mutableStateOf("")
    }
//    var persons by remember {
//        mutableStateOf(listOf<Person>())
//    }
    var context= LocalContext.current
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            ) {
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()){

            Text(text = "Time left: ${timeLeft.toString() }",
                modifier = Modifier
                    .padding(16.dp),
                fontSize = 20.sp)
            Button(onClick = {  timeLeft=10 }) {
               Icon(modifier = Modifier
                        .size(30.dp),
                   imageVector = Icons.Default.Refresh,
                   contentDescription = null)
            }
            Button(onClick = { isPaused=true}) {
                Icon(modifier = Modifier
                    .size(30.dp),
                    imageVector = Icons.Default.Warning,
                    contentDescription = null)
            }
        }

        TextField(
                value = nameTF,
                placeholder = { Text(text = "Enter name",
                    fontSize = 20.sp
                    ) },
                onValueChange = { textName ->
                    nameTF=textName
                }
        )
        Spacer(
            modifier = Modifier
                .size(16.dp)
        )
        TextField(value = ageTF,
            placeholder = { Text(text = "Enter age")},
            onValueChange = {textEdad ->
                ageTF=textEdad
            },
            keyboardOptions = KeyboardOptions(
                keyboardType=KeyboardType.Number
            )
        )
        Spacer(
            modifier = Modifier
                .size(16.dp)
        )
            Button(onClick = {
                val newPerson = Person(name = nameTF.toString(), age = ageTF.toString().toIntOrNull() ?: 0)
                onAddPerson(newPerson)
//                persons += newPerson
                if (nameTF.isNotBlank() && ageTF.isNotBlank()){
                    nameTF=""
                    ageTF=""
                }else{
                    Toast
                        .makeText(
                            context,
                            "Enter a valid info",
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
                Text(text = "add to the list")

            }

        Spacer(
            modifier = Modifier
                .size(16.dp)
        )
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        LazyColumn {
            items(persons){person ->
                Text("Nombre: ${person.name}, Edad: ${person.age}")
                Divider()

            }
        }
    }

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ListPreviewPerson() {
    var persons by remember { mutableStateOf(listOf<Person>()) }

    PersonList(
        persons = persons,
        onAddPerson = { person ->
        persons += person
    })
//    PersonList()
}