package com.example.flagsexam

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Countries (@DrawableRes val flagImage: Int,
                 @StringRes val flagName: Int,
                 val flagGeoLad: Double,
                 val flagGeoLong: Double)