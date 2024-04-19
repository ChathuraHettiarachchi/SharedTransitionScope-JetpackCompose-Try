package com.chootadev.interview.sharedelementtry.presentation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.chootadev.interview.sharedelementtry.common.LeftIconText
import com.chootadev.interview.sharedelementtry.common.MoviePosterView
import com.chootadev.interview.sharedelementtry.common.tmdbPoster
import com.chootadev.interview.sharedelementtry.model.Movie
import com.chootadev.interview.sharedelementtry.model.MovieList
import com.xero.interview.sharedelementtry.R
import kotlin.math.absoluteValue
import kotlin.reflect.KProperty


@OptIn(ExperimentalFoundationApi::class, ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.HomeScreen(
    animatedVisibilityScope: AnimatedVisibilityScope,
    navigateToDetails: (Movie) -> Unit
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp

    val pages = MovieList()
    val pagerState = rememberPagerState(pageCount = { pages.size })

    fun navigateToDetailsPage() = navigateToDetails(pages[pagerState.currentPage])

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black)
        ) {
            AsyncImage(
                contentScale = ContentScale.Crop,
                model = pages[pagerState.currentPage].posterPath.tmdbPoster(),
                contentDescription = pages[pagerState.currentPage].title,
                modifier = Modifier
                    .fillMaxSize()
                    .alpha(0.6f)
                    .blur(radius = 16.dp)
            )
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 64.dp)
            ) { page ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            val pageOffset = (
                                    (pagerState.currentPage - page) + pagerState
                                        .currentPageOffsetFraction
                                    ).absoluteValue

                            lerp(
                                start = 0.85f,
                                stop = 1f,
                                fraction = 1f - pageOffset.coerceIn(0f, 1f)
                            ).also { scale ->
                                scaleX = scale
                                scaleY = scale
                            }
                        },
                ) {
                    Column(modifier = Modifier.padding(top = 100.dp)) {
                        MoviePosterView(
                            posterPath = pages[page].posterPath,
                            isBig = true,
                            onClick = { navigateToDetailsPage() },
                            animatedVisibilityScope = animatedVisibilityScope
                        )
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((screenHeight / 2.4).dp)
                        .shadow(elevation = 12.dp)
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp)
                            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LeftIconText(animatedVisibilityScope, 16.sp, fontColor = Color.Gray)
                        Text(
                            text = pages[pagerState.currentPage].title,
                            fontSize = 28.sp,
                            modifier = Modifier
                                .fillMaxWidth()
                                .sharedElement(
                                    rememberSharedContentState(key = "${pages[pagerState.currentPage].title}+${pages[pagerState.currentPage].id}"),
                                    animatedVisibilityScope
                                )
                                .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .sharedElement(rememberSharedContentState(key = "categories"), animatedVisibilityScope)
                                .padding(8.dp),
                            horizontalArrangement = Arrangement.spacedBy(
                                space = 8.dp,
                                alignment = Alignment.CenterHorizontally
                            ),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            SuggestionChip(onClick = {}, label = { Text("Action") })
                            SuggestionChip(onClick = {}, label = { Text("Adventure") })
                            SuggestionChip(onClick = {}, label = { Text("Horror") })
                        }
                        Text(
                            text = pages[pagerState.currentPage].overview,
                            fontSize = 16.sp,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier
                                .fillMaxWidth()
                                .sharedElement(rememberSharedContentState(key = "overview"), animatedVisibilityScope)
                                .padding(16.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}

