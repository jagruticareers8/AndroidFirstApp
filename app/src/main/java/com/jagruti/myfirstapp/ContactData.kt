package com.jagruti.myfirstapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class ContactData (var name: String,
    var lastMessage: String,
    var  lastMsgTime: String,
    var phoneNumber: String,
    var imageId: Int
    ): Parcelable
