package com.llsdc.funfacts.ui

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.llsdc.funfacts.data.UserDataUiEvents
import com.llsdc.funfacts.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    companion object {
        const val TAG = "UserInputViewModel"
    }

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when (event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "onEvent: UserNameEntered->>")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.CardSelected -> {
                uiState.value = uiState.value.copy(
                    cardSelected = event.cardValue
                )
                Log.d(TAG, "onEvent: CardSelected->>")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }

    fun isValidState(): Boolean {
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.cardSelected.isNullOrEmpty()
    }

}
