package com.llsdc.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.llsdc.funfacts.ui.FactComposable
import com.llsdc.funfacts.ui.FactsViewModel
import com.llsdc.funfacts.ui.TextComponent
import com.llsdc.funfacts.ui.TextWithShadow
import com.llsdc.funfacts.ui.TopBar

@Composable
fun WelcomeScreen(username: String?, cardSelected: String?) {
    println("=====Inside+WelcomeScreen")
    println("=====$username and $cardSelected")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
        ) {
            TopBar("Olá $username \uD83E\uDD73")

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "Obrigado por participar!",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            val finalText =
                if (cardSelected == "Meal") "Você é um Amante de Fast Food! \uD83C\uDF54"
                else "Você é um amante de Exercícios! \uD83C\uDFCB\uFE0F\u200D♂\uFE0F"

            TextWithShadow(value = finalText)

            val factsViewModel: FactsViewModel = viewModel()
            FactComposable(
                value = factsViewModel.generateRandomFact(cardSelected!!)
            )
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen("username", "cardSelected")
}