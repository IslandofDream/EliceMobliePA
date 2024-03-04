package com.junwoo.elicemobliepa.presentation.detail

data class CouresDetailModel(
    val imageUrl: String?,
    val logoUrl: String,
    val description: String?,
    val lectures: List<Pair<String, String>>,
    val title:String,
    val shortDescription:String?,
)
