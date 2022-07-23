package com.example.yyc_hacks_2022

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    Column(Modifier.verticalScroll(rememberScrollState())) {

        Box(
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp, end = 20.dp)
                .background(
                    color = Color(128, 30, 0), shape =
                    RoundedCornerShape(
                        topEnd = 20.dp,
                        bottomEnd = 20.dp,
                        bottomStart = 20.dp,
                        topStart = 20.dp
                    )
                )
        ) {
            Text(
                "Welcome to Calgary Connect!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 10.dp, bottom = 10.dp, end = 10.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                color = Color.White
            )
        }

        Text("Get informed on downtown community attractions, businesses, restaurants, and" +
                " events near you!",
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
            textAlign = TextAlign.Left)

        Text("To begin, fill out the following survey so we can cater the results to your interests.",
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
            textAlign = TextAlign.Left)

        Text("<survey> (to-do)",
            modifier = Modifier.padding(start = 20.dp, top = 20.dp, end = 20.dp),
            textAlign = TextAlign.Left)

        Button(
            onClick = {
                navController.navigate(Screen.ListScreen.withArgs(0))
            }, shape = RoundedCornerShape(
                topEnd = 30.dp,
                bottomEnd = 30.dp
            ), colors = ButtonDefaults.buttonColors(backgroundColor = Color(219, 128, 0)),
            modifier = Modifier
                .padding(top = 300.dp, bottom = 5.dp, start = 5.dp)
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
