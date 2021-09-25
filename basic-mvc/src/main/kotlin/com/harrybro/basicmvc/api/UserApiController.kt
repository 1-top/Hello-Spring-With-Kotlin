package com.harrybro.basicmvc.api

import com.harrybro.basicmvc.dto.UserDto
import org.jetbrains.annotations.NotNull
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.BindingResult
import org.springframework.validation.FieldError
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.Min

// https://beanvalidation.org/2.0/spec/
// Validated Annotation
// dto로 검사할 때는 사용하면 안된다.
// 단, dto가 아닌 RequestParam이거나 PathVariable을 검증할 때는 해당 어노테이션을 사용해야한다.
//@Validated
@RequestMapping("/")
@RestController
class UserApiController {

    @GetMapping("/users") // http://localhost:8080/api/users?name=harry&age=3&email=abc@test.com
    fun getBody(request: UserDto.SignUpRequest) = ResponseEntity.ok(request)

    @PostMapping("/users")
    fun userSave(
        @Valid @RequestBody request: UserDto.SignUpRequest,
        bindingResult: BindingResult // validation error를 반환받을 수 있다.
    ): ResponseEntity<Any> {
        if (bindingResult.hasErrors()) {
            StringBuilder().apply {
                bindingResult.allErrors.forEach {
                    val field = it as FieldError
                    val message = it.defaultMessage
                    this.append("${field.field}: $message\n")
                }
            }.also { return ResponseEntity.badRequest().body(it) }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(request)
    }

    @PutMapping("/users/{id}")
    fun userUpdate(@PathVariable id: String) = ResponseEntity.ok("Success update $id user.")

    @GetMapping("/users/adult")
    fun isAdult(@NotNull @Min(20, message = "User is not adult") @RequestParam age: Int) =
        ResponseEntity.ok("User is adult")


}