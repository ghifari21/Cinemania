package com.gosty.model.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProducerModel(
    val id: Long? = null,
    val creditId: String? = null,
    val name: String? = null,
    val gender: Int? = null,
    val profilePath: String? = null
) : Parcelable