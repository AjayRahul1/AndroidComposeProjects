package com.ajayrahul1.businesscardcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ajayrahul1.businesscardcompose.ui.theme.BusinessCardComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Surface(color = Color(0xFF073042)) {
        HomeInterfaceTop(
            Logo = painterResource(id = R.drawable.android_logo),
            Name = stringResource(R.string.Developer_Name),
            Designation = stringResource(R.string.designation)
        )
    }
}

@Composable
fun HomeInterfaceTop(
    Logo: Painter,
    Name: String,
    Designation: String
) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(top = 200.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = Logo,
            contentDescription = null,
            Modifier
                .size(100.dp, 100.dp),
            contentScale = ContentScale.Crop
        )
        Text(
            text = Name,
            Modifier.padding(all = 10.dp),
            fontSize = 48.sp,
            fontFamily = FontFamily.Serif,
            color = Color.White
        )
        Text(
            text = Designation,
            Modifier.padding(5.dp),
            color = Color(0xFF3ddc84)
        )
        Spacer(modifier = Modifier.height(100.dp))
        DetailInfo(
            Icons.Default.Call,
            stringResource(R.string.ph_no)
        )
        DetailInfo(
            icon = Icons.Default.Person,
            details = stringResource(R.string.social_media_username)
        )
        DetailInfo(
            icon = Icons.Default.Share,
            details = stringResource(R.string.github_username)
        )
        DetailInfo(
            icon = Icons.Default.Email,
            details = stringResource(R.string.my_email)
        )
    }
}

@Composable
fun DetailInfo(
    icon: ImageVector,
    details: String
) {
    Column {
        Divider(
            modifier = Modifier.fillMaxWidth(),
            color = Color.White
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
                .height(IntrinsicSize.Min),
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                icon,
                contentDescription = icon.toString(),
                Modifier
                    .padding(
                        start = 50.dp,
                        bottom = 5.dp,
                        top = 5.dp,
                        end = 5.dp
                    )
                    .fillMaxHeight()
                    .fillMaxHeight()
                    .wrapContentWidth(Alignment.Start),
                tint = Color.Green
            )
            Text(
                text = details,
                color = Color.White,
                fontSize = 20.sp,
                modifier = Modifier
                    .padding(end = 5.dp, start = 5.dp, top = 5.dp, bottom = 5.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.Start)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardComposeTheme {
        BusinessCardApp()
    }
}