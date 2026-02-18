package com.x12q.common_ui

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.theme.BaseTheme
import com.x12q.common_ui.box.*
import com.x12q.common_ui.preview_views.*
import com.x12q.common_ui.text.*
import com.x12q.common_ui.button.*
import com.x12q.common_ui.input_field.*

@Preview
@Composable
private fun Preview_Theme() {
    BaseTheme(isDarkTheme = true) {
        SurfaceBox {
            PreviewColumn {
                PreviewRow {
                    LabelText("Label text:")
                    ContentText("Content text")
                }
                PreviewRow {
                    CenterAlignBox(
                        modifier = Modifier.background(
                            BaseTheme.colors.baseColors.surface2
                        ).corner8Border()
                    ) {
                        PreviewColumn(Modifier.padding(20.dp)) {
                            ContentText("// Editor text")
                            ContentText("fun abc(): Int{")
                            ContentText("    return 1+2+3")
                            ContentText("}")
                            ContentText("Editor text")
                        }
                    }
                    Box(
                        Modifier.size(width = 10.dp, height = 120.dp)
                            .background(BaseTheme.colors.baseColors.strongOnSurface1)
                    )
                }

                PreviewRow {
                    Button2("Ok"){}
                    Button2("Cancel"){}
                }

                Preview_BasicCheckBox()

                Preview_HInputField()

                Preview_VInputField()

                Preview_BasicIconButton()
            }
        }
    }
}
