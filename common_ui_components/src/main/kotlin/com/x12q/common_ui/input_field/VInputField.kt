package com.x12q.common_ui.input_field

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.text.LabelText
import com.x12q.common_ui.preview_views.PreviewColumnOnSurface
import com.x12q.common_ui.preview_views.previewApp

@Composable
fun VInputField(
    label: String,
    text: String,
    modifier: Modifier = Modifier,
    fieldModifier: Modifier = Modifier,
    hint:String? = null,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    onTextChange: (newText: String) -> Unit
) {
    Column (
        verticalArrangement = Arrangement.spacedBy(7.dp),
        modifier = modifier,
    ) {
        LabelText(label)
        BoxedTextField(
            text = text,
            hint = hint,
            modifier = fieldModifier,
            singleLine = singleLine,
            readOnly = readOnly,
            onTextChange = onTextChange
        )
    }
}

@Preview
@Composable
fun Preview_VInputField() {

    PreviewColumnOnSurface {
        var text by remember { mutableStateOf("some content 123") }
        VInputField(
            label = "Label 1",
            text = text,
            onTextChange = {
                text = it
            }
        )

        var text2 by remember { mutableStateOf("") }
        VInputField(
            label = "Label 2",
            hint = "input hint 2",
            text = text2,
            onTextChange = {
                text2 = it
            }
        )
    }
}
