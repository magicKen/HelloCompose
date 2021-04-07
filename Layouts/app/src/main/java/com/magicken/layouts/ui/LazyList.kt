/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-07
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

/**
 * @author zhanggenhua
 * @date 2021-04-07
 */

@Composable
fun LazyList() {
  val scrollState = rememberLazyListState()
  LazyColumn(state = scrollState) {
    items(100) {
      Text(text = "Item #$it")
    }
  }
}