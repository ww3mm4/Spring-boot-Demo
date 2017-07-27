package com.example.demo.mqtt.message

import org.eclipse.paho.client.mqttv3.MqttMessage
import java.util.*

/**
 * Created by zhangyao on 17/7/24.
 */

//分割字符串
val BOUNDARY = "boundary"
//json类型
val JSON_TYPE = "application/json"


data class MqttMsg(val header: Map<String, String>, val boundary: String?, val body: String) {
    override fun toString(): String {
        val builder = StringBuilder()

        for ((k, v) in header) {
            builder.append("$k=\"$v\"\n")
        }
        builder.append("${boundary}\n")
        builder.append("${body}")
        return builder.toString()
    }
}


fun String.toMqttMsg(type: String = JSON_TYPE): MqttMsg {
    val boundary = getRandomString(11)
    val header = mutableMapOf<String, String>(
            Pair("version", "1.0.0"),
            Pair(BOUNDARY, "----$boundary"),
            Pair("content_type", type))

    return MqttMsg(header, header[BOUNDARY], this)
}

fun MqttMessage.toMqttMsg(): MqttMsg? {
    val data = toString().split("\n")
    val header = mutableMapOf<String, String>()
    var body = ""

    data.forEach {
        if (header.containsKey(BOUNDARY) && it.equals(header[BOUNDARY])) {
            return@forEach
        }
        val data = it.split("=")
        if (data.size == 2) {
            val key = data[0].trim()
            val str = data[1].trim()
            if (str.matches(Regex("\"([^\"]*)\""))) {
                val value = str.substring(1, str.length - 1)
                header.put(key, value)
            }
        }
    }
    if (header.containsKey(BOUNDARY)) {
        val data = toString().split(header[BOUNDARY] + "\n")
        if (data.size == 2) {
            body = data[1]
        }
    }
    return MqttMsg(header, header[BOUNDARY], body)
}


//length表示生成字符串的长度
fun getRandomString(length: Int): String {
    val base = "abcdefghijklmnopqrstuvwxyz0123456789"
    val random = Random()
    val sb = StringBuffer()
    for (i in 0..length - 1) {
        val number = random.nextInt(base.length)
        sb.append(base[number])
    }
    return sb.toString()
}
