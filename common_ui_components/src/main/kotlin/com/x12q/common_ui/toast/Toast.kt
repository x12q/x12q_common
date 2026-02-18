package com.x12q.common_ui.toast

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.button.Button2
import com.x12q.common_ui.cornerXBorder
import com.x12q.common_ui.preview_views.PreviewColumn
import com.x12q.common_ui.text.ContentText
import com.x12q.common_ui.theme.BaseTheme
import kotlinx.coroutines.delay


@Composable
fun Toast(
    modifier: Modifier = Modifier,
    duration: ToastDuration,
    onVisibilityChange: (Boolean) -> Unit = {},
    /**
     * when [initVisibility] is null, the Toast will run exactly once cycle.
     * Otherwise, visibility can be repeated by setting the external state to true using [initVisibility] and false using [onVisibilityChange]
     */
    initVisibility: Boolean? = null,
    enterMilliSec: Int = 200,
    exitMilliSec: Int = 1000,
    content: @Composable () -> Unit,
) {
    Toast(
        durationMilliSec = duration.milliSec,
        onVisibilityChange = onVisibilityChange,
        initVisibility = initVisibility,
        enterMilliSec = enterMilliSec,
        exitMilliSec = exitMilliSec,
        modifier = modifier,
        content = content,
    )
}

@Composable
fun Toast(
    modifier: Modifier = Modifier,
    durationMilliSec: Long,
    onVisibilityChange: (Boolean) -> Unit = {},
    /**
     * when [initVisibility] is null, the Toast will run exactly once cycle.
     * Otherwise, visibility can be repeated by setting the external state to true using [initVisibility] and false using [onVisibilityChange]
     */
    initVisibility: Boolean? = null,
    enterMilliSec: Int = 800,
    exitMilliSec: Int = 800,
    content: @Composable () -> Unit,
) {

    val state = remember {
        MutableTransitionState(false)
    }

    LaunchedEffect(initVisibility) {
        if (initVisibility == null || initVisibility) {
            state.targetState = true
            delay(durationMilliSec)
            state.targetState = false
            onVisibilityChange(false)
        }
    }

    AnimatedVisibility(
        visibleState = state,
        enter = fadeIn(animationSpec = tween(enterMilliSec)),
        exit = fadeOut(animationSpec = tween(exitMilliSec)),
        modifier = modifier,
    ) {

        Box(
            Modifier.Companion
                .cornerXBorder(
                    color = Color.Transparent,
                    shape = RoundedCornerShape(120.dp),
                )
                .background(BaseTheme.colors.baseColors.strongOnSurface1.copy(alpha = 1f))
                .padding(10.dp)
        ) {
            content()
        }
    }
}


@Preview
@Composable
private fun Preview_Toast() {
    PreviewColumn {

        var show by remember { mutableStateOf(false) }

        Toast(
            duration = ToastDuration.MEDIUM,
            initVisibility = show,
            onVisibilityChange = { show = it }
        ) {
            ContentText("abc abc 123 123 ", color = Color.Black)
        }

        Button2(
            text = "Show",
            onClick = {
                show = true
            }
        )
    }
}
