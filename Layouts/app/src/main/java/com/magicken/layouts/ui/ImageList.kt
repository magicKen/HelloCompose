/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-07
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

/**
 * @author zhanggenhua
 * @date 2021-04-07
 */

@Composable
fun ImageList() {
  val listSize = 100
  val scrollState = rememberLazyListState()
  val coroutineScope = rememberCoroutineScope()
  Column {
    Row {
      Button(onClick = {
        coroutineScope.launch {
          scrollState.animateScrollToItem(0)
        }
      }) {
        Text(text = "Scroll to the top")
      }
      Button(onClick = {
        coroutineScope.launch {
          scrollState.animateScrollToItem(listSize - 1)
        }
      }) {
        Text(text = "Scroll to the end")
      }
    }
    LazyColumn(state = scrollState) {
      items(listSize) {
        ImageListItem(it)
      }
    }
  }
}

@Composable
fun ImageListItem(index: Int) {
  Row(verticalAlignment = Alignment.CenterVertically) {
    CoilImage(
      data = "https://developer.android.com/images/brand/Android_Robot.png",
      contentDescription = "Android Logo",
      modifier = Modifier.size(50.dp)
    )
    Spacer(Modifier.width(10.dp))
    Text("Item #$index", style = MaterialTheme.typography.subtitle1)
  }
}