package com.harrybro.basicmvc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BasicMvcApplication

fun main(args: Array<String>) {
    runApplication<BasicMvcApplication>(*args)
}
