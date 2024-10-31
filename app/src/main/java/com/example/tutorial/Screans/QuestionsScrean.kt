package com.example.tutorial.Screans

import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tutorial.navigation.TourtilsScreans

@Composable
fun QuestionScrean(navController: NavController) {
    Surface {
        Box {
            fristTab(navController )


        }


    }


}
@Composable
fun fristTab(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Questions",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        WritingAndOralRow(navController)

        var isFilterActive by remember { mutableStateOf(false) }
        var showTooltip by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier.padding(top = 50.dp)
        ) {
            if (showTooltip) {
                Text(
                    text = "Filter Options",
                    color = Color.White,
                    modifier = Modifier
                        .background(Color.Black)
                        .padding(8.dp)
                        .align(Alignment.TopStart)
                        .padding(8.dp)
                )
            }

            // Card تحتوي على أيقونة الفلتر والنص "Filter"
            Card(
                modifier = Modifier.clickable {
                    isFilterActive = !isFilterActive
                    showTooltip = !showTooltip
                },
                // elevation = if (isFilterActive) 4.dp else 0.dp,
                colors = CardDefaults.cardColors(if (isFilterActive) Color.White else Color.Transparent)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = "Filter Icon",
                        tint = if (isFilterActive) Color.Green else Color.Black,
                        modifier = Modifier
                            .background(if (isFilterActive) Color.White else Color.Transparent)
                            .padding(4.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))

                    Text(
                        text = "Filter",
                        color = if (isFilterActive) Color.Green else Color.Black
                    )
                }
            }
        }

        // باقي الشاشة

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    // elevation = 2.dp
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column {
                            Text(text = "Event")
                            Text(text = "Task")
                        }

                        Text(
                            text = "Display Task ",
                            modifier = Modifier.padding(start = 16.dp)
                        )

                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Options Icon",
                            tint = Color.Black
                        )
                    }
                }
        Spacer(modifier = Modifier.height(4.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            // elevation = 2.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Event")
                    Text(text = "Task")
                }

                Text(
                    text = "Display Task ",
                    modifier = Modifier.padding(start = 16.dp)
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Options Icon",
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            // elevation = 2.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Event")
                    Text(text = "Task")
                }

                Text(
                    text = "Display Task ",
                    modifier = Modifier.padding(start = 16.dp)
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Options Icon",
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            // elevation = 2.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(text = "Event")
                    Text(text = "Task")
                }

                Text(
                    text = "Display Task ",
                    modifier = Modifier.padding(start = 16.dp)
                )

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = "Options Icon",
                    tint = Color.Black
                )
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
        Spacer(modifier = Modifier.height(4.dp))
        MyScreenWithBottomNavigation(navController, modifier = Modifier)




    }

}
@Composable
fun WritingAndOralRow(navController: NavController) {
    Row(
        modifier = Modifier
            //.clickable {}
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(modifier = Modifier.clickable {
            navController.navigate(TourtilsScreans.CustomScrean.name)
        },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Edit, // أيقونة القلم
                contentDescription = "Writing Icon",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp)) // مسافة بين الأيقونة والنص
            Text(
                text = "writing",
                fontSize = 16.sp,
                color = Color.Black
            )
        }

        Row(
            modifier = Modifier.clickable {

            },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Mic, // أيقونة الميكروفون
                contentDescription = "Oral Icon",
                tint = Color.Gray,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(8.dp)) // مسافة بين الأيقونة والنص
            Text(
                text = "oral",
                fontSize = 16.sp,
                color = Color.Black
            )
        }
    }
}

