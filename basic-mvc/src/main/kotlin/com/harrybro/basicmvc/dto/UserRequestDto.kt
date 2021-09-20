package com.harrybro.basicmvc.dto

data class UserRequestDto(
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var address: String? = null
)