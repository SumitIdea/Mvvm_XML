package com.example.mvvm_xml.data

import com.example.mvvm_xml.data.Result

data class Movies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)
