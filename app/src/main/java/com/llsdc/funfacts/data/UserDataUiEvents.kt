package com.llsdc.funfacts.data

sealed class UserDataUiEvents {
    data class UserNameEntered(val name: String) : UserDataUiEvents()
    data class CardSelected(val cardValue: String) : UserDataUiEvents()
}