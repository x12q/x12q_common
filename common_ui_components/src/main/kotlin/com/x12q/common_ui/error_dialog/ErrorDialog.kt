package com.x12q.common_ui.error_dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.button.Button2
import com.x12q.common_ui.preview_views.previewApp

@Composable
fun OKErrorDialog(
    title: String,
    errorMsg: String,
    onOkClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BaseErrorDialog {
        OKErrorView(
            title = title,
            errorMsg = errorMsg,
            onOkClick = onOkClick,
            modifier = modifier
        )
    }
}
/**
 * A view showing an error message with exactly one "OK" button
 */
@Composable
fun OKErrorView(
    title: String,
    errorMsg: String,
    onOkClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BaseErrorDialogLayout(
        titleView = {
            Text(title)
        },
        contentView = {
            Text(errorMsg)
        },
        buttonView = {
            Button2(text = "OK", onClick = onOkClick)
        },
        modifier = modifier,
    )
}

private fun main() {
    previewApp {
        val z = remember { mutableStateOf(false) }
        Row {
            Box(Modifier.size(10.dp).background(Color.Red))
            Button2("Show dialog"){
                z.value = true
            }
        }

        if(z.value){
            OKErrorDialog("title","msg",{
                z.value = !z.value
            })
        }
    }
}
