package com.harrybro.basicmvc.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.harrybro.basicmvc.annotation.StringFormatDateTime
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.validation.constraints.AssertTrue
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

class UserDto {

    //@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
    data class SignUpRequest(
        @field:Size(min = 2, max = 8) // 생성자에서 어노테이션을 사용하기 위해서는 field: 키워드를 붙여줘야한다.
        var name: String? = null,
        var age: Int? = null,
        @field:NotEmpty var email: String? = null,
        var address: String? = null,
        @JsonProperty("phone_number")
        var phoneNumber: String? = null,
        @field:StringFormatDateTime
        var createdAt: String? = null // yyyy-MM-dd HH:mm:ss
    ) {
//        @AssertTrue(message = "생성 일자의 패턴은 yyyy-MM-dd HH:mm:ss 이어야 합니다.")
//        private fun isValidCreatedAt(): Boolean {
//            return try {
//                LocalDateTime.parse(this.createdAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
//                true
//            } catch (e: Exception) {
//                false
//            }
//        }
    }

}