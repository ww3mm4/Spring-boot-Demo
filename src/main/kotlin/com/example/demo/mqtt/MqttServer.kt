package com.example.demo.mqtt

import io.moquette.interception.InterceptHandler
import io.moquette.server.Server
import io.moquette.server.config.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

import java.io.File
import java.io.IOException

import java.util.Arrays.asList

/**
 * Created by zhangyao on 17/7/24.
 */
@Component
class MqttServer {
    companion object {
        val mqttBroker = Server()
    }

    @Throws(IOException::class)
    fun start() {
        val classpathLoader = ClasspathResourceLoader()
        val classPathConfig = ResourceLoaderConfig(classpathLoader)
        val userHandlers = asList(PublisherListener())
        mqttBroker.startServer(classPathConfig, userHandlers)
    }

    fun stop() {
        mqttBroker.stopServer()
    }
}