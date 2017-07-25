package com.example.demo.mqtt.config

import java.io.IOException
import java.util.*


/**
 * Created by zhangyao on 17/7/24.
 * mqtt的配置
 */
object MqttConfig {

    private lateinit var p:Properties
    //监听的消息的topic
    val SUBSCRIBE_TOPIC by lazy { p.getProperty("mqtt.subscribeTopic")}

    //发的消息的topic
    val PUBLISH_TOPIC by lazy { p.getProperty("mqtt.publishTopic")}

    val SERVER_URI by lazy { p.getProperty("mqtt.serverUri")}

    val CLIENT_ID by lazy { p.getProperty("mqtt.clientId")}

    val QOS by lazy { p.getProperty("mqtt.qos").toInt()}

    init {
        val inputStream = this.javaClass.classLoader.getResourceAsStream("application.properties")
        p = Properties()
        try {
            p.load(inputStream)
        } catch (e1: IOException) {
            e1.printStackTrace()
        }finally {
            inputStream.close()
        }
    }
}