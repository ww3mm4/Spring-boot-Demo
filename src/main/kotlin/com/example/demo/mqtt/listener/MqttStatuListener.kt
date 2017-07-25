package com.example.demo.mqtt.listener

import com.example.demo.mqtt.MqttUtil
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken
import org.eclipse.paho.client.mqttv3.MqttCallback
import org.eclipse.paho.client.mqttv3.MqttMessage

/**
 * Created by zhangyao on 17/7/24.
 * 监听mqtt的状态
 */
class MqttStatuListener : MqttCallback {
    override fun messageArrived(topic: String, message: MqttMessage) {
        MqttUtil.log.debug("messageArrived—>topic=${topic} message=${String(message.payload)}")
    }

    override fun connectionLost(cause: Throwable?) {
        MqttUtil.log.debug("mqtt connectionLost")
    }

    override fun deliveryComplete(token: IMqttDeliveryToken?) {
        token?.topics?.forEach {
            MqttUtil.log.debug("deliveryComplete—>client=${token?.client?.clientId} " +
                    "topics=${it} messageId = ${token?.messageId}}")
        }

    }
}