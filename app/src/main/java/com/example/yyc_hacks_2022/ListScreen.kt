package com.example.yyc_hacks_2022

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

/**
 * Composable for the screen that displays the checklist of all attractions.
 */
@Composable
fun List(navController: NavController, attractionsList : MutableList<Attraction>) {

    val attractions = remember { attractionsList }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(230,230,230))
    ) {

        Column {
            TopNavBar(navController = navController)
            Divider(color = androidx.compose.ui.graphics.Color.Black, thickness = 1.dp)

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
            ) {
                items(
                    items = attractions,
                    itemContent = {
                        ListItem(navController, attraction = it)
                    }
                )
            }
        }
    }
}

/**
 * Composable for the top navigation bar.
 */
@Composable
private fun TopNavBar(navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth().background(color = Color(120,16,46))
    ) {

        Box(
            modifier = Modifier
                .clickable {
                    navController.navigate(com.example.yyc_hacks_2022.Screen.HomeScreen.route)
                }
                .padding(top = 10.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
            ) {
            Row {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = null,
                    tint = androidx.compose.ui.graphics.Color.White
                )
                Text(
                    "  Home",
                    color = androidx.compose.ui.graphics.Color.White,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

/**
 * Composable for each list item.
 */
@Composable
private fun ListItem(navController: NavController, attraction: Attraction) {

    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        backgroundColor = Color(219, 128, 0)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "${attraction.type}:  ${attraction.name}", style = typography.h6, color = androidx.compose.ui.graphics.Color.Black)
            Text(text = "Location: ${attraction.location}", style = typography.caption, color = androidx.compose.ui.graphics.Color.Black)
            Text(text = "${attraction.date}", style = typography.caption, color = androidx.compose.ui.graphics.Color.Black)
            Text(text = "${attraction.time}", style = typography.caption, color = androidx.compose.ui.graphics.Color.Black)

            MapButton(navController)
        }
    }
}

@Composable
private fun MapButton(navController: NavController) {
    Button(
        onClick = {
            navController.navigate(Screen.MapScreen.route)
        }, shape = RoundedCornerShape(
            topEnd = 30.dp,
            bottomEnd = 30.dp
        ), colors = ButtonDefaults.buttonColors(backgroundColor = Color(120,16,46)),
        modifier = Modifier
            .padding(top = 20.dp, bottom = 5.dp)
                /*
            .border(width = 1.dp, color = androidx.compose.ui.graphics.Color.White,
            shape = RoundedCornerShape(
                topEnd = 30.dp,
                bottomEnd = 30.dp)
            )

                 */
    ) {
        Text(
            text = "View on map",
            textAlign = TextAlign.Left,
            modifier = Modifier
                .width(200.dp)
                .padding(start = 10.dp, end = 10.dp),
            color = androidx.compose.ui.graphics.Color.White
        )
        Icon(
            imageVector = Icons.Filled.ArrowForward,
            contentDescription = "Localized description",
            modifier = Modifier
                .size(30.dp),
            tint = androidx.compose.ui.graphics.Color.White
        )
    }
}