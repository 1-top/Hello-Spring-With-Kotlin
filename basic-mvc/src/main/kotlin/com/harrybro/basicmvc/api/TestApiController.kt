package com.harrybro.basicmvc.api

import com.harrybro.basicmvc.dto.UserDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TestApiController {

    @GetMapping("/hello/{name}")
    fun getPathVariable(@PathVariable(required = false) name: String) = "Hello spring with kotlin! Hi $name"

    @GetMapping("/hello")   // http://localhost:8080/api/hello?item=harry&item=bro
    fun getArrayParam(@RequestParam item: Array<String>) = ResponseEntity.ok(item)

    @GetMapping("/users") // http://localhost:8080/api/users?name=harry&age=3&email=abc@test.com
    fun getBody(request: UserDto.SignUpRequest) = ResponseEntity.ok(request)

    @PostMapping("users")
    fun userSave(@RequestBody request: UserDto.SignUpRequest) = ResponseEntity.status(HttpStatus.CREATED).body(request)

    @PutMapping("users/{id}")
    fun userUpdate(@PathVariable id: String): ResponseEntity<String> = ResponseEntity.ok("Success update $id user.")

}