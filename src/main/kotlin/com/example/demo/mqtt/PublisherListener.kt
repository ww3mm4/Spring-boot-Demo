package com.example.demo.mqtt

import io.moquette.interception.AbstractInterceptHandler
import io.moquette.interception.messages.InterceptPublishMessage
import io.netty.buffer.Unpooled
import io.netty.handler.codec.mqtt.MqttQoS
import io.netty.handler.codec.mqtt.MqttMessageBuilders
import io.netty.handler.codec.mqtt.MqttPublishMessage



/**
 * Created by zhangyao on 17/7/24.
 */
class PublisherListener : AbstractInterceptHandler() {


    override fun getID(): String? {
        return null
    }

    override fun onPublish(msg: InterceptPublishMessage?) {
        System.out.print("topicName=${msg?.topicName},payload${msg?.payload.toString()}")
        val message = MqttMessageBuilders.publish()
                .topicName(msg?.topicName)
                .retained(true)
                .qos(MqttQoS.EXACTLY_ONCE)
                .payload(Unpooled.copiedBuffer("Hello World!!".toByteArray()))
                .build()
        MqttServer.mqttBroker.internalPublish(message,msg?.clientID)
    }
}
