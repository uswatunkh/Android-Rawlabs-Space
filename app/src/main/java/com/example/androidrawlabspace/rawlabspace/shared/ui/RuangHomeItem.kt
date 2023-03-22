package com.example.androidrawlabspace.rawlabspace.shared.ui

import android.os.Parcel
import android.os.Parcelable

class RuangHomeItem(val image:Int, val ruang:String, val harga:String, val jalan :String,val day :String) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(ruang)
        parcel.writeString(harga)
        parcel.writeString(jalan)
        parcel.writeString(day)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RuangHomeItem> {
        override fun createFromParcel(parcel: Parcel): RuangHomeItem {
            return RuangHomeItem(parcel)
        }

        override fun newArray(size: Int): Array<RuangHomeItem?> {
            return arrayOfNulls(size)
        }
    }
}