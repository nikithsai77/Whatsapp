package com.android.whatsapp.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.whatsapp.R
import com.android.whatsapp.ui.data.ChatListDataObject
import com.android.whatsapp.ui.data.chatList
import com.android.whatsapp.ui.theme.HighLightGreen
import com.android.whatsapp.ui.theme.White

@Composable
fun ChatScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp), horizontalAlignment = Alignment.Start) {
        item { Spacer(modifier = Modifier.height(10.dp)) }
        items(chatList) {chatData ->
            ChatListItem(chatData)
        }
    }
}

@Composable
fun ChatListItem(data: ChatListDataObject) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Icon(modifier = Modifier.size(60.dp), painter = painterResource(data.userImage), contentDescription = stringResource(R.string.profile_pic))
        Column(modifier = Modifier.wrapContentHeight().padding(start = 16.dp), horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
            MessageHeader(data = data)
            MessageSubSection(data = data)
        }
    }
}

@Composable
fun MessageHeader(data: ChatListDataObject) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {
        TextComponent(text = data.userName, fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.SemiBold)

        TextComponent(text = data.message.timeStamp, fontSize = 12.sp, color = if (data.message.unreadCount > 0) HighLightGreen else Color.Gray, fontWeight = FontWeight.Normal)
    }
}

@Composable
fun MessageSubSection(data: ChatListDataObject) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically) {

        TextComponent(text = data.message.content, fontSize = 16.sp, color = if (data.message.unreadCount > 0) HighLightGreen else Color.Gray, fontWeight = FontWeight.Bold)

        if (data.message.unreadCount!=0) CircularCount(unreadCount = data.message.unreadCount.toString(), bgColor = HighLightGreen, textColor = White)
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ChatScreen()
}
