package com.chootadev.interview.sharedelementtry.presentation

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.FloatingActionButtonElevation
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SuggestionChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.chootadev.interview.sharedelementtry.common.FadeAnimation
import com.chootadev.interview.sharedelementtry.common.LeftIconText
import com.chootadev.interview.sharedelementtry.common.MoviePosterView
import com.chootadev.interview.sharedelementtry.common.tmdbPoster
import com.chootadev.interview.sharedelementtry.model.MovieList

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.DetailsScreen(animatedVisibilityScope: AnimatedVisibilityScope, navController: NavController, movieId: String){
    val configuration = LocalConfiguration.current

    val movie = MovieList().find{
        it.id == movieId.toInt()
    }!!

    Box {
        Column(modifier = Modifier.fillMaxSize()) {
            MoviePosterView(
                posterPath = movie.posterPath,
                isBig = true,
                onClick = {},
                isFillWidth = true,
                animatedVisibilityScope = animatedVisibilityScope
            )
            Text(
                text = movie.title,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .sharedElement(
                        rememberSharedContentState(key = "${movie.title}+${movie.id}"),
                        animatedVisibilityScope
                    )
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            LeftIconText(animatedVisibilityScope, 16.sp)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .sharedElement(
                        rememberSharedContentState(key = "categories"),
                        animatedVisibilityScope
                    )
                    .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(
                    space = 8.dp,
                    alignment = Alignment.CenterHorizontally
                ), verticalAlignment = Alignment.CenterVertically
            ) {
                SuggestionChip(onClick = {}, label = { Text("Action") })
                SuggestionChip(onClick = {}, label = { Text("Adventure") })
                SuggestionChip(onClick = {}, label = { Text("Horror") })
            }
            FadeAnimation {
                Text(
                    text = "Description",
                    fontSize = 24.sp,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                )
            }
            Text(
                text = movie.overview,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth()
                    .sharedElement(
                        rememberSharedContentState(key = "overview"),
                        animatedVisibilityScope
                    )
                    .padding(16.dp),
            )
            FadeAnimation {
                Text(
                    text = "Cast",
                    fontSize = 24.sp,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp),
                )
            }
            FadeAnimation {
                LazyRow(
                    contentPadding = PaddingValues(8.dp),
                    modifier = Modifier.padding(top = 8.dp)
                ) {
                    items(MovieList()) { item ->
                        Column(
                            modifier = Modifier.size(110.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(80.dp)
                                    .clip(CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                AsyncImage(
                                    model = item.backdropPath.tmdbPoster(),
                                    contentDescription = "",
                                    modifier = Modifier.fillMaxWidth(),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Name Name",
                                fontSize = 16.sp,
                                overflow = TextOverflow.Ellipsis,
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth(),
                            )
                        }
                    }
                }
            }
        }
        FloatingActionButton(
            containerColor = Color.Black,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .offset(y = (-70).dp)
                .padding(16.dp),
            elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 10.dp),
            onClick = { navController.popBackStack() }
        ) {
            Icon(Icons.Default.ArrowBack, contentDescription = "", tint = Color.White)
        }
    }
}