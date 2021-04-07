/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-07
 */

package com.magicken.layouts.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.magicken.layouts.ui.theme.LayoutsTheme
import kotlin.math.max

/**
 * @author zhanggenhua
 * @date 2021-04-07
 */
@Composable
fun StaggeredGrid(
  modifier: Modifier = Modifier,
  rows: Int = 3,
  content: @Composable () -> Unit
) {
  Layout(
    modifier = modifier,
    content = content
  ) { measurables, constraints ->
    val rowWidths = IntArray(rows){ 0 }
    val rowMaxHeights = IntArray(rows) { 0 }
    val placeables = measurables.mapIndexed{ index, measurable ->
      val placeable = measurable.measure(constraints)
      val row = index % rows
      rowWidths[row] = rowWidths[row] + placeable.width
      rowMaxHeights[row] = max(rowMaxHeights[row], placeable.height)

      placeable
    }

    val width = rowWidths.maxOrNull()
      ?.coerceIn(constraints.minWidth.rangeTo(constraints.maxWidth)) ?: constraints.minWidth

    val height = rowMaxHeights.sumBy { it }
      .coerceIn(constraints.minHeight.rangeTo(constraints.maxHeight))

    val rowY = IntArray(rows) { 0 }
    for (i in 1 until rows) {
      rowY[i] = rowY[i-1] + rowMaxHeights[i-1]
    }

    layout(width, height) {
      val rowX = IntArray(rows) { 0 }
      placeables.forEachIndexed { index, placeable ->
        val row = index % rows
        placeable.placeRelative(
          x = rowX[row],
          y = rowY[row]
        )
        rowX[row] += placeable.width
      }
    }
  }
}

@Composable
fun Chip(modifier: Modifier = Modifier, text: String) {
  Card(
    modifier = modifier,
    border = BorderStroke(color = Color.Black, width = Dp.Hairline),
    shape = RoundedCornerShape(8.dp)
  ) {
    Row(
      modifier = Modifier.padding(start = 8.dp, top = 4.dp, end = 8.dp, bottom = 4.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(16.dp, 16.dp)
          .background(color = MaterialTheme.colors.secondary)
      )
      Spacer(Modifier.width(4.dp))
      Text(text = text)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun ChipPreview() {
  LayoutsTheme {
    Chip(text = "Hi there")
  }
}

val topics = listOf(
  "Arts & Crafts", "Beauty", "Books", "Business", "Comics", "Culinary",
  "Design", "Fashion", "Film", "History", "Maths", "Music", "People", "Philosophy",
  "Religion", "Social sciences", "Technology", "TV", "Writing"
)

@Preview(showBackground = true)
@Composable
fun StaggeredGridPreview() {
  LayoutsTheme {
    Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
      StaggeredGrid {
        for (topic in topics) {
          Chip(modifier = Modifier.padding(8.dp), text = topic)
        }
      }
    }
  }
}