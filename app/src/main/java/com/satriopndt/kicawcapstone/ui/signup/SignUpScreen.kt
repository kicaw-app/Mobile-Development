package com.satriopndt.kicawcapstone.ui.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.satriopndt.kicawcapstone.R.*
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.greenToska

@Composable
fun SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        var name by rememberSaveable {
            mutableStateOf("")
        }

        var username by rememberSaveable {
            mutableStateOf("")
        }

        var email by rememberSaveable {
            mutableStateOf("")
        }

        var password by rememberSaveable {
            mutableStateOf("")
        }

        var showPassword by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f)
                .background(colorResource(id = color.white))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 50.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier
                        .padding(50.dp)
                        .size(175.dp),
                    painter = painterResource(id = drawable.logo_prikitiw),
                    contentDescription = "Logo App"
                )
            }

            /*
            Name TExt Field
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = name,
                    onValueChange = { newUser ->
                        name = newUser
                    },
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .background(
                            color = colorResource(id = color.white),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .height(50.dp),
                    placeholder = {
                        Text(
                            text = "Name",
                            fontSize = 12.sp,
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    maxLines = 1,
                )
            }

            /*
            Username Text Field
             */
            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(),
                horizontalArrangement = Arrangement.Center
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { newUsername ->
                        username = newUsername
                    },
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .background(
                            color = colorResource(id = color.white),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .height(50.dp),
                    placeholder = {
                        Text(
                            text = "Username",
                            fontSize = 12.sp,
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    maxLines = 1,
                )

            }

            /*
            Email Text Field
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
                    modifier = Modifier
                        .padding(top = 15.dp)
                        .background(
                            color = colorResource(id = color.white),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .height(50.dp),
                    placeholder = {
                        Text(
                            text = "Email",
                            fontSize = 12.sp
                        )
                    },
                    shape = RoundedCornerShape(15.dp),
                    maxLines = 1,
                )
            }

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
                        .padding(top = 15.dp)
                        .background(
                            color = colorResource(id = color.white),
                            shape = RoundedCornerShape(15.dp)
                        )
                        .height(50.dp),
                    placeholder = {
                        Text(
                            text = "Password",
                            fontSize = 12.sp
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
                    shape = RoundedCornerShape(15.dp),
                    maxLines = 1,
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    modifier = Modifier
                        .width(200.dp),
                    onClick = {
                      
                    },
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = greenToska)

                ) {
                    Text(text = "Create",
                        color = colorResource(id = color.white),
                        modifier = Modifier
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview() {
    KicawCapstoneTheme {
        SignUpScreen()
    }
}