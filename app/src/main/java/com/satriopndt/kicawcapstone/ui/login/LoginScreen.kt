package com.satriopndt.kicawcapstone.ui.login

import android.content.Context
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ViewModelFactory
import com.satriopndt.kicawcapstone.data.UserModel
import com.satriopndt.kicawcapstone.di.Injection
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.helper.UiState
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.blueBackground
import com.satriopndt.kicawcapstone.ui.theme.greenToska

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context))
    ),
    navigateToHome: () -> Unit

) {

    val scrollStateVertical = rememberScrollState()

    Surface(
        modifier = Modifier

            .fillMaxSize()
            .background(blueBackground)
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

        var showLoading by remember {
            mutableStateOf(false)
        }
        val uploadState by viewModel.upload.observeAsState()
        val focusRequester = remember {
            FocusRequester()
        }
        var isFocused by remember {
            mutableStateOf(false)
        }
        val wasFocused = remember {
            isFocused
        }

        when (val uiState = uploadState) {
            is UiState.Loading -> {
                showLoading = true
            }

            is UiState.Success -> {
                showLoading = true
                viewModel.saveSession(
                    UserModel(
                        uiState.data.data.token,
                        "",
                        "",
                        true
                    )
                )
                navigateToHome()
            }

            is UiState.Error -> {
                showLoading = false
                Toast.makeText(context, "Password atau Email salah", Toast.LENGTH_SHORT).show()
            }

            else -> {}
        }

        LaunchedEffect(key1 = true) {
            if (wasFocused) {
                focusRequester.requestFocus()
            }
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollStateVertical)
                .background(blueBackground)
        ) {
            Column(
                modifier = Modifier.padding(28.dp),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.logo_prikitiw),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = modifier
                            .height(300.dp)
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
                        Text(
                            text = "Welcome to Kicaw..",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                    Text(
                        text = "Start by Signing in First by Providing Your Email and Password",
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
                    val containerColor = colorResource(id = R.color.lavender)
                    androidx.compose.material3.OutlinedTextField(
                        value = viewModel.email,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = containerColor,
                            unfocusedContainerColor = containerColor,
                            disabledContainerColor = containerColor
                        ),
                        label = { Text(text = "Email") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        onValueChange = { newEmail ->
                            viewModel.email = newEmail
                        },
                        modifier = Modifier
                            .padding(top = 20.dp)
//                            .background(
//                                color = colorResource(id = R.color.white),
//                                shape = RoundedCornerShape(15.dp)
//                            )
//                            .height(50.dp)
                            .focusRequester(focusRequester)
                            .onFocusChanged {
                                isFocused = it.isFocused
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
                    val containerColor1 = colorResource(id = R.color.lavender)
                    OutlinedTextField(
                        value = viewModel.password,
                        onValueChange = { newPass ->
                            viewModel.password = newPass
                        },
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedContainerColor = containerColor1,
                            unfocusedContainerColor = containerColor1,
                            disabledContainerColor = containerColor1,
                        ),
                        label = { Text(text = "Password")},
                        modifier = Modifier
                            .padding(top = 20.dp)
//                            .background(
//                                color = colorResource(id = R.color.white),
//                                shape = RoundedCornerShape(15.dp),
//                            )
//                            .height(50.dp)
                            .focusRequester(focusRequester)
                            .onFocusChanged {
                                isFocused = it.isFocused
                            },
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            if (showPassword) {
                                androidx.compose.material3.IconButton(onClick = {
                                    showPassword = false
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.Visibility,
                                        contentDescription = "hide_password"
                                    )

                                }
                            } else {
                                androidx.compose.material3.IconButton(onClick = {
                                    showPassword = true
                                }) {
                                    Icon(
                                        imageVector = Icons.Filled.VisibilityOff,
                                        contentDescription = "hide_password"
                                    )
                                }
                            }
                        },
                        shape = RoundedCornerShape(10.dp),
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )


                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(top = 40.dp)
                ) {
                    ElevatedButton(
                        modifier = Modifier
                            .fillMaxWidth(1f)
                            .height(40.dp)
                            .padding(
                                start = 40.dp,
                                end = 40.dp
                            ),
                        onClick = {
                            if (viewModel.password.length < 8) {
                                Toast.makeText(
                                    context,
                                    "Password kurang dari 8",
                                    Toast.LENGTH_SHORT
                                ).show()
                                return@ElevatedButton
                            }

                            viewModel.login(viewModel.email, viewModel.password)
                        },
                        colors = ButtonDefaults.elevatedButtonColors(containerColor = greenToska)
                    ) {
//                        if (showLoading){
//                            CircularProgressIndicator(
//                                modifier = Modifier.size(20.dp),
//                                color = Color.Black
//                            )
//                        } else{
                            Text(
                                text = "Sign In",
                                color = colorResource(id = R.color.white),

                            )
//                        }

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
                            navController.navigate(Screen.SignUp.route) {
                                popUpTo(0)
                            }
                            Toast.makeText(context, "menuju halaman register", Toast.LENGTH_SHORT)
                                .show()
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
        LoginScreen(navController = rememberNavController(),
            navigateToHome = {})
    }
}