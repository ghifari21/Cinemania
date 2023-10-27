package com.gosty.core.domain.models.common

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CollectionModel(
    val id: Long? = null,
    val name: String? = null,
    val posterPath: String? = null,
    val backdropPath: String? = null
) : Parcelable
