package com.chootadev.interview.sharedelementtry.common

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.FadeAnimation(
    visible: Boolean = true,
    initialAlpha: Float = 0.0f,
    targetAlpha: Float = 1.0f,
    animationDuration: Int = 500,
    content: @Composable () -> Unit
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(
            initialAlpha = initialAlpha,
            animationSpec = tween(durationMillis = animationDuration)
        ),
        exit = fadeOut(
            targetAlpha = targetAlpha
        )
    ) {
        content()
    }
}