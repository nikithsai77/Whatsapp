package com.android.whatsapp.ui.data

import com.android.whatsapp.R

private val statusList = listOf(
    StatusList(title = "Recent", userData = UserData(name = "Imhotep", timeStamp = "9:10 PM")),
    StatusList(title = "Recent", userData = UserData(name = "Anasunamun", timeStamp = "9:05 PM")),
    StatusList(title = "Viewed updates", userData = UserData(name = "The Mummy", timeStamp = "10:00 AM")),
    StatusList(title = "Viewed updates", userData = UserData(name = "Rick", timeStamp = "9:55 AM")),
    StatusList(title = "Viewed updates", userData = UserData(name = "Eve", timeStamp = "9:10 PM")),
    StatusList(title = "Viewed updates", userData = UserData(name = "Paroms", timeStamp = "9:07 PM")),
    StatusList(title = "Viewed updates", userData = UserData(name = "Johnadhe", timeStamp = "9:10 PM")),
    StatusList(title = "Viewed updates", userData = UserData(name = "Presist", timeStamp = "9:12 PM"))
)

val statusMapList = statusList.groupBy {
    it.title
}

data class StatusList(val title: String, val userData: UserData)

data class UserData(val userImage: Int = R.drawable.ic_profile_pic, val name: String, val timeStamp: String)
