package com.android.whatsapp.ui.data

data class TabData(val title: String, val unReadCount: Int?)

val tabs = listOf(
    TabData(title = "Chats", unReadCount = 4),
    TabData(title = "Status", unReadCount = null),
    TabData(title = "Calls", unReadCount = null)
)

const val InitialPage = 0