package com.example.demo.akka2.actors

import akka.actor.AbstractActor
import akka.actor.Props
import java.util.*

/**
 * Created by zhangyao on 17/7/25.
 */
class Sub3Actor : AbstractActor {

    private constructor()

    companion object {
        fun props(): Props {
            return Props.create(Sub3Actor::class.java)
        }
    }

    override fun createReceive(): Receive {
        return receiveBuilder().match<String>(String::class.java) {
            Thread.sleep(Random().nextInt(3000).toLong())
            println("${javaClass.name}+${Thread.currentThread().getName()}+$it")
        }
                .build()
    }
}