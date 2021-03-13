package com.example.androiddevchallenge.views.home

import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.views.login.LoginScene

@Composable
fun HomeScene(navigateToDetails: () -> Unit) {

    Surface(color = MaterialTheme.colors.background) {
        Scaffold(
            bottomBar = {
                        BottomAppBar(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(64.dp),
                            backgroundColor = MaterialTheme.colors.surface
                        ) {
                            Text(
                                text = "Positions",
                                style = MaterialTheme.typography.subtitle1,
                                color = MaterialTheme.colors.onSurface,
                                modifier = Modifier
                                    .clickable {
                                        navigateToDetails()
                                    }
                                    .fillMaxWidth()
                                    .wrapContentSize(Alignment.Center)
                            )
                        }
            }
        ) {
            Column {
                Row(
                    modifier = Modifier.paddingFromBaseline(top = 64.dp,bottom = 8.dp)
                ) {
                    Text(
                        text = "ACCOUNT",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.button,
                    )
                    Text(
                        text = "WATCHLIST",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                    )
                    Text(
                        text = "PROFILE",
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center,
                        style = MaterialTheme.typography.body1,
                    )
                }
                Text(
                    text = "Balance",
                    style = MaterialTheme.typography.subtitle1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .paddingFromBaseline(bottom = 8.dp,top = 32.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .verticalScroll(rememberScrollState()),
                )
                Text(
                    text = "$73,589.01",
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onBackground,
                    modifier = Modifier
                        .paddingFromBaseline(top = 48.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center),
                )
                Spacer(Modifier.size(24.dp))
                Text(
                    text = "+412.35 today",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color(0xFF39A844),
                    modifier = Modifier
                        .paddingFromBaseline(top = 16.dp)
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center),
                )
                Spacer(Modifier.size(32.dp))
                Button(
                    { },
                    modifier = Modifier
                        .height(48.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    shape = MaterialTheme.shapes.large,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                ) {
                    Text(
                        text = "Transact".toUpperCase(),
                        style = MaterialTheme.typography.button,
                        color = MaterialTheme.colors.onPrimary
                    )
                }
                Spacer(Modifier.size(16.dp))
                HomeListItems()
                Spacer(Modifier.size(16.dp))
                Image(
                    painter = painterResource(id = R.drawable.ic_home_illos),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    contentScale = ContentScale.FillWidth
                )
                Spacer(Modifier.size(32.dp))
            }
        }
    }
}

@Composable
fun HomeListItems() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(start = 16.dp,end = 16.dp)
    ) {
        item {
            ListRowOne(text = "Week", icon = Icons.Filled.ExpandMore)
        }
        item {
            ListRowOne(text = "ETFs")
        }
        item {
            ListRowOne(text = "Stocks")
        }
        item {
            ListRowOne(text = "Funds")
        }
        item {
            ListRowOne(text = "Another item")
        }
    }
}

@Composable
fun ListRowOne(
    text: String,
    icon: ImageVector? = null
) {
    OutlinedButton(
        { },
        modifier = Modifier
            .height(40.dp),
        shape = RoundedCornerShape(20.dp),
        border = BorderStroke(1.dp, MaterialTheme.colors.onBackground),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
    ) {
        Column {
            if (icon != null) {
                Row {
                    Text(
                        text = text,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onBackground
                    )
                    Icon(
                        icon,
                        contentDescription = null,
                        tint = MaterialTheme.colors.onBackground,
                        modifier = Modifier
                            .size(16.dp)
                    )
                }
            } else {
                Text(
                    text = text,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}

@Preview("Light Home", widthDp = 360, heightDp = 640)
@Composable
fun HomeLightPreview() {
    MyTheme {
        HomeScene {}
    }
}

@Preview("Dark Home", widthDp = 360, heightDp = 640)
@Composable
fun HomeDarkPreview() {
    MyTheme(darkTheme = true) {
        HomeScene {}
    }
}