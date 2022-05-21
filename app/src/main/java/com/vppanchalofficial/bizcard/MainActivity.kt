package com.vppanchalofficial.bizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vppanchalofficial.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCards()
                }
            }
        }
    }
}
@Composable
fun CreateBizCards() {
    val buttonClickState = remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()) {

        Card(modifier = Modifier
            .width(250.dp)
            .height(250.dp)
            .padding(20.dp),
            shape = RoundedCornerShape(corner = CornerSize(20.dp)),
            backgroundColor = Color.White, elevation = 10.dp) {

                Column(modifier = Modifier.size(120.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally) {

                    profile( modifier = Modifier
                        .size(120.dp)
                        .padding(10.dp))

                    Divider(modifier = Modifier.height(2.dp), color = Color.Blue,
                    thickness = 5.dp, startIndent = 0.dp)

                    Column(modifier = Modifier.padding(5.dp), horizontalAlignment = Alignment.Start) {
                        Text(text = "Hello, Vaibhavi", color = Color.Blue, style = MaterialTheme.typography.h4, fontSize = 18.sp)
                        Text(text = "Android Developer", color = Color.Black, style = MaterialTheme.typography.h6, fontSize = 12.sp)
                        Text(text = "vppanchal@gmail.com", color = Color.Black, style = MaterialTheme.typography.h6, fontSize = 12.sp)
                    }

                    Button(onClick = {
                        buttonClickState.value = !buttonClickState.value
                           }) {
                        Text(text = "Portfolio")
                    }
                    if(buttonClickState.value){
                       listOfProject()
                    }else{
                        Box {

                        }
                    }
                }

        }
    }
}

@Composable
private fun profile(modifier: Modifier) {
    Surface(
        modifier = modifier,
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        elevation = 6.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_baseline_person_24),
            contentDescription = "Image",
            modifier = Modifier.size(120.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        CreateBizCards()
        //Greeting("Android")
    }
}
//@Preview(showBackground = true)
@Composable
fun list() {
    BizCardTheme {
       listOfProject()
    }
}

@Composable
fun listOfProject() {
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(20.dp)),
            border = BorderStroke(0.5.dp,Color.LightGray),
            elevation = 6.dp) {
            portfolioList(data = listOf<String>("Project1","Project2","Project1","Project2","Project1","Project2","Project1","Project2"))
        }
    }
}
@Composable
fun portfolioList(data: List<String>) {
    LazyColumn{
        items(data) { item ->
            Card(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(10.dp),shape = RoundedCornerShape(10.dp),
            backgroundColor = Color.LightGray,
            border = BorderStroke(2.dp,Color.LightGray)) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight().padding(10.dp)) {
                    profile(modifier = Modifier.size(40.dp).padding(4.dp))
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()){
                        Text(text = "Hello Vaibhavi")
                        Text(text = "Hello")

                    }
                }
            }
        }
    }
}
