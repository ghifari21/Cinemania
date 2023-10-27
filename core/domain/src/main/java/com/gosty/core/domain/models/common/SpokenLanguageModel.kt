package com.gosty.core.domain.models.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SpokenLanguageModel(
    val englishName: String? = null,
    val isoCode: String? = null,
    val name: String? = null
) : Parcelable