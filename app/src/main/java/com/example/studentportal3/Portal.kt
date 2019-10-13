package com.example.studentportal3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// allow them to be parsed
@Parcelize
data class Portal(
    val name: String,
    val url: String
) : Parcelable