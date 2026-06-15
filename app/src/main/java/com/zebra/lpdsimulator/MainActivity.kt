package com.zebra.lpdsimulator

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel

class MainActivity : ComponentActivity() {

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RootView(this)
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.displayMessage("onPause called")
    }

    override fun onResume() {
        super.onResume()
        viewModel.displayMessage("onResume called")
    }

    @Composable
    fun RootView(context: Context) {
        Column(
            modifier = Modifier
                .padding(
                    vertical = 50.dp,
                    horizontal = 50.dp
                )
        ) {
            Text(viewModel.message.value)
            RoundButton("Trigger LPD") {
                viewModel.triggerLPDAlert(context)
            }
        }
    }
}

@Composable
fun RoundButton(title: String,
                color: Color = Color.Blue,
                modifier: Modifier? = null,
                onClick: () -> Unit) {
    if (modifier != null) {
        Button(
            modifier = modifier
            , onClick = {
                onClick()
            }
            , colors = ButtonColors(
                containerColor = color,
                contentColor = Color(0xFFFFFFFF),
                disabledContentColor = Color.White,
                disabledContainerColor = Color.LightGray
            )
        ) {
            Text(text = title)
        }
    } else {
        Button(
            modifier = Modifier
                .fillMaxWidth()
            , onClick = {
                onClick()
            }
            , colors = ButtonColors(
                containerColor = color,
                contentColor = Color(0xFFFFFFFF),
                disabledContentColor = Color.White,
                disabledContainerColor = Color.LightGray
            )
        ) {
            Text(text = title)
        }
    }
}

@Composable
fun TextInRectangleBox(
    text: String,
    modifier: Modifier = Modifier
) {
    // Define the shape of your rectangle box
    // Use RoundedCornerShape(0.dp) for a sharp, 90-degree rectangle
    val rectangleShape = RoundedCornerShape(8.dp)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            // 1. Clip content to the shape
            .clip(rectangleShape)
            // 2. Set the background color inside the box
            .background(Color(0xFFF5F5F5))
            // 3. Draw a border outline around the box
            .border(
                width = 2.dp,
                color = Color(0xFF6200EE), // Primary purple border
                shape = rectangleShape
            )
            // 4. Add inner padding so text doesn't touch the borders
            .padding(horizontal = 24.dp, vertical = 16.dp),
        contentAlignment = Alignment.Center // Center the text inside the box
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF333333),
                textAlign = TextAlign.Center
            )
        )
    }
}
