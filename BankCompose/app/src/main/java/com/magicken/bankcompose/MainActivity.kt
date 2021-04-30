package com.magicken.bankcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.pager.*
import com.magicken.bankcompose.ui.theme.BankComposeTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  @ExperimentalPagerApi
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BankComposeTheme {

        val pages = remember {
          listOf("Home", "Note", "Mine")
        }
        Column {
          val pagerState = rememberPagerState(pageCount = 3)
          HorizontalPager(
            state = pagerState,
            offscreenLimit = 2,
            modifier = Modifier
              .weight(1f)
              .fillMaxWidth()
          ) { page ->
            Box(Modifier.fillMaxSize()) {
              Text(
                text = "Page: ${pages[page]}", modifier = Modifier
                  .align(Alignment.Center)
              )
            }
          }
          Divider()
          HomeTabRow(pagerState = pagerState, pages = pages)
        }
      }
    }
  }
}

@ExperimentalPagerApi
@Composable
fun HomeTabRow(pagerState: PagerState, pages: List<String>) {
  val coroutineScope = rememberCoroutineScope()
  val icons = remember {
    listOf(
      arrayOf(
        R.drawable.tab_home,
        R.drawable.tab_home_selected,
      ),
      arrayOf(
        R.drawable.tab_notification,
        R.drawable.tab_notification_selected,
      ),
      arrayOf(
        R.drawable.tab_mine,
        R.drawable.tab_mine_selected,
      ),
    )
  }
  TabRow(
    selectedTabIndex = pagerState.currentPage,
    indicator = { },
    backgroundColor = Color.White
  ) {
    pages.forEachIndexed { index, title ->
      val selected = pagerState.currentPage == index
      val iconArray = icons[index]
      val iconId = if (selected) iconArray[1] else iconArray[0]
      Tab(
        selected = selected,
        onClick = {
          coroutineScope.launch {
            pagerState.scrollToPage(index)
          }
        },
      ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Image(painter = painterResource(id = iconId), contentDescription = title)
          Text(title)
        }
      }
    }
  }
}

@ExperimentalPagerApi
@Preview
@Composable
fun HomeTabRowPreview() {
  val pagerState = rememberPagerState(pageCount = 3)
  HomeTabRow(pagerState = pagerState, pages = remember {
    listOf("Home", "Note", "Mine")
  })
}