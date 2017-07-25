package com.example.demo.akka.actor

import akka.actor.AbstractActor
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by zhangyao on 17/7/25.
 */
@Component("testactor")
@Scope("prototype")
class TestActor  constructor(val name:String): AbstractActor() {

    override fun createReceive(): AbstractActor.Receive {
        return receiveBuilder()
                .match(String::class.java) { s -> print(s+"  ${name}") }.build()
    }
}
