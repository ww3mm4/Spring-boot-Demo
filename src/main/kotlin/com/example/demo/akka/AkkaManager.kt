package com.example.demo.akka

import akka.actor.ActorRef
import com.example.demo.akka.message.Share
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

/**
 * Created by zhangyao on 17/7/27.
 */
@Component
class AkkaManager{
    @Autowired
    @Qualifier("addShareActorRef")
    private lateinit var addShareActor: ActorRef

    fun addShareActor(share: Share){
        addShareActor.tell(share, ActorRef.noSender())
    }
}