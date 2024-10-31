package com.example.tutorial.Screans

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ActualScrean(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEFEFEF))
            .padding(16.dp)
    ) {
        Text(
            text = "Home",
            color = Color(0xFF1B5E20),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Hi Dalia",
            color = Color.Gray,
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Study Plan",
            color = Color(0xFF1B5E20),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            StudyPlanItem(number = 1, title = "Unite 1: what is examate")
            StudyPlanItem(number = 2, title = "Unite 2: what is TCF", locked = true)
            StudyPlanItem(number = 3, title = "Writing Tasks", locked = true)
            StudyPlanItem(number = 4, title = "Oral Task", locked = true)
            StudyPlanItem(number = 5, title = "addation Task", locked = true)
        }
        Spacer(modifier = Modifier.height(20.dp))
        MyScreenWithBottomNavigation(navController, Modifier.padding(10.dp))

    }




}