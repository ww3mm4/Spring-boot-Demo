package com.example.demo

import akka.actor.ActorRef
import akka.actor.ActorSystem
import com.example.demo.akka.Extension.SpringExt
import com.example.demo.akka2.AkkaUtil
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
    AkkaUtil.tell("haha1")
    AkkaUtil.tell("haha2")
    AkkaUtil.tell("haha3")
    AkkaUtil.tell("haha4")
    AkkaUtil.tell("haha5")
}
