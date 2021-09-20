package com.harrybro.basicmvc.dto

import com.fasterxml.jackson.annotation.JsonProperty

class UserDto {

    //@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    data class SignUpRequest(
        var name: String? = null,
        var age: Int? = null,
        var email: String? = null,
        var address: String? = null,

        @JsonProperty("phone_number")
        var phoneNumber: String? = null
    )

}