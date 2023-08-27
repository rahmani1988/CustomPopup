package com.reza.popup

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetPopupLayout(onDismiss: () -> Unit) {
    val sheetState = rememberModalBottomSheetState()
    
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onDismiss() }) {
        Text(text = "REZA")
    }
}