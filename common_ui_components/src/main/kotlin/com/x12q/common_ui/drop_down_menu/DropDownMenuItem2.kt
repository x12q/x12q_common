package com.x12q.common_ui.drop_down_menu

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.x12q.common_ui.preview_views.PreviewBoxOnSurface
import com.x12q.common_ui.preview_views.PreviewColumn
import com.x12q.common_ui.text.ContentText
import com.x12q.common_ui.theme.BaseTheme


@Composable
fun DropDownMenuItem2(
    label: String,
    textStyle: TextStyle = BaseTheme.typography.content.copy(
        fontSize = 14.sp,
    ),
    colors: DropDownButtonItemColors = BaseTheme.colors.dropDownItemColors,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clickable(enabled){
                onClick()
            }
    ) {
        ContentText(
            text = label,
            style = textStyle.copy(
                color = if(enabled){
                    colors.textEnabledColor
                }else{
                    colors.textDisabledColor
                }
            ),
            modifier = Modifier.padding(5.dp),
        )
    }
}


@Preview
@Composable
private fun Preview_DropDownButtonItem() {
    PreviewBoxOnSurface {
        PreviewColumn {
            DropDownMenuItem2("Item 1", enabled = true, onClick = {})
            DropDownMenuItem2("Item 2", enabled = false, onClick = {})
        }
    }
}
