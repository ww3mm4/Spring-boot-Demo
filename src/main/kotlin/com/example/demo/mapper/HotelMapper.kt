package com.example.demo.mapper

import com.example.demo.model.Hotel
import org.apache.ibatis.annotations.Mapper

/**
 * Created by zhangyao on 17/7/18.
 */
@Mapper
interface HotelMapper {
    fun addHotel(hotel: Hotel): Int

    fun updateHotel(hotel: Hotel): Int

    fun getHotel(id: Int): Hotel

    fun deleteHotel(id: Int):Int
}