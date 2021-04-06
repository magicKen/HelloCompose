package com.magicken.hellocompose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.magicken.hellocompose.ui.theme.HelloComposeTheme

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
    HelloComposeTheme {
      Surface(color = Color.Yellow) {
        content()
      }
    }
  }

  @Composable
  fun Greeting(name: String) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)
    Text(
      text = "Hello $name",
      modifier = Modifier
        .padding(24.dp)
        .background(color = backgroundColor)
        .clickable { isSelected = !isSelected },
      style = MaterialTheme.typography.h1
    )
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

  @Preview
  @Composable
  fun PreviewGreeting() {
    MyApp {

    }
  }
}