package com.nextgen.jetcoffeecompose.model

import com.nextgen.jetcoffeecompose.R

data class Menu(
    var name: String,
    var price: String,
    var imageUrl: Int
)

val dummyMenu = listOf<Menu>(
    Menu("Capucinno", "Rp, 12.000", R.drawable.menu3),
    Menu("Late", "Rp, 10.000", R.drawable.menu2),
    Menu("Sanger", "Rp, 15.000", R.drawable.menu4),
    Menu("Mocacinno", "Rp, 10.000", R.drawable.menu1),
)

val dummyBestSeller = listOf<Menu>(
    Menu("Teh Susu Telur", "Rp, 12.000", R.drawable.menu2),
    Menu("Kopi late Apel", "Rp, 15.000", R.drawable.menu1),
    Menu("Cappucino Late Dove", "Rp, 15.000", R.drawable.menu3),
    Menu("Moca black coffee", "Rp, 12.000", R.drawable.menu4),
)
