/*
 * 版权所有(C) 2021 zhanggenhua
 * 创建: zhanggenhua 2021-04-06
 */

package com.magicken.hellocompose.ui.page

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

/**
 * @author zhanggenhua
 * @date 2021-04-06
 */

@Composable
fun NewsStory(@DrawableRes header: Int) {
  MaterialTheme {
    val typography = MaterialTheme.typography
    Column(
      modifier = Modifier.padding(16.dp)
    ) {
      Image(
        painter = painterResource(id = header),
        contentDescription = "header",
        modifier = Modifier
          .height(180.dp)
          .fillMaxWidth()
          .clip(RoundedCornerShape(4.dp)),
        contentScale = ContentScale.Crop
      )
      Spacer(Modifier.requiredHeight(16.dp))
      Text(
        "A day wandering through the sandhills " +
          "in Shark Fin Cove, and a few of the " +
          "sights I saw",
        style = typography.h6,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
      )
      Text(
        "Davenport, California",
        style = typography.body2
      )
      Text(
        "December 2018",
        style = typography.body1
      )
    }
  }
}