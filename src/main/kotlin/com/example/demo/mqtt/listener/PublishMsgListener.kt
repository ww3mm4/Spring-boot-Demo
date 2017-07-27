package com.example.demo.mqtt.listener

import com.example.demo.akka.AkkaManager
import com.example.demo.mqtt.message.toMqttMsg
import org.eclipse.paho.client.mqttv3.IMqttMessageListener
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by zhangyao on 17/7/24.
 */
@Component()
@Scope("prototype")
class PublishMsgListener : IMqttMessageListener {
    @Autowired
    private lateinit var akkaManager : AkkaManager

    override fun messageArrived(topic: String, message: MqttMessage) {
        val msg = message.toMqttMsg()?.body
    }
}