package com.x12q.common_ui.input_field

import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import com.x12q.common_ui.box.BasicBorderContentBox
import com.x12q.common_ui.text.ContentText
import com.x12q.common_ui.theme.BaseTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxedTextField(
    text: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = BaseTheme.typography.content,
    hint: String? = null,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    onTextChange: (newText: String) -> Unit,
    containerBox: (@Composable (Modifier,content: @Composable () -> Unit) -> Unit)? = null,
) {
    // val textStyle = AppTheme.typography.content
    BasicTextField(
        value = text,
        onValueChange = onTextChange,
        singleLine = singleLine,
        readOnly = readOnly,
        textStyle = textStyle,
        cursorBrush = SolidColor(BaseTheme.colors.baseColors.strongOnSurface1),
        decorationBox = { textView ->
            TextContainerWithHint(
                text = text,
                hint = hint,
                hintStyle = textStyle.makeHintStyle(),
                modifier = Modifier,
                textView = textView,
                containerBox = containerBox
            )
        },
        modifier = modifier
    )
}

@Composable
private fun TextStyle.makeHintStyle(): TextStyle {
    return this.copy(
        color = BaseTheme.colors.baseColors.textHintOnSurface1
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxedTextField(
    text: AnnotatedString,
    hint: String? = null,
    modifier: Modifier = Modifier,
    singleLine: Boolean = true,
    readOnly: Boolean = false,
    onTextChange: (newText: TextFieldValue) -> Unit,
    containerBox: (@Composable (Modifier, content: @Composable () -> Unit) -> Unit)? = null,
) {

    /**
     * store a mutable state internally like this is to handle two sources of change:
     * - from outside ([text])
     * - from inside (`onValueChange` below) which includes selection changes or user editing change
     */
    var localTextValue by remember { mutableStateOf(TextFieldValue(text)) }

    LaunchedEffect(text) {
        localTextValue = TextFieldValue(
            annotatedString = text,
            selection = localTextValue.selection,
            composition = localTextValue.composition,
        )
    }

    BasicTextField(


        value = localTextValue,
        onValueChange = { newText ->
            localTextValue = newText
            onTextChange(newText)
        },
        singleLine = singleLine,
        readOnly = readOnly,
        textStyle = BaseTheme.typography.content,
        cursorBrush = SolidColor(BaseTheme.colors.baseColors.onSurface2),
        decorationBox = @Composable { textView ->
            TextContainerWithHint(
                text = text.text,
                hint = hint,
                hintStyle = BaseTheme.typography.content.makeHintStyle(),
                modifier = Modifier,
                textView = textView,
                containerBox = containerBox
            )
        },
        modifier = modifier
    )
}

@Composable
private fun TextContainerWithHint(
    text: String?,
    hint: String?,
    hintStyle: TextStyle?,
    modifier: Modifier = Modifier,
    textView: @Composable () -> Unit,
    containerBox: (@Composable (Modifier, content: @Composable () -> Unit) -> Unit)?,
) {
    TextContainerWithHint(
        text,
        hintView = {
            val showHint = hint != null && hintStyle != null && text.isNullOrEmpty()
            if (showHint) {
                ContentText(hint, style = hintStyle)
            }
        },
        textView = textView,
        modifier = modifier,
        containerBox = containerBox,
    )
}

@Composable
private fun TextContainerWithHint(
    text: String?,
    modifier: Modifier = Modifier,
    hintView: (@Composable () -> Unit)?,
    textView: @Composable () -> Unit,
    containerBox: (@Composable (Modifier,content: @Composable () -> Unit) -> Unit)?,
) {
    val showHint = hintView != null && text.isNullOrEmpty()

    if (containerBox != null) {
        containerBox(modifier) {
            if (showHint) {
                hintView()
            }
            textView()
        }
    } else {
        BasicBorderContentBox(modifier) {
            if (showHint) {
                hintView()
            }
            textView()
        }
    }
}
