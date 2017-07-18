package com.example.demo.model

import java.io.Serializable

/**
 * Created by zhangyao on 17/7/18.
 */
data class Hotel(var id: Int?=0,
                 var city: Int?,
                 var name: String?,
                 var address: String?,
                 var zip: String?) : Serializable