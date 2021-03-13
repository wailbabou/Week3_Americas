package com.example.androiddevchallenge.views.homescroll

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.ItemDetail
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.views.home.HomeScene

/*
 */
val dataList = arrayListOf(
    ItemDetail("$7.918", "ALK", "Alaska Air Group, Inc.", "-0.54%", R.drawable.ic_home_alk),
    ItemDetail("$1.293", "BA", "Boeing Co.", "+4.18%",R.drawable.ic_home_ba),
    ItemDetail("$893.50", "DAL", "Delta Airlines Inc.", "-0.54%",R.drawable.ic_home_dal),
    ItemDetail("$12.301", "EXPE", "Expedia Group Inc.", "+2.51%",R.drawable.ic_home_exp),
    ItemDetail("$12.301", "EADSY", "Airbus SE", "+1.38%",R.drawable.ic_home_eadsy),
    ItemDetail("$8.521", "JBLU", "Jetblue Airways Corp.", "+1.56%",R.drawable.ic_home_jblu),
    ItemDetail("$521", "MAR", "Amarriot International Inc.", "+2.75%",R.drawable.ic_home_mar),
    ItemDetail("$5.481", "CCL", "Alaska Air Group, Inc.","+0.14%",R.drawable.ic_home_ccl),
    ItemDetail("$9.184", "RCL", "Royal Caribbean Cruises","+1.69%",R.drawable.ic_home_rcl),
    ItemDetail("$654", "TRVL", "Travelocity Inc.", "+3.23%",R.drawable.ic_home_trvl)

)
@Composable
fun DetailsScene(){
    Surface(color = MaterialTheme.colors.surface) {
        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier
                        .height(64.dp)
                        .fillMaxWidth(),
                    backgroundColor = MaterialTheme.colors.surface
                ) {
                    Text(
                        text = "Positions",
                        modifier = Modifier
                            .paddingFromBaseline(bottom = 24.dp)
                            .fillMaxWidth()
                            .wrapContentSize(Alignment.Center)
                        ,
                        color = MaterialTheme.colors.onSurface
                    )
                }
            }
        ) {
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(MaterialTheme.colors.surface)
                    .padding(horizontal = 16.dp)

            ) {
                items(dataList) { content ->
                    RowDetail(item = content)
                }
            }
        }
    }
}

@Composable
fun RowDetail(item : ItemDetail){
    val color = if(item.percent.startsWith("-")){
        Color(0xFF39A844)
    }else{
        Color(0xFFD93C19)
    }
    Column {
        Divider()
        Row{
            Column(

            ) {
                Text(
                    text =item.dollar,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.paddingFromBaseline(top = 24.dp)
                )
                Text(
                    text =item.percent,
                    style = MaterialTheme.typography.h3,
                    color = color,
                    modifier = Modifier.paddingFromBaseline(bottom = 16.dp)
                )
            }
            Spacer(Modifier.size(24.dp))
            Column(
            ) {
                Text(
                    text = item.header,
                    style = MaterialTheme.typography.body1,
                    color = color,
                    modifier = Modifier.paddingFromBaseline(top = 24.dp)
                )
                Text(
                    text = item.body,
                    style = MaterialTheme.typography.body1,
                    color = MaterialTheme.colors.onSurface,
                    modifier = Modifier.paddingFromBaseline(bottom = 16.dp)
                )
            }
            Image(painter = painterResource(
                id = item.resource),
                contentDescription =  null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .wrapContentSize(Alignment.CenterEnd),
                contentScale = ContentScale.FillHeight)
        }
        Divider()
    }
}

@Preview("Preview details")
@Composable
fun PreviewDetails(){
    MyTheme {
        DetailsScene()
    }
}