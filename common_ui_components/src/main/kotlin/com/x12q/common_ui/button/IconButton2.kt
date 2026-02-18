package com.x12q.common_ui.button

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.BasicIcon
import com.x12q.common_ui.preview_views.PreviewRow
import com.x12q.common_ui.theme.LocalCommonColorProvider

/**
 * A basic icon button derived from [Button2] with a default padding that makes it square.
 */
@Composable
fun IconButton2(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: IconButton2Colors = IconButton2Colors.undefined,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
    icon: @Composable BoxScope.(IconButton2Colors) -> Unit,
) {
    val actualColor = if(colors == IconButton2Colors.undefined){
        LocalCommonColorProvider.current.iconButtonColors
    }else{
        colors
    }
    Button2(
        onClick = onClick,
        contentPadding = contentPadding,
        modifier = modifier,
        border = border,
        colors = actualColor.buttonColors,
    ) {
        icon(colors)
    }
}

@Composable
fun IconButton2(
    bitmap: ImageBitmap,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: IconButton2Colors = IconButton2Colors.undefined,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
) {
    val actualColor = if(colors == IconButton2Colors.undefined){
        LocalCommonColorProvider.current.iconButtonColors
    }else{
        colors
    }
    Button2(
        onClick = onClick,
        contentPadding = contentPadding,
        modifier = modifier,
        border = border,
        colors = actualColor.buttonColors,
    ) {
        BasicIcon(bitmap = bitmap, contentDescription = "", tint = actualColor.iconTint)
    }
}


@Composable
fun IconButton2(
    painter: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: IconButton2Colors = IconButton2Colors.undefined,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
) {
    val actualColor = if(colors == IconButton2Colors.undefined){
        LocalCommonColorProvider.current.iconButtonColors
    }else{
        colors
    }
    Button2(
        onClick = onClick,
        contentPadding = contentPadding,
        modifier = modifier,
        border = border,
        colors = actualColor.buttonColors,
    ) {
        BasicIcon(painter = painter, contentDescription = "", tint = actualColor.iconTint)
    }
}


@Composable
fun IconButton2(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: IconButton2Colors = IconButton2Colors.undefined,
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(horizontal = 5.dp, vertical = 5.dp),
) {
    val actualColor = if(colors == IconButton2Colors.undefined){
        LocalCommonColorProvider.current.iconButtonColors
    }else{
        colors
    }
    Button2(
        onClick = onClick,
        contentPadding = contentPadding,
        modifier = modifier,
        border = border,
        colors = actualColor.buttonColors,
    ) {
        BasicIcon(imageVector = imageVector, contentDescription = "", tint = actualColor.iconTint)
    }
}


@Preview
@Composable
fun Preview_BasicIconButton() {
    PreviewRow {
        IconButton2(
            imageVector = Icons.Default.Call,
            onClick = {},
        )

        IconButton2(
            imageVector = Icons.Default.Check,
            onClick = {},
        )
    }
}
