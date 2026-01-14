package com.ianearnest.tapper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ianearnest.tapper.ui.theme.TapperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TapperTheme {
                Scaffold(modifier = Modifier
                    .fillMaxSize(),
                    containerColor = Color(0xFF005FFF)) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
// Preview
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TapperTheme {
        Scaffold(modifier = Modifier
            .fillMaxSize(),
            containerColor = Color(0xFF005FFF)) { innerPadding ->
            Greeting(modifier = Modifier.padding(innerPadding))
        }
    }
}

// TODO auto add.. every frame, timer?

// Running code
@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var btn2enable by remember { mutableStateOf(false) }
    var btn3enable by remember { mutableStateOf(false) }
    var btn4enable by remember { mutableStateOf(false) }
    var btn5enable by remember { mutableStateOf(false) }
    var multiplier by remember { mutableStateOf(1) }

    val something = when (result) {
        1 -> "Not Started"
        2 -> "Started"
        3 -> "Good, keep going"
        4 -> "More"
        5 -> "and More..."
        in 4..9 -> "finished?"
        10 -> "new button!"
        in 11..99 -> "..."
        100 -> "Finished!"
        else -> "Finished!..."
    }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            //.padding()

    )
    {
        Text(
            text = "Tap button to get started!",
            fontSize = 20.sp,
            modifier = modifier
                //padding(50.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = result.toString(),
            fontSize = 50.sp
            //modifier = modifier
        )
        // TODO aaa
        //Button(onClick = {result = (1..6).random()}){
        Button(onClick = {result += multiplier}){
            Text(
                text = "$something",
                fontSize = 24.sp
                //modifier = modifier
            )
        }
        if(btn2enable){
            Text(
                text = "+2",
                fontSize = 24.sp
                //modifier = modifier
            )
        }
        if(btn3enable){
            Text(
                text = "+5",
                fontSize = 24.sp
                //modifier = modifier
            )
        }
        if(btn4enable){
            Text(
                text = "+10",
                fontSize = 24.sp
                //modifier = modifier
            )
        }
        if(btn5enable){
            Text(
                text = "+100",
                fontSize = 24.sp
                //modifier = modifier
            )
        }
        if(result >= 2){
            btn2enable = true
            multiplier = 2
        }
        if(result >= 5){
            btn3enable = true
            multiplier = 5
        }
        if(result >= 10){
            btn4enable = true
            multiplier = 10
        }
        if(result >= 100){
            btn5enable = true
            multiplier = 100
        }
        when (result) {
            /*
            2 -> Button(onClick = {result += 2}){
                Text(
                    text = "+2",
                    fontSize = 24.sp
                    //modifier = modifier
                )
            }
            */
            //in 2..200 ->btn2enable = true
            //100 -> btn5enable = true
        }
    }

    // Bottom
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .fillMaxSize()
        //.padding()

    )
    {
        Text(
            text = "Buttons!",
            fontSize = 20.sp,
            modifier = modifier
            //padding(50.dp)
        )
        // TODO aaa
        //Button(onClick = {result = (1..6).random()}){
        Button(onClick = {result++}){
            Text(
                text = "+1",
                fontSize = 24.sp
                //modifier = modifier
            )
        }
        if(btn2enable){
            Button(onClick = {result += 2}){
                Text(
                    text = "+2",
                    fontSize = 24.sp
                    //modifier = modifier
                )
            }
        }
        if(!btn2enable){
            Button(onClick = {}){
                Text(
                    text = "+2",
                    fontSize = 24.sp,
                    color = Color.Red
                    //modifier = modifier
                )
            }
        }
        if(btn3enable){
            Button(onClick = {result += 5}){
                Text(
                    text = "+5",
                    fontSize = 24.sp
                    //modifier = modifier
                )
            }
        }
        if(!btn3enable){
            Button(onClick = {}){
                Text(
                    text = "+5",
                    fontSize = 24.sp,
                    color = Color.Red
                    //modifier = modifier
                )
            }
        }
        if(btn4enable){
            Button(onClick = {result += 10}){
                Text(
                    text = "+10",
                    fontSize = 24.sp
                    //modifier = modifier
                )
            }
        }
        if(!btn4enable){
            Button(onClick = {}){
                Text(
                    text = "+10",
                    fontSize = 24.sp,
                    color = Color.Red
                    //modifier = modifier
                )
            }
        }
        if(btn5enable){
            Button(onClick = {result += 100}){
                Text(
                    text = "+100",
                    fontSize = 24.sp
                    //modifier = modifier
                )
            }
        }
        if(!btn5enable){
            Button(onClick = {}){
                Text(
                    text = "+100",
                    fontSize = 24.sp,
                    color = Color.Red
                    //modifier = modifier
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}
