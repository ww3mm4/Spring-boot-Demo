package com.example.demo.mqtt.config

/**
 * Created by zhangyao on 17/7/24.
 * mqtt的配置
 */
object MqttConfig {

    //监听的消息的topic
    val SUBSCRIBE_TOPIC ="subscribe_topic"

    //发的消息的topic
    val PUBLISH_TOPIC ="publish_topic"

    val SERVER_URI ="tcp://192.168.0.12:1883"

    val CLIENT_ID ="service_client"

    val QOS = 2


}