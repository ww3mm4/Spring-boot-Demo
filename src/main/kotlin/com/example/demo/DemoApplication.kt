package com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.IOException
import com.example.demo.mqtt.MqttServer



@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
    val app=SpringApplication.run(DemoApplication::class.java, *args)

    val mqttBroker = app.getBean(MqttServer::class.java)  //new MqttServer();
    try {
        mqttBroker.start()
    } catch (e: IOException) {
        e.printStackTrace()
        System.exit(1)
    }
}
