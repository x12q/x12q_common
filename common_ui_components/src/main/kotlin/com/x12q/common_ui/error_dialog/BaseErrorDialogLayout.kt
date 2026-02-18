package com.x12q.common_ui.error_dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.box.border_box.BorderStyle
import com.x12q.common_ui.box.border_box.border2

/**
 * A base composable template for all error dialog
 * TODO improve this if needed
 */
@Composable
fun BaseErrorDialogLayout(
    modifier: Modifier = Modifier,
    titleView: @Composable () -> Unit,
    contentView: @Composable () -> Unit,
    buttonView: @Composable () -> Unit,
) {
    Box(modifier.border2(BorderStyle.ALL)) {
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            titleView()
            contentView()
            buttonView()
        }
    }
}
