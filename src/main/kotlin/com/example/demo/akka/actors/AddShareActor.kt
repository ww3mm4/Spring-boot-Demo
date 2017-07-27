package com.example.demo.akka.actors

import akka.actor.AbstractActor
import com.example.demo.akka.message.Share

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by zhangyao on 17/7/26.
 */
@Component("addShareActor")
@Scope("prototype")
class AddShareActor : AbstractActor() {


    override fun createReceive(): AbstractActor.Receive {
        return receiveBuilder()
                .match(Share::class.java) { addShare(it) }.build()
    }

    private fun addShare(share: Share) {
        //todo
    }
}
