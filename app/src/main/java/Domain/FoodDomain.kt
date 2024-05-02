package Domain

import java.io.Serializable

data class FoodDomain(
    val title: String,
    val pic: String,
    val description: String,
    val fee: Double,
    var numberInCart: Int = 0
) : Serializable
