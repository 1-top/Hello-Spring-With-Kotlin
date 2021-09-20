package com.harrybro.basicmvc.api

import com.harrybro.basicmvc.dto.UserRequestDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TestApiController {

    @GetMapping("/hello/{name}")
    fun getPathVariable(@PathVariable(required = false) name: String): String {
        return "Hello spring with kotlin! Hi $name"
    }

    @GetMapping("/hello")   // http://localhost:8080/api/hello?item=harry&item=bro
    fun getArrayParam(@RequestParam item: Array<String>): ResponseEntity<Array<String>> {
        return ResponseEntity.ok(item)
    }

    @GetMapping("/users") // http://localhost:8080/api/users?name=harry&age=3&email=abc@test.com
    fun getBody(request: UserRequestDto): ResponseEntity<UserRequestDto> {
        println(request)
        return ResponseEntity.ok(request);
    }

    @PostMapping("users")
    fun userSave(@RequestBody request: UserRequestDto): ResponseEntity<UserRequestDto> {
        return ResponseEntity.status(HttpStatus.CREATED).body(request)
    }

    @PutMapping("users/{id}")
    fun userUpdate(@PathVariable id:String): ResponseEntity<String> {
        println(id)
        return ResponseEntity.ok("Success update user.")
    }

}