package com.example.demo.akka.message

/**
 * Created by zhangyao on 17/7/26.
 */
class User{
    var wx_openid: String=""
    var fingerprint_id: String=""
    var user_name: Int=0
    //todo type "wx lilanqi"
}

class Share{
    var from:User?=null
    var to:User?=null
    var share_no:String=""
}