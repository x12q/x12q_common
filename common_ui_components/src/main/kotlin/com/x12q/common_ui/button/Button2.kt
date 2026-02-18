package com.x12q.common_ui.button

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Indication
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.preview_views.PreviewBoxOnSurface
import com.x12q.common_ui.preview_views.PreviewColumn
import com.x12q.common_ui.text.ButtonText
import com.x12q.common_ui.theme.BaseTheme
import com.x12q.common_ui.theme.LocalCommonColorProvider


@Composable
fun Button2(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = BaseTheme.shapes.corner6,
    colors: Button2Colors = Button2Colors.undefined,
    elevation: Dp = 0.dp,
    border: BorderStroke? = null,
    contentPadding: PaddingValues? = PaddingValues(horizontal = 24.dp, vertical = 5.dp),
    interactionSource: MutableInteractionSource? = null,
    onClick: () -> Unit,
) {
    Button2(
        onClick = onClick,
        modifier = modifier.defaultMinSize(minWidth = 1.dp, minHeight = 1.dp),
        enabled = enabled,
        shape = shape,
        colors = colors,
        elevation = elevation,
        border = border,
        contentPadding = contentPadding,
        interactionSource = interactionSource,
    ) {
        ButtonText(text)
    }
}


@Composable
fun Button2(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = BaseTheme.shapes.corner6,
    colors: Button2Colors = Button2Colors.undefined,
    elevation: Dp = 0.dp,
    border: BorderStroke? = null,
    contentPadding: PaddingValues? = PaddingValues(horizontal = 24.dp, vertical = 5.dp),
    interactionSource: MutableInteractionSource? = null,
    indication: Indication = LocalIndication.current,
    content: @Composable BoxScope.() -> Unit
) {

    val actualColor = if(colors == Button2Colors.undefined){
        LocalCommonColorProvider.current.buttonColors
    }else{
        colors
    }

    val its = interactionSource ?: remember { MutableInteractionSource() }
    val isHovered by its.collectIsHoveredAsState()
    val backgroundColor = actualColor.background(enabled, isHovered)

    Box(
        modifier = modifier
            .clip(shape)
            .hoverable(its)
            .background(backgroundColor, shape)
            .clickable(
                interactionSource = its,
                indication = indication,
                enabled = enabled,
                onClickLabel = null,
                role = Role.Button,
                onClick = onClick
            )
            .shadow(elevation,shape = shape)
            .border(border ?: BorderStroke(2.dp, colors.borderStrokeColor),shape),
        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = if(contentPadding!=null) Modifier.padding(contentPadding) else Modifier,
            contentAlignment = Alignment.Center
        ){
            content()
        }
    }
}


@Preview
@Composable
private fun Preview_BasicButton() {
    PreviewBoxOnSurface {
        PreviewColumn {
            Button2({}) {
                ButtonText("OK")
            }

            Button2("Ok",onClick = {}, )

            Button2({}) {
                ButtonText("Cancel")
            }
            Button2("Cancel",onClick = {})
        }

    }
}
