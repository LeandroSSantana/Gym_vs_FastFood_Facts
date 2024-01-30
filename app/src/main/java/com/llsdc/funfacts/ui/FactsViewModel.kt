package com.llsdc.funfacts.ui

import androidx.lifecycle.ViewModel

class FactsViewModel : ViewModel() {

    fun generateRandomFact(selectedCard: String): String {
        return if (selectedCard == "Meal") {
            getMealFacts().random()
        } else {
            getGymFacts().random()
        }
    }

    fun getMealFacts(): List<String> {
        val mealFacts = listOf(
            "Você sabia que a maior cadeia de restaurantes de fast food do mundo é o McDonald's?",
            "A primeira pizzaria do mundo, Antica Pizzeria, foi aberta em Nápoles, Itália, em 1738.",
            "As famosas batatas fritas foram introduzidas no menu do McDonald's na década de 1940.",
            "No Japão, existe um hambúrguer que utiliza bolos de arroz em vez de pães tradicionais.",
            "O americano médio consome cerca de 46 fatias de pizza por ano.",
            "O conceito de fast food remonta à Roma antiga, onde pão e vinho eram vendidos em barracas de rua.",
            "O ketchup era vendido como remédio na década de 1830.",
            "O Big Mac foi introduzido em 1968 e rapidamente se tornou um dos hambúrgueres mais populares do McDonald's.",
            "A maior pizza do mundo tinha mais de 122 pés de diâmetro, feita na África do Sul.",
            "A invenção do sanduíche é creditada a John Montagu, o 4º Conde de Sandwich, no século XVIII."
        )
        return mealFacts
    }

    fun getGymFacts(): List<String> {
        val gymFacts = listOf(
            "A musculação fazia parte dos Jogos Olímpicos da Grécia antiga.",
            "O primeiro ginásio moderno foi inaugurado em 1849 na Inglaterra.",
            "Correr em uma esteira queima menos calorias do que correr ao ar livre devido à falta de resistência do vento.",
            "A prática regular de exercícios aumenta a produção de endorfinas, que são elevadores naturais de humor.",
            "O recorde mundial para a prancha mais longa é de mais de 8 horas!",
            "A palavra 'ginásio' vem da palavra grega 'gymnazein', que significa 'exercitar-se nu.'",
            "A atividade física regular pode melhorar a qualidade do sono.",
            "O yoga é praticado há mais de 5.000 anos e teve origem na Índia antiga.",
            "A pessoa média queima cerca de 100 calorias para cada milha caminhada ou corrida.",
            "Nadar é um exercício completo que envolve vários grupos musculares."
        )
        return gymFacts
    }

}