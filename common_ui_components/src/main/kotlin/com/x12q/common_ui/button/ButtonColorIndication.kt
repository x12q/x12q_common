package com.x12q.common_ui.button

import androidx.compose.foundation.IndicationNodeFactory
import androidx.compose.foundation.interaction.FocusInteraction
import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.node.DelegatableNode
import androidx.compose.ui.node.DrawModifierNode
import androidx.compose.ui.node.invalidateDraw
import com.x12q.common_ui.theme.BaseTheme
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * A custom indication for buttons, allowing setting colors for focus and press state.
 */
data class ButtonColorIndication(
    private val focusColor:Color,
    private val pressColor: Color,
) : IndicationNodeFactory {

    override fun create(interactionSource: InteractionSource): DelegatableNode {
        return CustomColorIndicationNode(interactionSource, focusColor, pressColor)
    }

    companion object{
        @Composable
        fun forIconButton() = ButtonColorIndication(
            focusColor = BaseTheme.colors.baseColors.strongOnSurface1.copy(alpha = 0.1f),
            pressColor = BaseTheme.colors.baseColors.strongOnSurface1.copy(alpha = 0.3f),
        )

        @Composable
        fun transparent() = ButtonColorIndication(
            focusColor = Color.Transparent,
            pressColor = Color.Transparent,
        )
    }

    private class CustomColorIndicationNode(
        private val interactionSource: InteractionSource,
        private val focusColor:Color,
        private val pressColor: Color,
    ) : Modifier.Node(), DrawModifierNode {


        private var isPressed = false
        private var isHovered = false
        private var isFocused = false

        override fun onAttach() {
            coroutineScope.launch {
                var pressCount = 0
                var hoverCount = 0
                var focusCount = 0
                interactionSource.interactions.collectLatest { interaction ->
                    when (interaction) {
                        is PressInteraction.Press -> pressCount++
                        is PressInteraction.Release -> pressCount--
                        is PressInteraction.Cancel -> pressCount--
                        is HoverInteraction.Enter -> hoverCount++
                        is HoverInteraction.Exit -> hoverCount--
                        is FocusInteraction.Focus -> focusCount++
                        is FocusInteraction.Unfocus -> focusCount--
                    }
                    val pressed = pressCount > 0
                    val hovered = hoverCount > 0
                    val focused = focusCount > 0
                    var invalidateNeeded = false
                    if (isPressed != pressed) {
                        isPressed = pressed
                        invalidateNeeded = true
                    }
                    if (isHovered != hovered) {
                        isHovered = hovered
                        invalidateNeeded = true
                    }
                    if (isFocused != focused) {
                        isFocused = focused
                        invalidateNeeded = true
                    }
                    if (invalidateNeeded) invalidateDraw()
                }

            }
        }

        override fun ContentDrawScope.draw() {

            drawContent()
            if (isPressed) {
                drawRect(color = pressColor, size = size)
            } else if (isHovered || isFocused) {
                drawRect(color = focusColor, size = size)
            }
        }
    }
}

