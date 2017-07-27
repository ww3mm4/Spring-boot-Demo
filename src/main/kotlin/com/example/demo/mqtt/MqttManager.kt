package com.example.demo.mqtt

import com.example.demo.mqtt.config.MqttProperties
import org.eclipse.paho.client.mqttv3.*
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence



/**
 * Created by zhangyao on 17/7/24.
 * mqtt的工具类
 */
class MqttManager(val mqttProperties:MqttProperties){


    private  val mqttClient by lazy{
        //创建mqttClinet
        MqttClient(mqttProperties.SERVER_URI,
                mqttProperties.CLIENT_ID, MemoryPersistence())
    }

    /***
     * 连接mqtt服务器
     */
    fun connect() {
        mqttClient.connect(MqttConnectOptions().apply {
            isCleanSession = false
            isAutomaticReconnect = true
        })
    }

    fun setCallback(mqttStatuListener:MqttCallback){
        mqttClient.setCallback(mqttStatuListener)
    }

    /***
     * 订阅mqtt
     */
    fun subscribe(topic:String,qos:Int,messageListener: IMqttMessageListener) {
        mqttClient.subscribe(topic,qos,messageListener)
    }

    /***
     * 发送mqtt消息
     */
    fun pushMsg(topic:String,msg:String?) {
        msg ?: return
        val message = MqttMessage(msg.toByteArray()).apply {
            this.qos =mqttProperties.QOS
        }
        mqttClient.publish(topic,message)
    }


    /***
     * 断开mqtt
     */
    fun disConnect() {
        mqttClient.disconnect()
    }
}