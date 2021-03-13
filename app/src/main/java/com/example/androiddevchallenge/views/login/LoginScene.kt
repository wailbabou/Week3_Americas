package com.example.androiddevchallenge.views.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
fun LoginScene(
    loginViewModel: LoginViewModel  = LoginViewModel(),
    navigateToHome : () -> Unit){
    Surface(color = MaterialTheme.colors.onBackground) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.TopCenter)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
            ){
                Image(
                    painter = painterResource(id = R.drawable.ic_login_bg),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds,
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(align = Alignment.Center)
                ) {
                    Text(
                        text = "Welcome",
                        style = MaterialTheme.typography.h2,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center)
                            .paddingFromBaseline(bottom = 16.dp, top = 152.dp)
                    )

                    Text(
                        text = "Back",
                        style = MaterialTheme.typography.h2,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
            ){
                InputsLogin(loginViewModel = loginViewModel,action = navigateToHome)
            }
        }
    }
}
@Composable
fun InputsLogin(loginViewModel: LoginViewModel,action : () -> Unit){
    val email : String by loginViewModel.email.observeAsState("")
    val password : String by loginViewModel.password.observeAsState("")
    Column(
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        Spacer(Modifier.size(40.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
            ,
            value = email,
            onValueChange = { loginViewModel.onEmailChanged(it)},
            leadingIcon = {
                Icon(
                    Icons.Filled.Email,
                    tint = MaterialTheme.colors.onSurface,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text(
                text="Email",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )}
        )
        Spacer(Modifier.size(8.dp))

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
            ,
            value = password,
            onValueChange = { loginViewModel.onEmailChanged(it)},
            leadingIcon = {
                Icon(
                    Icons.Filled.Password,
                    tint = MaterialTheme.colors.onSurface,
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )
            },
            label = { Text(
                text="Password",
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.onSurface
            )}
        )

        Spacer(Modifier.size(16.dp))
        Button(
            { action() },
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.large,
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
        ) {
            Text(
                text = "Login".toUpperCase(),
                style = MaterialTheme.typography.button,
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}

@Preview("Light Login", widthDp = 360, heightDp = 640)
@Composable
fun LoginLightPreview(){
    MyTheme {
        LoginScene{}
    }
}
@Preview("Dark Login", widthDp = 360, heightDp = 640)
@Composable
fun LoginDarkPreview(){
    MyTheme(darkTheme = true) {
        LoginScene{}
    }
}