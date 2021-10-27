package com.mhl.meditation.recadapters

data class feel(var success : Boolean, val data : ArrayList<feelData>)
data class feelData(var id : Int, var image : String, var title : String)
