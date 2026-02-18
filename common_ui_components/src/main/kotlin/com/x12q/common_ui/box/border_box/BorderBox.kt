package com.x12q.common_ui.box.border_box

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import com.x12q.common_ui.preview_views.previewApp
import com.x12q.common_ui.theme.BaseTheme


/**
 * A Box that provides a more customized border feature.
 */
@Composable
fun BorderBox(
    modifier: Modifier = Modifier,
    borderStyle: BorderStyle = BorderStyle.ALL,
    borderColor: Color = BaseTheme.colors.baseColors.borderOnSurface1,
    borderThickness: Dp = 1.dp,
    /**
     * Whether content is overlapped by the border or not. By default, this property is false to mimic the behavior the provided compose border box.
     * Set this one to true will effectively change the size of the whole container by [borderThickness]
     */
    padContent:Boolean = false,
    contentAlignment: Alignment = Alignment.Center,
    content: @Composable BoxScope.() -> Unit = {},
) {
    Box(
        contentAlignment = contentAlignment,
        modifier = modifier.border2(borderStyle,borderColor,borderThickness)
    ) {
        if(padContent){
            Box(modifier=Modifier.padding(
                top = (if(BorderStyleValue.__TOP in borderStyle) borderThickness else 0.dp),
                bottom = (if(BorderStyleValue.__BOT in borderStyle) borderThickness else 0.dp),
                start = (if(BorderStyleValue.__LEFT in borderStyle) borderThickness else 0.dp),
                end = (if(BorderStyleValue.__RIGHT in borderStyle) borderThickness else 0.dp),
            )){
                content()
            }
        }else{
            content()
        }
    }
}

/**
 * A more customizable border modifier.
 */
@Composable
fun Modifier.border2(
    borderStyle: BorderStyle = BorderStyle.ALL,
    borderColor: Color = BaseTheme.colors.baseColors.borderOnSurface1,
    borderThickness: Dp = 1.dp,
): Modifier{
    val thickness = with(LocalDensity.current){
        borderThickness.toPx()
    }
    return drawWithContent {
        drawContent()
        val xWidth = size.width
        val yHeight = size.height
        val t = thickness
        if(t >= size.width && t >= size.height){
            drawRect(
                color = borderColor,
            )
        }else{
            val sideThickness = minOf(t,xWidth)
            val botTopThickness = minOf(t,yHeight)
            if (BorderStyleValue.__TOP in borderStyle) {
                drawLine(
                    color = borderColor,
                    start = Offset(0f, 0f+botTopThickness/2), // top left
                    end = Offset(xWidth, 0f+botTopThickness/2), // top right
                    strokeWidth = botTopThickness,

                    )
            }
            if (BorderStyleValue.__LEFT in borderStyle) {
                drawLine(
                    color = borderColor,
                    start = Offset(0f+sideThickness/2, 0f), //top left
                    end = Offset(0f+sideThickness/2, yHeight), //bot left
                    strokeWidth = sideThickness
                )
            }
            if (BorderStyleValue.__RIGHT in borderStyle) {
                drawLine(
                    color = borderColor,
                    start = Offset(xWidth-sideThickness/2, 0f), // top right
                    end = Offset(xWidth-sideThickness/2, yHeight), // bot right
                    strokeWidth = sideThickness
                )
            }
            if (BorderStyleValue.__BOT in borderStyle) {
                drawLine(
                    color = borderColor,
                    start = Offset(0f, yHeight-botTopThickness/2), // bot left
                    end = Offset(xWidth, yHeight-botTopThickness/2), // bot right
                    strokeWidth = botTopThickness
                )
            }
        }
    }
}

fun main() = previewApp {
    val size = DpSize(200.dp, 100.dp)
    Column(modifier = Modifier.padding(20.dp)) {
        Box(modifier = Modifier.size(size).border(10.dp, Color.Black)){
            Text("ABC")
        }
        Row (modifier = Modifier.padding(top=30.dp, bottom =10.dp,)) {
            BorderBox(borderStyle = BorderStyle.TOP_LEFT,
                modifier = Modifier.padding(end=10.dp).size(size).background(Color.Cyan),
                borderColor = Color.Black.copy(alpha =0.7f),
                padContent = true,
                borderThickness = 80.dp) {
                Text("ABC")
            }
            Box(modifier = Modifier.size(size).border(10.dp, Color.Black)){
                Text("ABC")
            }
        }

        BorderBox(borderStyle = BorderStyle.BOT_RIGHT, modifier = Modifier.size(size).background(Color.Cyan), borderThickness = 10.dp,padContent = false,) {
            Text("ABC")
        }
    }
}
