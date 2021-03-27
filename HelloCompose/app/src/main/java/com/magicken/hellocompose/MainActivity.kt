package com.magicken.hellocompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApp {
        MyScreenContent()
      }
    }
  }

  @Composable
  fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
      Surface(color = Color.Yellow) {
        content()
      }
    }
  }

  @Composable
  fun Greeting(name: String) {
    Text(text = "Hello $name", modifier = Modifier.padding(24.dp))
  }

  @Composable
  fun MyScreenContent(names: List<String> = List(100) { "Hello Android $it" }) {
    val countState = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxWidth()) {
      NameList(names = names, Modifier.weight(1f))
      Divider(color = Color.Transparent, thickness = 33.dp)
      Counter(
        count = countState.value,
        updateCount = { newCount ->
          countState.value = newCount
        }
      )
    }
  }

  @Composable
  fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
      onClick = { updateCount(count + 1) },
      colors = ButtonDefaults.buttonColors(
        backgroundColor = if (count > 5) Color.Green else Color.White
      )
    ) {
      Text("I've been clicked $count times")
    }
  }

  @Composable
  fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
      items(items = names) { name ->
        Greeting(name)
        Divider(color = Color.Black)
      }
    }
  }

  @Composable
  fun NewsStory() {
    MaterialTheme {
      val typography = MaterialTheme.typography
      Column(
        modifier = Modifier.padding(16.dp)
      ) {
        Image(
          painter = painterResource(id = R.drawable.header),
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

  @Preview
  @Composable
  fun PreviewGreeting() {
    MyApp {

    }
  }
}