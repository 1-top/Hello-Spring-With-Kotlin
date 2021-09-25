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

}