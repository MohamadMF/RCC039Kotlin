package com.example.googlesignin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.googlesignin.ui.theme.GoogleSigninTheme
import com.example.googlesignin.ui.theme.Purple40
import com.example.googlesignin.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoogleSigninTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GoogleSignIn(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun GoogleSignIn(modifier: Modifier = Modifier) {
    Column {
        Image(
            painter = painterResource(R.drawable.google_icon),
            contentDescription = "Google logo"
        )
        Text(
            text = "Sign In",
            fontFamily = FontFamily(Font(R.font.google_font)),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 32.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun GoogleSignInPreview() {
    GoogleSignIn()
}


/* @Composable
fun Greeting(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Text(
        text = "Hello Jetpack app!",
        color = Purple40,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        letterSpacing = 3.sp,
        modifier = modifier
            .padding(start = 32.dp, top = 64.dp)
            .background(Purple80, CircleShape)
            .padding(all = 16.dp)
            .clickable {
                Toast.makeText(context, "Clicked!", Toast.LENGTH_SHORT).show()
            }
    )
}

 

@Preview(showSystemUi = true, showBackground = false)
@Composable
fun GreetingPreview() {
    
}
*/