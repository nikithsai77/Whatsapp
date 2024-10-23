package com.android.whatsapp.ui.data

import com.android.whatsapp.R

val chatList = listOf(
    ChatListDataObject(chatId = 1, userName = "Imhotep", message = Message(content = "Good Morning", timeStamp = "27/02/2023", type = MessageType.TEXT, deliveryStatus = MessageDeliveryStatus.DELIVERED, unreadCount = 1)),
    ChatListDataObject(chatId = 2, userName = "Imhotep", message = Message(content = "Good Morning", timeStamp = "27/02/2023", type = MessageType.TEXT, deliveryStatus = MessageDeliveryStatus.DELIVERED)),
    ChatListDataObject(chatId = 3, userName = "Imhotep", message = Message(content = "Good Morning", timeStamp = "27/02/2023", type = MessageType.TEXT, deliveryStatus = MessageDeliveryStatus.DELIVERED)),
    ChatListDataObject(chatId = 4, userName = "Imhotep", message = Message(content = "Good Morning", timeStamp = "27/02/2023", type = MessageType.TEXT, deliveryStatus = MessageDeliveryStatus.DELIVERED, unreadCount = 2)),
    ChatListDataObject(chatId = 5, userName = "Imhotep", message = Message(content = "Good Morning", timeStamp = "27/02/2023", type = MessageType.TEXT, deliveryStatus = MessageDeliveryStatus.DELIVERED, unreadCount = 3)),
    ChatListDataObject(chatId = 6, userName = "Imhotep", message = Message(content = "Good Morning", timeStamp = "27/02/2023", type = MessageType.TEXT, deliveryStatus = MessageDeliveryStatus.DELIVERED)),
    ChatListDataObject(chatId = 7, userName = "Imhotep", message = Message(content = "Good Morning", timeStamp = "27/02/2023", type = MessageType.TEXT, deliveryStatus = MessageDeliveryStatus.DELIVERED)),
)

data class ChatListDataObject(
    val chatId: Int,
    val message: Message,
    val userName: String,
    val userImage: Int = R.drawable.ic_profile_pic
)

data class Message(
    val content: String,
    val type : MessageType,
    val timeStamp: String,
    var unreadCount: Int = 0,
    val deliveryStatus : MessageDeliveryStatus
)

enum class MessageDeliveryStatus {
    DELIVERED,
    READ,
    PENDING,
    ERROR
}

enum class MessageType {
    TEXT,
    AUDIO,
    VIDEO,
    IMAGE,
    LOC,
    FILE
}