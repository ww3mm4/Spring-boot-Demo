package com.example.demo.akka2.actors

import akka.actor.AbstractActor
import akka.actor.ActorRef
import akka.actor.Props
import com.example.demo.akka2.AkkaUtil
import java.util.*

/**
 * Created by zhangyao on 17/7/25.
 */
class DemoActor : AbstractActor {

    private constructor()

    companion object {
        fun props(): Props {
            return Props.create(DemoActor::class.java)
        }
    }

    override fun createReceive(): Receive {
        return receiveBuilder()
                .match<String>(String::class.java) {
                    println("${javaClass.name}+${Thread.currentThread().getName()}+$it")
                    Thread.sleep(Random().nextInt(3000).toLong())
                    AkkaUtil.sub1Actor.tell(it, ActorRef.noSender())
                    AkkaUtil.sub2Actor.tell(it, ActorRef.noSender())
                    AkkaUtil.sub3Actor.tell(it, ActorRef.noSender())
                }
                .build()
    }

}