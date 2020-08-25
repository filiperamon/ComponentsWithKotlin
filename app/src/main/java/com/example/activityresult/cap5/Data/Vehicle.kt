package com.example.activityresult.cap5.Data

data class Vehicle (
    var model:String,
    var year:Int,
    var manufacturer:Int, //0=VW. 1=GM. 2=Ford
    var gasoline:Boolean,
    var ethanol:Boolean
)