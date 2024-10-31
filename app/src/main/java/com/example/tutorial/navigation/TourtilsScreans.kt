package com.example.tutorial.navigation

enum class TourtilsScreans {
    HomeScrean,
    ActualScrean,
    ConnectorScrean,
    QuestionsScrean,
    ToolsScrean,
    CustomScrean,
    ProfileScrean;

    companion object {
        fun getScreenName(screen: TourtilsScreans): String {
            return when (screen) {

                HomeScrean -> HomeScrean.name
                ActualScrean -> ActualScrean.name
                ConnectorScrean -> ConnectorScrean.name
                CustomScrean -> CustomScrean.name
                QuestionsScrean -> QuestionsScrean.name
                ToolsScrean -> ToolsScrean.name
                ProfileScrean -> ProfileScrean.name


                null -> "null"


                else -> throw IllegalArgumentException("Screan not found")

            }

        }
    }
}