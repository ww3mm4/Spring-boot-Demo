package com.example.demo.mqtt.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource
import org.springframework.stereotype.Component
import java.io.IOException
import java.util.*


/**
 * Created by zhangyao on 17/7/24.
 * mqtt的配置
 */
@Configuration
@PropertySource("classpath:mqtt.properties")
class MqttProperties {


    //发的消息的topicv
    @Value("\${mqtt.publishTopic}")
    lateinit var PUBLISH_TOPIC:String

    @Value("\${mqtt.clientId}")
    lateinit var CLIENT_ID:String

    @Value("\${mqtt.serverUri}")
    lateinit var SERVER_URI:String

    @Value("\${mqtt.qos}")
    var QOS:Int=2

}