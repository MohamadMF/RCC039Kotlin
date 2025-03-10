package com.example.flagsexam

class FlagList {
    fun loadCountries() : MutableList<Countries> {
        return mutableListOf(
            Countries(R.drawable.egyptian_flag, R.string.egypt,
                30.033333, 31.233334),

            Countries(R.drawable.russian_flag, R.string.russia,
                55.751244, 37.618423),

            Countries(R.drawable.madagascar_flag, R.string.madagascar,
                -18.7669,46.8691),
        )
    }
}