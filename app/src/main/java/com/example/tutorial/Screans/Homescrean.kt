
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BuildCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Help
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import androidx.navigation.NavController
import com.example.tutorial.R
import com.example.tutorial.navigation.TourtilsScreans

@Composable
fun homescrean(navController: NavController){
    ActualScrean(navController)
    OveralScrean(navController)


}

@Composable
fun OveralScrean(navController: NavController){
    var isOverlayVisible by remember {
        mutableStateOf(true)

    }

    if (isOverlayVisible) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.overalcolor).copy(alpha = 0.8f))
                .clickable { isOverlayVisible = false },
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Welcome to: How to use and enjoy\nExamate",
                    color = Color.White,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Tap anywhere on the screen to\ncontinue",
                    color = Color(0xFF00AEEF),
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    } else {
    }


}
@Composable
  fun StudyPlanItem(number: Int, title: String, locked: Boolean = false) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 24.dp)
                .height(80.dp)
        ) {
            Box(
                modifier = Modifier
                    .width(2.dp)
                    .height(if (number == 4) 0.dp else 50.dp)
                    .background(Color.Gray)
            )
        }

        Box(
            modifier = Modifier
                .size(70.dp)
                .background(Color.Transparent, shape = CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(
                        color = if (locked) Color.Gray else Color(0xFF00AEEF),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.White, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = number.toString(),
                        color = if (locked) Color.Gray else Color(0xFF00AEEF),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }
        }

        Spacer(modifier = Modifier.width(8.dp))

        Text(
            text = title,
            color = if (locked) Color.Gray else Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        if (locked) {
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = null,
                tint = Color.Gray,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(20.dp)
            )
        }
    }
}
@Composable
fun MyScreenWithBottomNavigation(navController: NavController, modifier: Modifier) {
    val coroutineScope = rememberCoroutineScope()
    val showTooltip = remember { mutableStateOf(false) }
    val tooltipMessage = remember { mutableStateOf("") }
    val selectedTabIndex = remember { mutableStateOf(-1) }  // لتحديد التبويبة النشطة

    // أسماء الأيقونات
    val tabs = listOf("Accueil", "Connect", "Questions", "Tools", "Profile")
    val icons = listOf(
        Icons.Default.Home,
        Icons.Default.Chat,
        Icons.Default.Help,
        Icons.Default.BuildCircle,
        Icons.Default.Person
    )

    Scaffold(
        bottomBar = {
            BottomNavigation(
                backgroundColor = Color.White, // تغيير لون الخلفية إلى الأبيض
                contentColor = Color.Gray
            ) {
                tabs.forEachIndexed { index, title ->
                    BottomNavigationItem(
                        selected = selectedTabIndex.value == index,
                        onClick = {
                            selectedTabIndex.value = index

                            // إعداد الرسالة لإظهار الـ Tooltip
                            tooltipMessage.value = title
                            showTooltip.value = true

                            // الانتقال إلى الشاشة الجديدة
                            when (index) {
                                0 -> navController.navigate(TourtilsScreans.ActualScrean.name)
                                1 -> navController.navigate(TourtilsScreans.ConnectorScrean.name)
                                2 -> navController.navigate(TourtilsScreans.QuestionsScrean.name)
                                3 -> navController.navigate(TourtilsScreans.ToolsScrean.name)
                                4 -> navController.navigate(TourtilsScreans.ProfileScrean.name)
                            }
                        },
                        icon = {
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .background(
                                        color = if (selectedTabIndex.value == index) Color.White else Color.Transparent,
                                        shape = CircleShape
                                    )
                                    .shadow(4.dp, CircleShape)
                            ) {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = title,
                                    modifier = Modifier.align(Alignment.Center),
                                    tint = if (selectedTabIndex.value == index) Color.Green else Color.Gray
                                )
                            }
                        },
                        label = {
                            Text(
                                title,
                                color = if (selectedTabIndex.value == index) Color.Green else Color.Gray,
                                fontSize = 9.sp
                            )
                        },
                        alwaysShowLabel = true
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF0F0F0))
                .padding(innerPadding)
        ) {
            // محتوى الشاشة، يمكن استبداله بمكونات أخرى حسب الحاجة
            Text(text = "Main Content Area")
        }

        // عرض Tooltip عند الحاجة
        if (showTooltip.value) {
            Tooltip(message = tooltipMessage.value) {
                showTooltip.value = false // إغلاق الـ Tooltip عند الضغط
            }
        }
    }
}
// دالة تحميل البيانات لكل صفحة، بدون @Composable
fun loadDataForPage(page: Int) {
    // منطق تحميل البيانات حسب الصفحة
}

// دالة Tooltip
@Composable
fun Tooltip(message: String, onDismissRequest: () -> Unit) {
    Popup(
        alignment = Alignment.TopCenter,
        onDismissRequest = onDismissRequest
    ) {
        Surface(
            modifier = Modifier
                .padding(8.dp)
                .background(Color.Black, shape = RoundedCornerShape(4.dp))
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Text(
                text = message,
                color = Color.White,
                style = MaterialTheme.typography.body2
            )
        }
    }
}