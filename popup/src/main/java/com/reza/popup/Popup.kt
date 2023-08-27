package com.reza.popup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.reza.popuplibrary.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetPopupLayout(
    onDismiss: () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    val scaffoldState = rememberBottomSheetScaffoldState()
    val scope = rememberCoroutineScope()


    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            Text(text = "Content")

        },
        sheetPeekHeight = 0.dp
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Button(onClick = {
                scope.launch {
                    scaffoldState.bottomSheetState.expand()
                }
            }) {
                Text(text = "Open sheet")
            }
        }
    }


//    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
//
//    ModalBottomSheet(
//        modifier = Modifier.fillMaxHeight(),
//        sheetState = sheetState,
//        onDismissRequest = { onDismiss() },
//        dragHandle = { BottomSheetDefaults.DragHandle() },
//    ) {
//        Text(text = "REZA")
//        Text(text = "REZA")
//        Text(text = "REZA")
//        Text(text = "REZA")
//        Text(text = "REZA")
//        Text(text = "REZA")
////        Scaffold(
////            modifier = Modifier.wrapContentHeight(),
////            topBar = topBar,
////            bottomBar = bottomBar,
////            content = content,
////            snackbarHost = snackbarHost
////        )
//    }
}

@Composable
fun CustomItem(text: String) {
    Row(modifier = Modifier.height(40.dp), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = text, modifier = Modifier
                .height(40.dp)
                .padding(start = 20.dp, top = 11.dp),
            fontSize = 18.sp
        )
    }
}
