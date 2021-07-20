package com.example.mvvmbasic.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote(
    val quote: String,
    val author: String
    ) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
    override fun toString() = "$quote - $author"
}
