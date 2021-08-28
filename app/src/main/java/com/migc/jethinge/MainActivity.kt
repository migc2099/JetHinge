package com.migc.jethinge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.migc.jethinge.ui.components.EditAppBar
import com.migc.jethinge.ui.components.PhotosGrid
import com.migc.jethinge.ui.theme.JetHingeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetHingeTheme {
                Scaffold(
                    topBar = { EditAppBar() },
                    content = { PhotosGrid() }
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetHingeTheme {
        EditAppBar()
    }
}