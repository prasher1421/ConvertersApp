package com.example.converters.composables.util


object ConverterUtil {
    val ConverterTypes = listOf(
        "Length",
        "Speed",
        "Weight",
        "Area",
        "Currency",
        "Time"
    )

    private val area = mapOf(
        "Square Kilometer" to 1e-6,
        "Square Meter" to 1.0,
        "Square Mile" to 3.861e-7,
        "Square Yard" to 1.19599,
        "Square Foot" to 10.7639,
        "Square Inch" to 1550.0,
        "Hectare" to 1e-4,
        "Square Mile" to 0.000247,
    )
    private val length = mapOf(
        "Kilometer" to 0.001,
        "Meter" to 1.0,
        "Centimeter" to 100.0,
        "Millimeter" to 1000.0,
        "Micrometer" to 1e6,
        "Nanometer" to 1e9,
        "Mile" to 0.000621371,
        "Yard" to 1.09361,
        "Foot" to 3.28084,
        "Inch" to 0.0254,
    )
    private val speed = mapOf(
        "Meter/s" to 1.0,
        "Kilometer/h" to 3.6,
        "Miles/h" to 2.236936,
        "Speed of Light" to 3.3356e-9
    )
    private val weight = mapOf(
        "Tonne" to 1e-6,
        "Kilogram" to 1e-3,
        "Gram" to 1.0,
        "Milligram" to 1000.0,
        "Microgram" to 1e6,
        "Ounce" to 0.0352739619,
        "Pound" to 0.0022046,
        "Stone" to 0.00015747
    )
    private val currency = mapOf(
        "Indian Rupee INR" to 79.8635,
        "US Dollar USD" to 1.0,
        "Euro EUR" to 0.9818,
        "Chinese Yuan CNY" to 6.7667,
        "UAE Dirham AED" to 3.6731,
        "Japanese Yen JPY" to 138.643
    )
    private val times = mapOf(
        "Hours" to 3600.0,
        "Minutes" to 60.0,
        "Seconds" to 1.0,
        "MilliSeconds" to .001
    )


    fun unitConvert(
        converterType : String,
        convertFrom :String,
        convertTo : String,
        amount: Double
    ):Double{
        return when(converterType){
            "Length" -> amount * length[convertTo]!! / length[convertFrom]!!
            "Area" -> amount * area[convertTo]!! / area[convertFrom]!!
            "Speed" -> amount * speed[convertTo]!! / speed[convertFrom]!!
            "Weight" -> amount * weight[convertTo]!! / weight[convertFrom]!!
            "Currency" -> amount * currency[convertTo]!!/ currency[convertFrom]!!
            "Time" -> amount * times[convertTo]!!/ times[convertFrom]!!
            else -> 0.0
        }
    }

    fun getConverterValues(
        converterType: String
    ):List<String>{
        return when(converterType){
            "Area" -> area.keys
            "Length" -> length.keys
            "Weight" -> weight.keys
            "Speed" -> speed.keys
            "Currency" -> currency.keys
            "Time" -> times.keys
            else -> setOf()
        }.toList()
    }
}
