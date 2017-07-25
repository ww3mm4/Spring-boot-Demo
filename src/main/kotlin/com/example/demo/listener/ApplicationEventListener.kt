package com.example.demo.listener

import com.example.demo.mqtt.MqttUtil
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent
import org.springframework.boot.context.event.ApplicationPreparedEvent
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.ContextStartedEvent
import org.springframework.context.event.ContextStoppedEvent


/**
 * Created by zhangyao on 17/7/24.
 */
class ApplicationEventListener : ApplicationListener<ApplicationEvent> {
    override fun onApplicationEvent(event: ApplicationEvent?) {
        // 在这里可以监听到Spring Boot的生命周期
        when(event){
            is ApplicationEnvironmentPreparedEvent->{}
            is ApplicationPreparedEvent->{} // 初始化完成
            is ContextRefreshedEvent->{} // 应用刷新
            is ApplicationReadyEvent->{} //应用已启动完成
            is ContextStartedEvent->{} // 应用启动，需要在代码动态添加监听器才可捕获
            is ContextStoppedEvent->{} //应用停止
            is ContextClosedEvent->{MqttUtil.disConnect()}// 应用关闭
        }

    }
}