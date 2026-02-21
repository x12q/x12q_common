package com.x12q.common_ui.side_bar

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.BasicIcon
import com.x12q.common_ui.box.Dot
import com.x12q.common_ui.button.SwitchBackgroundTransparentIconButton
import com.x12q.common_ui.preview_views.PreviewColumnOnSurface
import com.x12q.common_ui.text.ContentText
import com.x12q.common_ui.theme.BaseTheme
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.jewel.ui.component.Text

@Composable
fun SideBarButton(
    buttonIcon: DrawableResource,
    text: String?,
    showBackground: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    SideBarButton(
        buttonIcon = {
            BasicIcon(
                painter = painterResource(buttonIcon),
                modifier = Modifier.size(25.dp)
            )
        },
        text = text?.let {
            {
                ContentText(it)
            }
        },
        showBackground = showBackground,
        onClick = onClick,
        modifier = modifier,
    )
}

@Composable
fun SideBarButton(
    buttonIcon: @Composable () -> Unit,
    text: (@Composable () -> Unit)?,
    showBackground: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {

    SwitchBackgroundTransparentIconButton(
        switch = showBackground,
        switchOnBackground = BaseTheme.colors.baseColors.primary,
        onClick = onClick,
        modifier = modifier,
    ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            buttonIcon()
            text?.also {
                text()
            }
        }
    }
}


@Preview
@Composable
private fun Preview_ToolBoxButtonLayout() {
    PreviewColumnOnSurface {
        SideBarButton({ Dot(Color.Red) }, { Text("zzz") }, true, {})
        SideBarButton( { Dot(Color.Green) },null, false, {})
    }
}
