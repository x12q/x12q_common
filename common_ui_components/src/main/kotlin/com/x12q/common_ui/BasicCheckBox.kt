package com.x12q.common_ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.x12q.common_ui.preview_views.PreviewRow
import com.x12q.common_ui.theme.BaseTheme

@Composable
fun BasicCheckBox(
    checked: Boolean,
    onCheckedChange: (newCheckValue: Boolean) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Checkbox(
        checked, enabled = enabled, onCheckedChange = onCheckedChange,
        colors = CheckboxDefaults.colors(
            checkedColor = BaseTheme.colors.baseColors.primary,
            uncheckedColor = BaseTheme.colors.baseColors.strongOnSurface1,
            checkmarkColor = BaseTheme.colors.baseColors.onPrimary,
            disabledColor = BaseTheme.colors.baseColors.disabled
        ),
        modifier = modifier,
    )
}

@Preview
@Composable
fun Preview_BasicCheckBox() {
    var checked by remember { mutableStateOf(true) }
    PreviewRow {
        BasicCheckBox(checked, onCheckedChange = { checked = !checked })
        BasicCheckBox(checked, onCheckedChange = { checked = !checked }, enabled = false)
    }
}
