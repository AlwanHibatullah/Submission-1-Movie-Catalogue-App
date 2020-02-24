package com.alwandroid.moviecatalogue

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var poster : Int?,
    var title : String?,
    var description : String?,
    var date : String?
) : Parcelable