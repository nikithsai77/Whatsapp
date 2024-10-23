package com.android.whatsapp.ui.theme.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.whatsapp.ui.theme.components.AppBarComponents
import com.android.whatsapp.ui.theme.components.ChatScreen
import com.android.whatsapp.ui.theme.components.StatusScreen
import com.android.whatsapp.ui.theme.components.TabBarComponent
import com.android.whatsapp.ui.data.InitialPage
import com.android.whatsapp.ui.data.tabs
import com.android.whatsapp.ui.theme.WhatsappTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen() {
    val pageState  = rememberPagerState(initialPage = InitialPage)
    val scope = rememberCoroutineScope()

    Column {
        AppBarComponents()
        TabBarComponent(onTabSelected = { newPage ->
            scope.launch {
                pageState.animateScrollToPage(newPage)
            }
        }, initialPage = pageState.currentPage, pagerState = pageState)

        HorizontalPager(modifier = Modifier.fillMaxSize(),
            pageCount = tabs.size, state = pageState) {
            when(it) {
                 0 -> ChatScreen()
                 1 -> StatusScreen()
                 else -> StatusScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    WhatsappTheme {
        HomeScreen()
    }
}
