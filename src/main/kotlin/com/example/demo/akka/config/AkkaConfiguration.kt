package com.example.demo.akka.config

import akka.actor.ActorRef
import akka.actor.ActorSystem
import akka.routing.RoundRobinPool
import com.example.demo.akka.extension.SpringExt
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource


/**
 * Created by zhangyao on 17/7/27.
 */
@Configuration
@ComponentScan(basePackages = arrayOf("com.example.demo.akka.extension"))
@PropertySource("classpath:akka.properties")
class AkkaConfiguration {
    @Value("\${akka.actorSystemName}")
    private lateinit var actorSystemName:String


    @Value("\${akka.addShareActorPool}")
    private var addShareActorPool:Int=1


    @Autowired
    private lateinit var sringExt: SpringExt

    private val system by lazy {ActorSystem.create(actorSystemName)}

    @Bean(value = "addShareActorRef")
    fun addShareActor(): ActorRef {
        return system.actorOf(sringExt.props("addShareActor")
                .withRouter(RoundRobinPool(addShareActorPool)), "addShareActor")
    }
}