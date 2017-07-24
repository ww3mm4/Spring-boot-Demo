package com.example.demo.mqtt

import com.example.demo.mqtt.config.MqttConfig
import com.example.demo.mqtt.listener.MqttClientCallback
import com.example.demo.mqtt.listener.SubscripMsgListener
import org.eclipse.paho.client.mqttv3.*
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence


/**
 * Created by zhangyao on 17/7/24.
 * mqtt的工具类
 */
object MqttUtil {

    private val connOpts = MqttConnectOptions().apply { isCleanSession = true }


    private val sampleClient by lazy {
        MqttClient(MqttConfig.SERVER_URI, MqttConfig.CLIENT_ID, MemoryPersistence())
    }


    /***
     * 连接mqtt服务器
     */
    fun connect() {
        sampleClient.setCallback(MqttClientCallback())
        sampleClient.connect(connOpts)
    }

    /***
     * 订阅mqtt
     */
    fun subscribe(topic:String,qos:Int,messageListener: IMqttMessageListener) {
        sampleClient.subscribe(topic,qos,messageListener)
    }

    /***
     * 发送mqtt消息
     */
    fun pushMsg(topic:String,qos: Int,msg:String?) {
        msg ?: return
        val message = MqttMessage(msg.toByteArray()).apply {
            this.qos =qos
        }
        sampleClient.publish(topic,message)
    }


    /***
     * 断开mqtt
     */
    fun disConnect() {
        sampleClient.disconnect()
    }
}