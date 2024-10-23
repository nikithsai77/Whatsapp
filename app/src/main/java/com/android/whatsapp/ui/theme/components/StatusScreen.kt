package com.android.whatsapp.ui.theme.components

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
import com.android.whatsapp.ui.data.StatusList
import com.android.whatsapp.ui.data.UserData
import com.android.whatsapp.ui.data.statusMapList

@Composable
fun StatusScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp), horizontalAlignment = Alignment.Start) {
        item { Spacer(modifier = Modifier.height(10.dp)) }
        statusMapList.forEach { (key, valueList) ->
            item {
                TextComponent(text = key, fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.SemiBold)
            }
            items(valueList) {
                StatusList(it)
            }
        }
    }
}

@Composable
fun StatusList(statusList: StatusList) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Icon(modifier = Modifier.size(60.dp), painter = painterResource(statusList.userData.userImage), contentDescription = stringResource(R.string.profile_pic))

        Column(modifier = Modifier.wrapContentHeight().padding(start = 16.dp)) {
            TextComponent(text = statusList.userData.name, fontSize = 18.sp, color = Color.Black, fontWeight = FontWeight.SemiBold)

            Spacer(modifier = Modifier.height(5.dp))

            TextComponent(text = statusList.userData.timeStamp, fontSize = 12.sp, color = Color.Gray, fontWeight = FontWeight.Normal)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StatusScreenPreview() {
    StatusList(StatusList(title = "", UserData(name = "Title", timeStamp = "9:10 AM")))
}
