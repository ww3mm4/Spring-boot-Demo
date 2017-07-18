package com.example.demo.controller

import com.example.demo.model.ApiResponse
import org.springframework.beans.factory.annotation.Autowired
import javax.servlet.http.HttpServletRequest
import com.example.demo.utils.RespCode
import org.slf4j.LoggerFactory
import java.util.logging.Logger

/**
 * Created by zhangyao on 17/7/18.
 */
open class BaseController {

    @Autowired
    private lateinit var request: HttpServletRequest

    // 没有error 信息时的默认提示语
    protected val FAIL_FALLBACK_MSG = "ERROR: PLEASE TRY LATER"

    // 是否打印错误信息
    protected val PRINT_ERROR_TRACE = true

    fun successOutput(content: Any, msg: String = "ok"): ApiResponse {

        val apiResponse = ApiResponse(
                data = content,
                request_id = getRequestId(),
                msg = msg)
        return apiResponse
    }

    fun failOutput(code:Int,msg: String? = null,t:Throwable? = null):ApiResponse{
        val apiResponse = ApiResponse(
                data = "",
                code = if (code <0 ) RespCode.COMMON_UNKNOWN_ERR else code,
                request_id = getRequestId(),
                msg = msg?:if (t != null) t.message.toString() else FAIL_FALLBACK_MSG,
                trace = if (PRINT_ERROR_TRACE&&t!=null) t.stackTrace else "")

        return apiResponse
    }

    fun getRequestId(): String {
        var requestId = (request.getAttribute("request_id")?:"") as String
        return requestId
    }

}