package com.alexstroulger.tapandroid

import android.icu.text.DateFormat.YEAR_ABBR_MONTH
import android.icu.text.DateFormat.getPatternInstance
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alexstroulger.tapandroid.ui.theme.TapAndroidTheme
import com.alexstroulger.tapandroid.ui.theme.Typography
import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TapAndroidTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val steps = listOf(StepSequence(sequence = "shuffle ball change", multiplier = 3))
                    val dances = listOf(Dance("Dance 1", id = UUID.randomUUID().toString(), steps = steps, createdDate = LocalDate.now()),
                        Dance("Dance 2", id = UUID.randomUUID().toString(), steps = steps, createdDate = LocalDate.now()),
                        Dance("Dance 3", id = UUID.randomUUID().toString(), steps = steps, createdDate = LocalDate.now()))
                    DanceList(dances = dances)
                }
            }
        }
    }
}

@Composable
fun DanceList(dances: List<Dance>) {
    val formatter = DateTimeFormatter.ofPattern("MMMM d, YYYY")
    LazyColumn {
        items(items = dances, itemContent = { dance ->
            Spacer(Modifier.height(10.0.dp))
            Text(dance.name, style = Typography.h5)
            Spacer(Modifier.height(10.0.dp))
            Text(dance.createdDate.format(formatter), color = Color.Gray, style = Typography.caption)
            Spacer(Modifier.height(10.0.dp))
            Divider(color = Color.Gray)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TapAndroidTheme {
        val steps = listOf(StepSequence(sequence = "shuffle ball change", multiplier = 3))
        val dances = listOf(Dance("Dance 1", id = UUID.randomUUID().toString(), steps = steps, createdDate = LocalDate.now()),
            Dance("Dance 2", id = UUID.randomUUID().toString(), steps = steps, createdDate = LocalDate.now()),
            Dance("Dance 3", id = UUID.randomUUID().toString(), steps = steps, createdDate = LocalDate.now()))
        DanceList(dances = dances)
    }
}