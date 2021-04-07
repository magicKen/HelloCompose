/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-07
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * @author zhanggenhua
 * @date 2021-04-07
 */

@Composable
fun MyOwnColumn(
  modifier: Modifier = Modifier,
  content: @Composable () -> Unit
) {
  Layout(
    modifier = modifier,
    content = content
  ) { measurables, constraints ->
    // measure and position children given constraints logic here
    val placeables = measurables.map { measurable ->
      measurable.measure(constraints)
    }

    var yPosition = 0

    layout(constraints.maxWidth, constraints.maxHeight) {
      placeables.forEach{ placeable ->
        placeable.placeRelative(x = 0, y = yPosition)
        yPosition += placeable.height
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun MyOwnColumnPreview() {
  MyOwnColumn(modifier = Modifier.padding(8.dp)) {
    Text("MyOwnColumn")
    Text("places items")
    Text("vertically")
    Text("We've done it by hand")
  }
}