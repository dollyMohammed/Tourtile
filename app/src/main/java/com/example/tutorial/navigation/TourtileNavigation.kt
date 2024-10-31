package com.example.tutorial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tutorial.Screans.ActualScrean
import com.example.tutorial.Screans.CustomScreen
import com.example.tutorial.Screans.ProfileScrean
import com.example.tutorial.Screans.QuestionScrean
import com.example.tutorial.Screans.ToolScrean
import com.example.tutorial.Screans.contentscrean
import com.example.tutorial.Screans.homescrean

@Composable
fun TourtilNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = TourtilsScreans.HomeScrean.name) {
        composable(TourtilsScreans.HomeScrean.name){
            homescrean(navController=navController)
        }
        composable(TourtilsScreans.ActualScrean.name){
            ActualScrean(navController=navController)
        }

        composable(TourtilsScreans.ConnectorScrean.name){
            contentscrean(navController=navController)
        }
        composable(TourtilsScreans.QuestionsScrean.name){
            QuestionScrean(navController=navController)
        }
        composable(TourtilsScreans.ToolsScrean.name){
            ToolScrean(navController=navController)
        }
        composable(TourtilsScreans.ProfileScrean.name){
            ProfileScrean(navController=navController)
        }
        composable(TourtilsScreans.CustomScrean.name){
            CustomScreen(navController=navController)
        }





    }
    }