package com.example.converters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.converters.composables.ConverterScreen
import com.example.converters.ui.theme.ConvertersTheme
import com.example.converters.ui.theme.Montserrat

class MainActivity : ComponentActivity() {
//    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ConvertersTheme {
                Surface {
                    ConverterScreen()
                }
            }
        }
    }
}





//Some rejected idea by me below

//@Composable
//fun ConvertersScreen(){
//
//    var buttonClicked by remember {
//        mutableStateOf(2)
//    }
//
//    val context = LocalContext.current
//
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceEvenly
//    ) {
//
//        if(buttonClicked == 0){
//
//        Column(modifier = Modifier.weight(1f),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//            Text(
//                text = stringResource(id = R.string.select),
//                fontSize = 50.sp,
//                fontWeight = FontWeight.Bold,
//                style = MaterialTheme.typography.body2,
//                textAlign = TextAlign.Center
//            )
//        }
//        Column(
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.weight(4f)
//        ) {
//
//            //Currency Button
//            ConvertButton(
//                modifier = Modifier, label = R.string.cc,
//                onTap = {
//                    buttonClicked = 1
//                })
//            Spacer(modifier = Modifier.height(20.dp))
//
//            //Timezone Button
//            ConvertButton(
//                label = R.string.tc, modifier = Modifier,
//                onTap = {
//                    buttonClicked = 2
////                    context.startActivity(Intent(context,))
//                })
//            Spacer(modifier = Modifier.height(20.dp))
//
//            //Unit Button
//            ConvertButton(
//                label = R.string.uc, modifier = Modifier,
//                onTap = {
//                    buttonClicked = 3
//                    context.startActivity(Intent(context, UnitConverterScreen::class.java))
//                })
//                Spacer(modifier = Modifier.height(100.dp))
//            }
//        }
//        if(buttonClicked == 2)
//        {
//            Column(
//                Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
//                    BackButton(onTap = {buttonClicked = 0})
//                }
//                Column(verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally) {
//                    Spacer(modifier = Modifier.height(10.dp))
//                    Text(
//                        text = stringResource(id = R.string.selectc),
//                        style = MaterialTheme.typography.body2
//                    )
//                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
//
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun ConvertButton(modifier: Modifier = Modifier, @StringRes label: Int,//@StringRes label means label is from @StringRes
//                  onTap: () -> Unit){
//    OutlinedButton(
//        onClick = onTap,
//        shape = RoundedCornerShape(20),
//        colors = ButtonDefaults.outlinedButtonColors(backgroundColor = Color.Transparent),
//        border = BorderStroke(3.dp, Color.Black) ,
//        modifier = Modifier
//            .width(300.dp)
//            .height(60.dp)
//        )
//    {
//        Surface( color = Color.Transparent) {//transparent hi rkh vai baat maan
//            Text(text = stringResource(id = label),
//                color = Color.Black,
//                fontSize = 25.sp,
//                style = MaterialTheme.typography.h2
//                )
//        }
//    }
//}
//@Composable
//fun BackButton(modifier: Modifier = Modifier,
//                  onTap: () -> Unit){
//    TextButton(
//        onClick = onTap,
//        modifier = Modifier
//            .width(100.dp)
//            .height(60.dp)
//    )
//    {
//        Surface( color = Color.Transparent) {
//            Text(text = stringResource(id = R.string.back),
//                color = Color.Black,
//                fontSize = 15.sp,
//                style = MaterialTheme.typography.h2
//            )
//        }
//    }
//}
//
//
@Preview(showBackground = true)
@ExperimentalAnimationApi
@Composable
fun DefaultPreview() {
    ConvertersTheme {
        ConverterScreen()
    }
}