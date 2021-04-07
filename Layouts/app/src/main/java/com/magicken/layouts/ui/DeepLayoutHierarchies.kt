/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-07
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

/**
 * @author zhanggenhua
 * @date 2021-04-07
 */

@Composable
fun DeepLayout(){
  val depth = remember { mutableStateOf(0) }
  DeepColumn(index = depth)
}

@Composable
fun DeepColumn(index: MutableState<Int>) {
  Column {
    while (true) {
      index.value = index.value++
      Text(text = "Depth #${index.value}")
      println("Depth in #${index.value}")
      DeepColumn(index)
    }
  }
}