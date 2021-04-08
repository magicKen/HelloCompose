/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-08
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.magicken.layouts.ui.theme.LayoutsTheme

/**
 * @author zhanggenhua
 * @date 2021-04-08
 */

@Composable
fun TwoTexts(modifier: Modifier = Modifier, text1: String, text2: String) {
  Row(modifier = modifier.height(IntrinsicSize.Min)) {
    Text(
      text = text1,
      modifier = Modifier
        .weight(1f)
        .padding(start = 4.dp)
        .wrapContentWidth(Alignment.CenterHorizontally)
    )

    Divider(color = Color.Black, modifier = Modifier
      .fillMaxHeight()
      .width(1.dp))

    Text(
      text = text2,
      modifier = Modifier
        .weight(1f)
        .padding(end = 4.dp)
        .wrapContentWidth(Alignment.End)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun TwoTextsPreview() {
  LayoutsTheme {
    TwoTexts(text1 = "Hi", text2 = "there")
  }
}