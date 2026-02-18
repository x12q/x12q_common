package com.x12q.common_ui.text

import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import com.x12q.common_ui.theme.BaseTheme


@Composable
fun SelectableBoxedText(
    text: String,
    textStyle: TextStyle = BaseTheme.typography.content,
    modifier: Modifier = Modifier
) {
    SelectionContainer {
        BoxedText(
            text = text,
            textStyle = textStyle,
            modifier = modifier,
        )
    }
}

@Composable
fun SelectableBoxedText(
    text: AnnotatedString,
    textStyle: TextStyle = BaseTheme.typography.content,
    modifier: Modifier = Modifier
) {
    SelectionContainer {
        BoxedText(
            text = text,
            textStyle = textStyle,
            modifier = modifier,
        )
    }
}
