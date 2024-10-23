package com.android.whatsapp.ui.theme.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.whatsapp.ui.data.TabData
import com.android.whatsapp.ui.data.tabs
import com.android.whatsapp.ui.theme.WhatsappTheme
import kotlinx.coroutines.flow.collectLatest

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabBarComponent(onTabSelected : (Int) -> Unit, initialPage: Int, pagerState: PagerState) {
    var selectedIndex by rememberSaveable {
        mutableStateOf(value = initialPage)
    }

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.currentPage }.collectLatest { page ->
            selectedIndex = page
        }
    }

    TabRow(selectedTabIndex = selectedIndex,
           modifier = Modifier.fillMaxWidth(),
           containerColor = MaterialTheme.colorScheme.primary,
           contentColor = MaterialTheme.colorScheme.tertiary,
           indicator = { tabList ->
               TabRowDefaults.Indicator(
                   modifier = Modifier.tabIndicatorOffset(tabList[selectedIndex]),
                   color = MaterialTheme.colorScheme.tertiary,
                   height = 4.dp
               )
           }
    ) {
        tabs.forEachIndexed { index, data ->
            Tab(
                selected = selectedIndex == index,
                onClick = {
                    onTabSelected(index)
                    selectedIndex = index
                },
                text = {
                   TabContent(tabData = data)
                }
            )
        }
    }
}

@Composable
fun TabContent(tabData: TabData) {
    if (tabData.unReadCount != null)
        TabWithUnreadCount(tabData = tabData)
    else
        TabTitle(title = tabData.title)
}

@Composable
fun TabWithUnreadCount(tabData: TabData) {
    Row {
        TabTitle(title = tabData.title)

        tabData.unReadCount?.also { unreadCount ->
            CircularCount(unreadCount = unreadCount.toString(), bgColor = Color.White, textColor = MaterialTheme.colorScheme.secondary)
        }
    }
}

@Composable
fun TabTitle(title: String) {
    Text(text = title, style = TextStyle(fontSize = 16.sp))
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TabBarComponentPreView() {
    WhatsappTheme {
        TabBarComponent(initialPage = 0, onTabSelected = {}, pagerState = rememberPagerState())
    }
}
