package com.example.connect_calgary

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(230, 230, 230))
    ) {
        Column(Modifier.verticalScroll(rememberScrollState())) {

            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth().background(color = Color(120,16,46))
            ) {
                Image(painter = painterResource(id = R.drawable.whitelogo), contentDescription = "logo",
                    modifier=Modifier.padding(start=20.dp, top=0.dp, bottom = 10.dp).size(100.dp)
                )
                Text(
                        "Welcome to Calgary Connect!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 20.dp, bottom = 10.dp, end = 10.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                color = Color.White
                )
            }



            Text("Get informed on downtown community attractions, businesses, restaurants, and" +
                    " events near you!",
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
                textAlign = TextAlign.Left,
                color = Color.Black)

            Text("To begin, fill out the following survey so we can cater the results to your interests.",
                modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
                textAlign = TextAlign.Left,
                color = Color.Black)

            surveyQ1()
            surveyQ2()
            surveyQ3()
            surveyQ4()
            surveyQ5()

            Button(
                onClick = {
                    navController.navigate(Screen.ListScreen.route)
                }, shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    bottomEnd = 30.dp
                ), colors = ButtonDefaults.buttonColors(backgroundColor = Color(219, 128, 0)),
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 40.dp, start = 5.dp)
                    .border(
                        1.dp, color = Color.Black, shape = RoundedCornerShape(
                            topEnd = 30.dp,
                            bottomEnd = 30.dp
                        )
                    ),
            ) {
                Text(
                    text = "View attractions near me!",
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .width(250.dp)
                        .padding(end = 10.dp),
                    color = Color.Black
                )
                Icon(
                    imageVector = Icons.Filled.ArrowForward,
                    contentDescription = "Localized description",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(),
                    tint = Color.Black
                )
            }
        }
    }
}

@Composable
fun surveyQ1() {

    Text("Q1: Where do you want to eat?\n",
        modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
        textAlign = TextAlign.Left,
        color = Color.Black,
        fontWeight = FontWeight.Bold)

    val radioOptions = listOf(
        "Lunch at a local diner",
        "Restaurant cuisine",
        "Let's try some new flavours",
        "I can eat anything really!")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(120, 16, 46),
                        unselectedColor = Color(120, 16, 46),
                        disabledColor = Color(120, 16, 46)
                    ),
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 10.dp, top= 13.dp),
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun surveyQ2() {

    Text("Q2: What are your dietary restrictions?\n",
        modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
        textAlign = TextAlign.Left,
        color = Color.Black,
        fontWeight = FontWeight.Bold)

    val radioOptions = listOf(
        "Halal",
        "Vegan and vegetarian",
        "Gluten free",
        "None!")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(120, 16, 46),
                        unselectedColor = Color(120, 16, 46),
                        disabledColor = Color(120, 16, 46)
                    ),
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 10.dp, top= 13.dp),
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun surveyQ3() {

    Text("Q3: What draws you to a city?\n",
        modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
        textAlign = TextAlign.Left,
        color = Color.Black,
        fontWeight = FontWeight.Bold)

    val radioOptions = listOf(
        "The history",
        "The night life",
        "Downtown culture",
        "I want to see everything!")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(120, 16, 46),
                        unselectedColor = Color(120, 16, 46),
                        disabledColor = Color(120, 16, 46)
                    ),
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 10.dp, top= 13.dp),
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun surveyQ4() {

    Text("Q4: What’s your idea of a good time?\n",
        modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
        textAlign = TextAlign.Left,
        color = Color.Black,
        fontWeight = FontWeight.Bold)

    val radioOptions = listOf(
        "Something quiet and chill. Maybe with a cat or two",
        "A big event with lots of people and free food!",
        "Murals, gardens, museums; anything artsy is totally for me",
        "I’ll try anything with the right people")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(120, 16, 46),
                        unselectedColor = Color(120, 16, 46),
                        disabledColor = Color(120, 16, 46)
                    ),
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 10.dp, top= 13.dp),
                    color = Color.Black
                )
            }
        }
    }
}

@Composable
fun surveyQ5() {

    Text("Q5: What’s your price range?\n",
        modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
        textAlign = TextAlign.Left,
        color = Color.Black,
        fontWeight = FontWeight.Bold)

    val radioOptions = listOf(
        "\$",
        "\$\$",
        "\$\$\$",
        "Anything is fine!")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[1] ) }
    Column {
        radioOptions.forEach { text ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = (text == selectedOption),
                        onClick = {
                            onOptionSelected(text)
                        }
                    )
                    .padding(horizontal = 16.dp)
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = { onOptionSelected(text) },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color(120, 16, 46),
                        unselectedColor = Color(120, 16, 46),
                        disabledColor = Color(120, 16, 46)
                    ),
                )
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1.merge(),
                    modifier = Modifier.padding(start = 10.dp, top= 13.dp),
                    color = Color.Black
                )
            }
        }
    }
}