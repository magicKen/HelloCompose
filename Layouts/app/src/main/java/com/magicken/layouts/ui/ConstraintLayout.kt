/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-08
 */

package com.magicken.layouts.ui

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.magicken.layouts.ui.theme.LayoutsTheme

/**
 * @author zhanggenhua
 * @date 2021-04-08
 */

@Composable
fun ConstraintLayoutContent() {
  ConstraintLayout {
    val (button1, button2, text) = createRefs()

    Button(
      onClick = {

      }, modifier = Modifier.constrainAs(button1) {
        top.linkTo(parent.top, margin = 16.dp)
      }
    ) {
      Text(text = "Button")
    }

    Text(text = "Text", Modifier.constrainAs(text){
      top.linkTo(button1.bottom, margin = 16.dp)
      centerAround(button1.end)
    })

    val barrier = createEndBarrier(button1, text)
    Button(
      onClick = {

      },
      modifier = Modifier.constrainAs(button2) {
        top.linkTo(parent.top, margin = 16.dp)
        start.linkTo(barrier)
      }
    ) {
      Text(text = "Button2")
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ConstraintLayoutContentPreview() {
  LayoutsTheme {
    ConstraintLayoutContent()
  }
}

@Composable
fun LargeConstraintLayout() {
  ConstraintLayout {
    val text = createRef()
    val guideline = createGuidelineFromStart(fraction = 0.5f)
    Text(
      text = "This is a very very very very very very very long text",
      modifier = Modifier.constrainAs(text) {
        linkTo(start = guideline, end = parent.end)
        width = Dimension.preferredWrapContent
      }
    )
  }
}

@Preview(showBackground = true)
@Composable
fun LargeConstraintLayoutPreview() {
  LayoutsTheme {
    LargeConstraintLayout()
  }
}