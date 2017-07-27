package com.example.demo.mqtt.config

import com.example.demo.mqtt.MqttManager
import com.example.demo.mqtt.listener.MqttStatuListener
import com.example.demo.mqtt.listener.PublishMsgListener
import org.eclipse.paho.client.mqttv3.MqttClient
import org.eclipse.paho.client.mqttv3.MqttConnectOptions
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

/**
 * Created by zhangyao on 17/7/27.
 */
@Configuration
@ComponentScan(basePackages = arrayOf("com.example.demo.mqtt.listener","com.example.demo.mqtt.config"))
class MqttConfiguration {

    @Autowired
    private lateinit var mqttProperties:MqttProperties

    @Autowired
    private lateinit var publishMsgListener: PublishMsgListener

    @Autowired
    private lateinit var mqttStatuListener: MqttStatuListener

    @Bean
    fun mqttManager(): MqttManager {
        val mqttManager = MqttManager(mqttProperties)
        //监听mqtt状态的回调
        mqttManager.setCallback(mqttStatuListener)
        mqttManager.connect()
        //订阅topic
        mqttManager.subscribe(mqttProperties.PUBLISH_TOPIC, mqttProperties.QOS,publishMsgListener)

        return mqttManager
    }


}