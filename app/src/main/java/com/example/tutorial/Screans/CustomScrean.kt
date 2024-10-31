package com.example.tutorial.Screans

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Brush
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Flight
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CustomScreen(navController: NavController) {
    val boxStates = remember { List(6) { mutableStateOf(false) } }
    var selectedMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // الجزء العلوي من الشاشة
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Questions",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            // WritingAndOralRow
            writingAndOralRow(navController)

            // رسالة الاختيار
            selectedMessage?.let {
                Box(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .background(Color.Black, RoundedCornerShape(8.dp))
                        .padding(8.dp)
                ) {
                    Text(text = it, color = Color.White)
                }
            }

            // صفوف تحتوي على اثنين Box في كل صف
            RowBoxPair(boxStates, 0, 1) { selectedMessage = it }
            Spacer(modifier = Modifier.height(8.dp))
            RowBoxPair(boxStates, 2, 3) { selectedMessage = it }
            Spacer(modifier = Modifier.height(8.dp))
            RowBoxPair(boxStates, 4, 5) { selectedMessage = it }
        }

        // الجزء السفلي من الشاشة
        MyScreenWithBottomNavigation(navController, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun writingAndOralRow(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.clickable {
                navController.navigate("CustomScreen")
            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Edit,
                contentDescription = "Writing Icon",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Writing",
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier.clickable {},
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Mic,
                contentDescription = "Oral Icon",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Oral",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

@Composable
fun RowBoxPair(
    boxStates: List<MutableState<Boolean>>,
    index1: Int,
    index2: Int,
    onBoxClicked: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CustomBox(index1, boxStates[index1], onBoxClicked)
        CustomBox(index2, boxStates[index2], onBoxClicked)
    }
}

@Composable
fun CustomBox(index: Int, isActive: MutableState<Boolean>, onBoxClicked: (String) -> Unit) {
    val icon = when (index) {
        0 -> Icons.Default.Flight
        1 -> Icons.Default.Brush
        2 -> Icons.Default.Place
        else -> Icons.Default.Star
    }

    val name = when (index) {
        0 -> "Flight"
        1 -> "Art"
        2 -> "Travel"
        else -> "Icon $index"
    }
    Column(
        modifier = Modifier
            .size(100.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isActive.value) Color.Green else Color.LightGray)
            .border(BorderStroke(2.dp, if (isActive.value) Color.White else Color.Transparent))
            .clickable {
                isActive.value = !isActive.value
                if (isActive.value) {
                    onBoxClicked("$name Selected")
                } else {
                    onBoxClicked(null.toString())
                }
            }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(imageVector = icon, contentDescription = name, tint = Color.Black)
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = name, color = Color.Black)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Divider(
            color = Color.Gray,
            thickness = 2.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
    }
}