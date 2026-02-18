package com.x12q.common_ui.button.common_buttons

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import com.x12q.common_ui.button.TransparentIconButton

/**
 * A button that can be used to indicate expanding state.
 * It accepts an [icon], and when [isExpanded], it will rotate the icon with a short animation
 */
@Composable
fun ExpandRotateButton(
    icon: Painter,
    isExpanded: Boolean,
    tint: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    animationSpace: AnimationSpec<Float> = tween(200),
) {
    TransparentIconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        val animatedRotationDegree = animateFloatAsState(
            targetValue = if (isExpanded) 180f else 0f,
            animationSpec = animationSpace,
        )
        Icon(
            painter = icon,
            contentDescription = null,
            modifier = Modifier.rotate(animatedRotationDegree.value),
            tint = tint,
        )
    }
}