package com.reza.custompopup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.reza.custompopup.ui.theme.CustomPopupTheme
import com.reza.popup.BottomSheetPopupLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomPopupTheme {
                var showSheet by remember { mutableStateOf(false) }

                if (showSheet) {
                    BottomSheetPopupLayout {
                        showSheet = false
                    }
                }
                // A surface container using the 'background' color from the theme

                Button(onClick = { showSheet = true }) {
                    Text(text = "Click")
                }

            }
        }
    }
}