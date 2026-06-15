package com.zebra.lpdsimulator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/***
 * adb shell am start -n com.zebra.lpdsimulator/.FullscreenActivity
 * */
class FullscreenActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RootView()
        }
    }

    @Composable
    fun RootView() {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 150.dp,
                    horizontal = 50.dp
                )
        ) {
            TextInRectangleBox("This is overlay\nThis is overlay\nThis is overlay\nThis is overlay\nThis is overlay\n")
        }
    }
}