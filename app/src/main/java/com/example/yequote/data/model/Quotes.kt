package com.example.yequote.data.model

import androidx.versionedparcelable.VersionedParcelize
import java.io.Serializable

@VersionedParcelize
data class Quotes(
    val quote: String
) : Serializable