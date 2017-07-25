package com.example.demo.akka2

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.routing.RoundRobinPool
import akka.routing.RouterConfig
import com.example.demo.akka.Extension.SpringExt
import com.example.demo.akka2.actors.DemoActor
import com.example.demo.akka2.actors.Sub1Actor
import com.example.demo.akka2.actors.Sub2Actor
import com.example.demo.akka2.actors.Sub3Actor



/**
 * Created by zhangyao on 17/7/25.
 */
object AkkaUtil {
    private val system by lazy { ActorSystem.create("helloakka") }

    val sub1Actor by lazy { system.actorOf(Sub1Actor.props().withRouter(RoundRobinPool(3)), "sub1Actor") }
    val sub2Actor by lazy { system.actorOf(Sub2Actor.props().withRouter(RoundRobinPool(3)), "sub2Actor") }
    val sub3Actor by lazy { system.actorOf(Sub3Actor.props().withRouter(RoundRobinPool(3)), "sub3Actor") }

    val demoActor by lazy { system.actorOf(DemoActor.props().withRouter(RoundRobinPool(3)),"DemoActor")}

    fun tell(msg:String){
        demoActor.tell(msg,ActorRef.noSender())
    }
}