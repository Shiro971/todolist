package com.example.todolist

import android.icu.text.ListFormatter.Width
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoListTheme {

                var textquiclc by remember { mutableStateOf("") }
                var Liste by remember { mutableStateOf(emptyList<String>()) }

                Column {
                    Row(){ //TOP APP BAR
                        CenterAlignedTopAppBar(title = { Text(text="To do List" , fontWeight = FontWeight.Bold , fontSize = 40.sp, color = Color.Black)},modifier = Modifier
                        .fillMaxWidth()
                        .height(70.dp))
                    }
                    Row{ //TEXT FIELD
                        TextField(
                            value = textquiclc,
                            onValueChange = { textquiclc = it },
                            label = { Text("Entre ton texte ici.." , fontSize = 15.sp) },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            textStyle = TextStyle.Default.copy(fontSize = 25.sp, color = Color.Black),
                        )
                    }
                    Row(
                        Modifier
                            .background(color = Color.White)
                            .fillMaxWidth()
                            .height(620.dp)){
                        LazyColumn {//CREATION DE LA LISTE
                            items(Liste.size) { i ->
                                Card(modifier = Modifier /* CREATION DE LA CARTE */
                                    .border(border = BorderStroke(width = 3.dp, color = Color.White))
                                    .height(80.dp)
                                    .fillMaxWidth())
                                {
                                    Row() {
                                        Column(modifier = Modifier.width(350.dp)){//TEXT[i] DU TEXTFIELD
                                            Text(text = Liste[i], fontSize = 25.sp, color = Color.Black)
                                        }
                                        Column {//BOUTON CLEAR
                                            IconButton(onClick = { Liste = Liste - Liste[i] }) {
                                                Icon(Icons.Filled.Clear, contentDescription = "", tint = Color.Red, modifier = Modifier.size(80.dp))
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Row(
                        Modifier
                            .background(color = Color.Black)
                            .fillMaxWidth()
                            .fillMaxHeight(),
                        horizontalArrangement = Arrangement.Center
                    ){//BOUTON AJOUTER
                        IconButton(
                            onClick = {
                                if (textquiclc!=""){
                                    Liste = Liste + textquiclc
                                    textquiclc="";
                                }
                            },
                        ) {
                            Icon(Icons.Filled.AddCircle, contentDescription = "", tint = Color.White, modifier = Modifier.size(80.dp))
                        }
                    }
                }
        }
    }
}}