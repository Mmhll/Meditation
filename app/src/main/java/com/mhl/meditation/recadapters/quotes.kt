package com.mhl.meditation.recadapters

data class quotes(val success : Boolean, val data : ArrayList<quotesData>)
data class quotesData(var id: Int, val title : String, val image : String, val description:String)
