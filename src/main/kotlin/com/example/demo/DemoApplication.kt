package com.example.demo

import com.example.demo.mqtt.MqttUtil
import com.example.demo.mqtt.config.MqttConfig
import com.example.demo.mqtt.listener.PublishMsgListener
import com.example.demo.mqtt.listener.SubscripMsgListener
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class DemoApplication{
    init {
        MqttUtil.connect()
        MqttUtil.subscribe(MqttConfig.SUBSCRIBE_TOPIC,MqttConfig.QOS,SubscripMsgListener())
        MqttUtil.subscribe(MqttConfig.PUBLISH_TOPIC,MqttConfig.QOS,PublishMsgListener())
    }
}


fun main(args: Array<String>) {
    SpringApplication.run(DemoApplication::class.java, *args)
}
