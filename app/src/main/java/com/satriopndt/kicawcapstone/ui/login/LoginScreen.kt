package com.satriopndt.kicawcapstone.ui.login

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.greenToska

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    modifier: Modifier = Modifier
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        val context = LocalContext.current

        var email by rememberSaveable {
            mutableStateOf("")
        }
        var password by rememberSaveable {
            mutableStateOf("")
        }

        var showPassword by remember {
            mutableStateOf(false)
        }

        val register = "Sign Up"
        val textRegister = buildAnnotatedString {
            append("Dont have an account? ")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
            ) {
                pushStringAnnotation(tag = register, annotation = register)
                append(register)
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_prikitiw),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .height(400.dp)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                            .rotate(360f)
                            .padding(20.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .padding(top = 10.dp)
                    ) {
                        Text(text = "Welcome to Kicaw..",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                    Text(text = "Start by Signing in First by Providing Your Email and Password",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Normal
                    )

                }
                /**
                 * Email text field
                 */
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { newEmail ->
                            email = newEmail
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .background(
                                color = colorResource(id = R.color.white),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .height(50.dp),
                        placeholder = {
                            Text(
                                text = "Email",
                                fontSize = 12.sp
                            )
                        },
                        shape = RoundedCornerShape(10.dp),
                        singleLine = true,
                    )

                }

                /*
                Password text field
                 */
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    OutlinedTextField(
                        value = password,
                        onValueChange = { newPass ->
                            password = newPass
                        },
                        modifier = Modifier
                            .padding(top = 20.dp)
                            .background(
                                color = colorResource(id = R.color.white),
                                shape = RoundedCornerShape(15.dp)
                            )
                            .height(50.dp),
                        placeholder = {
                            Text(
                                text = "Password",
                                fontSize = 12.sp,
                            )
                        },
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            if (showPassword){
                                IconButton(onClick = {showPassword = false}) {
                                    Icon(imageVector = Icons.Filled.Visibility,
                                        contentDescription = "hide_password")
                                }
                            }else {
                                IconButton(onClick = {showPassword = true}) {
                                    Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = "hide_password")
                                }
                            }
                        },
                        shape = RoundedCornerShape(10.dp),
                        maxLines = 1,
                    )

                    //ElevatedButton

                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 40.dp)
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(40.dp)
                            .padding(
                                start = 40.dp,
                                end = 40.dp
                            ),
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(containerColor = greenToska)
                    ) {
                        Text(
                            text = "Sign In"
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    ClickableText(
                        text = textRegister,
                        onClick = {
                            Toast.makeText(context, "menuju halaman register", Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }



        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    KicawCapstoneTheme {
        LoginScreen()
    }
}