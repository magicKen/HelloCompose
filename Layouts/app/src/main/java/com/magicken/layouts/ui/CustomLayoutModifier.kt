/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-07
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.LastBaseline
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.magicken.layouts.ui.theme.LayoutsTheme

/**
 * @author zhanggenhua
 * @date 2021-04-07
 */

fun Modifier.firstBaseLineToTop(
  firstBaselineToTop: Dp
) = Modifier.layout { measurable, constraints ->
  val placeable = measurable.measure(constraints)

  check(placeable[FirstBaseline] != AlignmentLine.Unspecified)
  val firstBaseLine = placeable[FirstBaseline]

  val placeableY = firstBaselineToTop.roundToPx() - firstBaseLine
  val height = placeable.height + placeableY
  layout(placeable.width, height){
    placeable.placeRelative(0, placeableY)
  }
}

fun Modifier.lastBaseLineToTop(
  lastBaselineToTop: Dp
) = Modifier.layout { measurable, constraints ->
  val placeable = measurable.measure(constraints)

  check(placeable[LastBaseline] != AlignmentLine.Unspecified)
  val lastBaseLine = placeable[LastBaseline]

  val placeableY = lastBaselineToTop.roundToPx() - lastBaseLine
  val height = placeable.height + placeableY
  layout(placeable.width, height){
    placeable.placeRelative(0, placeableY)
  }
}

@Preview(showBackground = true)
@Composable
fun TextWithPaddingToBaselinePreview() {
  LayoutsTheme {
    Text("Hi there", Modifier.firstBaseLineToTop(32.dp))
  }
}

@Preview(showBackground = true)
@Composable
fun TextWithPaddingToLastBaselinePreview() {
  LayoutsTheme {
    Text("Hi there", Modifier.lastBaseLineToTop(32.dp))
  }
}

@Preview(showBackground = true)
@Composable
fun TextWithNormalPaddingPreview() {
  LayoutsTheme {
    Text("Hi there", Modifier.padding(32.dp))
  }
}

