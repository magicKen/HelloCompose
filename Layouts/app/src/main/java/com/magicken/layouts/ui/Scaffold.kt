/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-07
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.magicken.layouts.ui.theme.LayoutsTheme

/**
 * @author zhanggenhua
 * @date 2021-04-07
 */

@Composable
fun LayoutsCodelab() {
  Scaffold(
    topBar = {
      TopAppBar(
        title = {
          Text(
            text = "LayoutsCodelab",
          )
        },
        actions = {
          IconButton(onClick = { /* */ }) {
            Icon(Icons.Filled.Face, contentDescription = "Favorite")
          }
        }
      )
    }
  ) { innerPadding ->
    BodyContent(
      Modifier
        .padding(innerPadding)
        .padding(8.dp))
  }
}

@Composable
private fun BodyContent(modifier: Modifier = Modifier) {
  Column(modifier = modifier) {
    Text(text = "Hi there!")
    Text(text = "Thanks for going through the Layouts codelab")
  }
}

@Preview
@Composable
fun LayoutsCodelabPreview() {
  LayoutsTheme {
    LayoutsCodelab()
  }
}