package com.nzdevelope009.jetpackcompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            previewFunction()
        }
    }
}


@Composable
fun sayDevs(name: String) {
    Text(
        text = "Hello $name",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.SemiBold,
        color = Color.Red,
        fontSize = 36.sp,
        textAlign = TextAlign.Right
    )
}

@Composable
private fun imgFun() {
    Image(
        painter = painterResource(id = R.drawable.ic_broken_heart),
        contentDescription = "Dummy Image",
        contentScale = ContentScale.Fit,
        colorFilter = ColorFilter.tint(Color.Black)
    )
}

@Composable
private fun btnCompose() {
    Button(
        onClick = { }, colors = ButtonDefaults.buttonColors(
            contentColor = Color.Black,
            backgroundColor = Color.Cyan
        )
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_broken_heart),
            contentDescription = "Heart Broken"
        )
        Text(text = "Hello")

    }
}

@Composable
private fun inputCompose() {
    val state = remember {
        mutableStateOf("")
    }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
            Log.d("NZDeveloper009_InputCompose", "inputCompose -> $it")
        },
        label = {
            Text(
                text = "Enter Name"
            )
        }
    )
}

/*
* Layout Composables - Row, Column, Box
* Arragnment = Bacha howa space elements k bech kese divide hoga
* Alignment = rakhna kese hai elements ko
* */
@Composable
private fun colCompose() {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "A",
            fontSize = 24.sp
        )
        Text(
            text = "B",
            fontSize = 24.sp
        )
    }
}

@Composable
private fun rowCompose() {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "A",
            fontSize = 24.sp
        )
        Text(
            text = "B",
            fontSize = 24.sp
        )
    }
}

/*
* Box similar like FrameLayout
* in box we use contentAlignment attribute to align element
*
* */
@Composable
private fun boxCompose() {
    Box(
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ic_broken_heart
            ),
            contentDescription = "Broken Heart"
        )
        Image(
            painter = painterResource(
                id = R.drawable.ic_arrow
            ),
            contentDescription = "Arrow"
        )
    }
}

/*
* Example of layout
* Modifiers
*   To modify size, display, appearance and behaviour of the Composable
*   Size, Background Colour, Paddings, Click Handlers
*   Composition over Inheritance
*   Can be chained and Sequence matters here.
* */

@Composable
private fun ListViewItem(imgId: Int, name: String, occupation: String, modifier: Modifier) {
    Row(
        modifier.padding(8.dp),
    ) {
        Image(
            painter = painterResource(
                id = imgId
            ),
            contentDescription = "Person Pin",
            Modifier.size(40.dp)
        )
        Column() {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
            )
            Text(
                text = occupation,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp
            )
        }
    }
}


@Composable
private fun modifierExample() {
    Text(
        text = "Hello",
        color = Color.White,
        modifier = Modifier
            .clickable { }
            .background(Color.Blue)
            .size(200.dp)
            .padding(36.dp)
            .border(4.dp, Color.Red)
            .clip(CircleShape)
            .background(Color.Yellow)
            .fillMaxSize() // full width + height cover
    )
}

@Composable
private fun CircularImage() {
    Image(
        painter = painterResource(id = R.drawable.syed_nokhaiz_al_hassan),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, Color.LightGray, CircleShape),
        contentDescription = "Syed Nokhaiz Al Hassan Image"
    )
}

@Composable
private fun Recomposable() {
    val state = remember {
        mutableStateOf(0.0)
    }
    Log.d("TAGGED", "Recomposable: Logged during Initial Composition")
    Button(onClick = {
        state.value = Math.random()
    }) {
        Log.d("TAGGED", "Recomposable: Logged Both Composition & Recomposition")
        Text(text = state.value.toString())
    }
}


// StateFul composable
// Uni-Directional Composable -> Top level to down way data flow (Parent to child data flow)
// Button Click Event Down to Up that's called Uni-Directional Composable
@Composable
fun NotificationScreen() {
    // State Hoisting
    var count = rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)
    ) {

        NotificationCounter(count.value, { count.value++ })
        MessageBar(count.value)
    }
}

// StateLess composable
@Composable
fun NotificationCounter(count: Int, increment: () -> Unit) {
    // just remember the state of value and recompose the composable function
    // but when we change the layout or change the configuration
    // value become zero and composable function again come to initial state
    /*var count = remember {
        mutableStateOf(0)
    }*/

    // to solve above problem we use rememberSaveable instead of remember
    /*var count = rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "You have sent $count notification")
        Button(onClick = {
            count++
            Log.d("TAGGED", "NotificationCounter: Button Clicked")
        }) {
            Text(text = "Send Notification")
        }
    }*/

    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "You have sent $count notification")
        Button(onClick = { increment() }) {
            Text(text = "Send Notification")
        }
    }
}

// StateLess composable
@Composable
fun MessageBar(count: Int) {
    Card(
        elevation = 4.dp
    ) {
        Row(
            Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = "",
                Modifier.padding(4.dp)
            )
            Text(text = "Messages sent so far - $count")
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 300,
    heightDp = 500
)
@Composable
private fun previewFunction() {
//    sayDevs("Nokhaiz")
//    imgFun()
//    inputCompose()
//    colCompose()
//    rowCompose()
//    boxCompose()
    /*Column() {
        ListViewItem(R.drawable.ic_person_pin,"Syed Nokhaiz Al Hassan","Mobile App Developer")
        ListViewItem(R.drawable.ic_person_pin,"Syed Nokhaiz Al Hassan","Mobile App Developer")
        ListViewItem(R.drawable.ic_person_pin,"Syed Nokhaiz Al Hassan","Mobile App Developer")
    }*/
//    modifierExample()
//    CircularImage()
//    previewItem()
//    Recomposable()
    NotificationScreen()
}

