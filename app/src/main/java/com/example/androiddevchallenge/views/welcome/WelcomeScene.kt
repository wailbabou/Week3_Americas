package com.example.androiddevchallenge.views.welcome

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScene(navigateToLogin : ()-> Unit){
    Surface(color = MaterialTheme.colors.background) {
        Box{
            // background
            Image(
                painter = painterResource(id = R.drawable.ic_welcome_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
            )
            // content
            Box{
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .wrapContentSize(align = Alignment.Center)
                        .padding(16.dp),

                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_logo),
                        contentDescription = null,
                        modifier = Modifier
                            .height(42.dp),
                        contentScale = ContentScale.FillBounds
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth()
                        .wrapContentSize(align = Alignment.BottomCenter)
                ) {
                   Row(
                       horizontalArrangement = Arrangement.spacedBy(8.dp),
                       modifier = Modifier.padding(
                           vertical = 32.dp,
                           horizontal =  16.dp
                       )
                   ){
                       Button(
                           { navigateToLogin() },
                           modifier = Modifier
                               .height(48.dp)
                               .fillMaxWidth()
                               .weight(1f),
                           shape = MaterialTheme.shapes.large,
                           colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                       ) {
                           Text(
                               text = "Get Started".toUpperCase(),
                               style = MaterialTheme.typography.button,
                               color = MaterialTheme.colors.onPrimary
                           )
                       }

                       OutlinedButton(
                           { navigateToLogin() },
                           modifier = Modifier
                               .height(48.dp)
                               .fillMaxWidth()
                               .weight(1f),
                           shape = MaterialTheme.shapes.large,
                           border = BorderStroke(1.dp, MaterialTheme.colors.primary),
                           colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent)
                       ) {
                           Text(
                               text = "Log in".toUpperCase(),
                               style = MaterialTheme.typography.button,
                               color = MaterialTheme.colors.onBackground
                           )
                       }
                   }
                }
            }

        }
    }
}

@Preview("Light Welcome", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeLightPreview(){
    MyTheme {
        WelcomeScene(navigateToLogin = { /*TODO*/ })
    }
}
@Preview("Dark Welcome", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeDarkPreview(){
    MyTheme(darkTheme = true) {
        WelcomeScene(navigateToLogin = { /*TODO*/ })
    }
}