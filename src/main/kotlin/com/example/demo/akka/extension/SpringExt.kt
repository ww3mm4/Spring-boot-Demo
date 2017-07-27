package com.example.demo.akka.extension

import akka.actor.Extension
import akka.actor.Props
import org.springframework.beans.BeansException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by zhangyao on 17/7/25.
 */
@Component()
class SpringExt : Extension {

    @Autowired
    lateinit var applicationContext: ApplicationContext

    /**
     * Create a Props for the specified actorBeanName using the
     * SpringActorProducer class.

     * @param actorBeanName
     * *            The name of the actor bean to create Props for
     * *
     * @return a Props that will create the named actor bean using Spring
     */
    fun props(actorBeanName: String, vararg args: Any): Props {
        return Props.create(SpringActorProducer::class.java, applicationContext, actorBeanName, args)
    }

}
