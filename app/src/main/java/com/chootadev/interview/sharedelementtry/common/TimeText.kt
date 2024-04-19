package com.chootadev.interview.sharedelementtry.common

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.xero.interview.sharedelementtry.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.LeftIconText(
    animatedVisibilityScope : AnimatedVisibilityScope,
    fontSize: TextUnit = 16.sp,
    fontColor: Color = Color.Black,
    text: String = "1h 59m",
    icon: Painter = painterResource(id = R.drawable.nest_clock),
    tag: String = "inlineContent"
){
    val inlineContent = mapOf(
        Pair(
            tag,
            InlineTextContent(
                Placeholder(
                    width = fontSize,
                    height = fontSize,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                )
            ) {
                Icon(painter = icon,text,tint = fontColor)
            }
        )
    )
    val textForText = buildAnnotatedString {
        appendInlineContent(tag, "[icon]")
        append(" $text")
    }

    Text(
        text = textForText,
        modifier = Modifier
            .fillMaxWidth()
            .sharedElement(rememberSharedContentState(key = text), animatedVisibilityScope)
            .padding(top = 16.dp),
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = fontColor,
        inlineContent = inlineContent
    )
}