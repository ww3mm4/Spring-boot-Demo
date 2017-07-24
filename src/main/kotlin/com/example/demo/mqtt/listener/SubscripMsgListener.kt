package com.example.demo.mqtt.listener

import com.example.demo.mqtt.config.MqttConfig
import com.example.demo.mqtt.MqttUtil
import com.example.demo.mqtt.message.toMqttMsg
import org.eclipse.paho.client.mqttv3.IMqttMessageListener
import org.eclipse.paho.client.mqttv3.MqttMessage

/**
 * Created by zhangyao on 17/7/24.
 * 测试用的IMqttMessageListener
 */

class SubscripMsgListener : IMqttMessageListener{
    override fun messageArrived(topic: String, message: MqttMessage) {
        val msg = message.toMqttMsg()
        System.out.println("subscrip msg--> topic=${topic} " +
                "message=${msg?.body}")
    }

}
