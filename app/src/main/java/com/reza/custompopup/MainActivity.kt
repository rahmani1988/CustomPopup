package com.reza.custompopup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reza.custompopup.ui.theme.CustomPopupTheme
import com.reza.popup.BottomSheetPopupLayout
import com.reza.popup.CustomItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomPopupTheme {
                var showSheet by remember { mutableStateOf(false) }

                if (showSheet) {
                    BottomSheetPopupLayout(
                        onDismiss = {
                            showSheet = false
                        }, topBar = {
//                            Column {
//                                Text(
//                                    text = "Theme",
//                                    modifier = Modifier
//                                        .height(75.dp)
//                                        .padding(start = 29.dp, top = 26.dp),
//                                    fontSize = 23.sp
//                                )
//                                Divider(color = Color.Black, thickness = 1.dp)
//                            }
                        }, content = {
                            Column(modifier = Modifier.padding(it)) {
                                Text(
                                    text = "Select theme",
                                    modifier = Modifier
                                        .padding(
                                            start = 29.dp, top = 20.dp, bottom = 10.dp
                                        )
                                        .height(40.dp),
                                    fontSize = 20.sp
                                )
                                CustomItem("Light")
                                CustomItem("Dark")
                                CustomItem("System default")
                            }
                        }
                    )
                }
                // A surface container using the 'background' color from the theme

                Button(onClick = { showSheet = true }) {
                    Text(text = "Click")
                }

            }
        }
    }
}