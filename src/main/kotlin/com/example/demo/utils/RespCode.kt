package com.example.demo.utils

/**
 * Created by zhangyao on 17/7/18.
 */
object RespCode {
    // 通用
    val COMMON_OK = 0
    // 未知错误
    val COMMON_UNKNOWN_ERR = 10001
    // 传入参数不全
    val COMMON_PARAM_NOTSET = 10002
    // 服务器错误
    val COMMON_SERVER_ERROR = 10003
    // 没有权限
    val COMMON_NO_PERMISSION = 10004
    // 没有更多数据了
    val COMMON_NO_MORE_DATA = 10005
    // 此接口已废弃
    val COMMON_API_DEPRECATED = 10006
    // 正在建设中
    val COMMON_UNDER_CONSTRUCTION = 10007
    // 资源不存在
    val COMMON_NOT_FOUND = 10008
    // 添加失败
    val COMMON_ADD_FAILED = 10009
    // 删除失败
    val COMMON_DELETE_FAILED = 10010
    // 更新失败
    val COMMON_UPDATE_FAILED = 10011
}