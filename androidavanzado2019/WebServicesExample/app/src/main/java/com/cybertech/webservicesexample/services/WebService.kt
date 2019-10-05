package com.cybertech.webservicesexample.services

import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL


//
// Created by  on 2019-10-04.
//
class WebService {

    fun getService(url:String):String{
        var urlConnection:HttpURLConnection?=null
        var result:String=""

        try{
            val url= URL(url)

            urlConnection = url.openConnection() as HttpURLConnection
            urlConnection.requestMethod="GET"
            urlConnection.connect()

            val inputStream=urlConnection.inputStream
            return inputStream.bufferedReader().readText()
        }catch (e:IOException){
            return result
        }finally {
            if(urlConnection!=null)
                urlConnection.disconnect()
        }
    }
}