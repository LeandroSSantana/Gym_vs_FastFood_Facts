package com.llsdc.funfacts.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.llsdc.funfacts.R
import com.llsdc.funfacts.data.UserDataUiEvents
import com.llsdc.funfacts.ui.ButtonComponent
import com.llsdc.funfacts.ui.ImageCard
import com.llsdc.funfacts.ui.TextComponent
import com.llsdc.funfacts.ui.TextFieldComponent
import com.llsdc.funfacts.ui.TopBar
import com.llsdc.funfacts.ui.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    showWelcomeScreen: (valuesPair: Pair<String, String>) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp),
        ) {
            TopBar("Fala Jovem! \uD83D\uDCAA\uD83C\uDFFE")

            TextComponent(
                textValue = "Vamos descobrir mais sobre o que você gosta?",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textValue = "Iremos mostrar a você curiosidades sobre suas preferências",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Nome", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "O que você Prefere? ", textSize = 18.sp)

            Row(modifier = Modifier.fillMaxWidth()) {
                ImageCard(image = R.drawable.mealsbg, cardSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.CardSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.cardSelected == "Meal")
                ImageCard(image = R.drawable.gymsbg, cardSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.CardSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.cardSelected == "Gym")
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState())
                ButtonComponent(
                    goToDetailsScreen = {
                        println("============ComingHere")
                        println("============${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.cardSelected}")
                        showWelcomeScreen(
                            Pair(
                                userInputViewModel.uiState.value.nameEntered,
                                userInputViewModel.uiState.value.cardSelected
                            )
                        )
                    }
                )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(
        userInputViewModel = UserInputViewModel(),
        showWelcomeScreen = {

        }
    )
}