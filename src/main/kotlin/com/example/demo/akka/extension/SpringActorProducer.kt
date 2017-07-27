package com.example.demo.akka.extension

import akka.actor.Actor
import akka.actor.IndirectActorProducer
import org.springframework.context.ApplicationContext

/**
 * Created by zhangyao on 17/7/25.
 */
class SpringActorProducer(private val applicationContext: ApplicationContext, private val actorBeanName: String, vararg args: Any) : IndirectActorProducer {
    private val args: Array<out Any>

    init {
        this.args = args
    }

    override fun produce(): Actor {
        return applicationContext.getBean(actorBeanName, *args) as Actor
    }

    override fun actorClass(): Class<out Actor> {
        return applicationContext.getType(actorBeanName) as Class<out Actor>
    }
}
