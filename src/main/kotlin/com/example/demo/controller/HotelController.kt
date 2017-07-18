package com.example.demo.controller

import com.example.demo.mapper.HotelMapper
import com.example.demo.model.ApiResponse
import com.example.demo.model.Hotel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Created by zhangyao on 17/7/18.
 */
@RestController
@RequestMapping(value = "/hotel")
class HotelController : BaseController() {
    @Autowired
    private lateinit var mapper: HotelMapper

    @RequestMapping(value = "/getHotel")
    fun getHotel(id: Int):ApiResponse{
        val hotel = mapper.getHotel(id)
        if (hotel==null){
            return failOutput(code = -1)
        }else{
            return successOutput(hotel)
        }
    }


    @RequestMapping(value = "/addHotel")
    fun addHotel(city: Int, name: String, address: String, zip: String): ApiResponse {
        val hotel = Hotel(city = city, name = name, address = address, zip = zip)
        mapper.addHotel(hotel)
        return successOutput(content = hotel)
    }

    @RequestMapping(value = "/updateHotel")
    fun updateHotel(id :Int =0,city: Int? = null, name: String? = null,
                    address: String? = null, zip: String? = null): ApiResponse{
        val hotel = Hotel(id = id,city = city, name = name, address = address, zip = zip)
        val n = mapper.updateHotel(hotel)
        if (n>0) {
            return getHotel(id)
        }else{
            return failOutput(code = -1)
        }
    }
    @RequestMapping(value = "/deleteHotel")
    fun deleteHotel(id: Int):ApiResponse{
        val n = mapper.deleteHotel(id)
        if (n>0) {
            return successOutput("id = ${id}")
        }else{
            return failOutput(code = -1)
        }
    }
}