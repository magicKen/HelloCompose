/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-07
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * @author zhanggenhua
 * @date 2021-04-07
 */

@Composable
fun SimpleList() {
  val scrollState = rememberScrollState()
  Column(Modifier.verticalScroll(scrollState)) {
    repeat(100) {
      Text(text = "Item #$it")
    }
  }
}