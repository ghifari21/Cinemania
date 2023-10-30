package com.gosty.core.domain.models.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NetworkModel(
    val id: Long? = null,
    val logoPath: String? = null,
    val name: String? = null,
    val originCountry: String? = null
) : Parcelable