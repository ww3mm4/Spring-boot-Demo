package com.example.demo.mqtt.listener

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Scope
import org.springframework.stereotype.Component

/**
 * Created by zhangyao on 17/7/24.
 * 监听mqtt的状态
 */
@Component()
@Scope("prototype")
class MqttStatuListener : MqttCallback {
    override fun messageArrived(topic: String, message: MqttMessage) {
    }

    override fun connectionLost(cause: Throwable?) {
    }

    override fun deliveryComplete(token: IMqttDeliveryToken?) {
        token?.topics?.forEach {

        }

    }
}