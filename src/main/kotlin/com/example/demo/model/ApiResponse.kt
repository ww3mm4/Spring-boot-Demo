package com.example.demo.model

/**
 * Created by zhangyao on 17/7/18.
 */
data class ApiResponse(val code: Int = 0,
                       val msg: String ="",
                       val request_id: String,
                       val data: Any ="",
                       val trace: Any="")
