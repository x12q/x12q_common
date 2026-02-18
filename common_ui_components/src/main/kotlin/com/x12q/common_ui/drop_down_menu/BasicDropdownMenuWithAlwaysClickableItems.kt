package com.x12q.common_ui.drop_down_menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.corner8Border
import com.x12q.common_ui.theme.BaseTheme

/**
 * A basic drop menu with always-enable items
 */
@Composable
fun <T> BasicDropdownMenuWithAlwaysClickableItems(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    items: List<T>,
    onPick: (T) -> Unit,
    modifier: Modifier = Modifier,
    itemView: @Composable (T) -> Unit,
) {
    DropdownMenu(
        modifier = modifier.corner8Border(),
        expanded = expanded,
        onDismissRequest = onDismissRequest,
        containerColor = BaseTheme.colors.baseColors.surface1
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
        ) {
            items.forEach { item ->
                Box(
                    modifier = Modifier
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = ripple(color = BaseTheme.colors.baseColors.onSurface2),
                            onClick = {
                                onPick(item)
                            }
                        )
                ) {
                    itemView(item)
                }
            }
        }
    }
}

