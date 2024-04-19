package com.chootadev.interview.sharedelementtry.common

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.chootadev.interview.sharedelementtry.ui.theme.SharedElementTryTheme

/**
 * MoviePoster view, used in places where only the rounded corner poster is shown
 * Has ability to change from adapting to screen width or 300x210 size
 *
 * @param posterPath will be used to set the poster url part
 * @param isDetails can used to change the size to adapt the screen width or 300x210 size
 */
@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.MoviePosterView(posterPath: String, isBig: Boolean = false, isFillWidth: Boolean = false, onClick:() -> Unit = {}, animatedVisibilityScope: AnimatedVisibilityScope) {
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(posterPath.tmdbPoster())
            .memoryCachePolicy(CachePolicy.ENABLED)
            .size(Size.ORIGINAL)
            .build()
    )

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp

    val height = if(isBig) (screenWidth - 40).dp else 300.dp
    val weight = if(isBig) (((screenWidth)/3)*2).dp else 210.dp

    Box(modifier = Modifier.padding(bottom = if(isFillWidth) 0.dp else 16.dp)){
        Card(
            modifier = Modifier
                .width(if (isFillWidth) screenWidth.dp else weight)
                .height(height)
                .clickable { onClick() },
            shape = RoundedCornerShape(if(isFillWidth) 0.dp else 14.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = if(isFillWidth) 0.dp else 12.dp)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .sharedElement(rememberSharedContentState(key = posterPath), animatedVisibilityScope),
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }
    }
}