    package com.satriopndt.kicawcapstone.ui.signup

import android.content.Context
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.R.*
import com.satriopndt.kicawcapstone.ViewModelFactory
import com.satriopndt.kicawcapstone.di.Injection
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.helper.UiState
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.blueBackground
import com.satriopndt.kicawcapstone.ui.theme.greenToska

@Composable
fun SignUpScreen(
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: SignUpVIewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context))
    )
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(blueBackground)
            .padding(28.dp)
    ) {
//        var name by rememberSaveable {
//            mutableStateOf("")
//        }
//
//        var username by rememberSaveable {
//            mutableStateOf("")
//        }
//
//        var email by rememberSaveable {
//            mutableStateOf("")
//        }
//
//        var password by rememberSaveable {
//            mutableStateOf("")
//        }

        var showPassword by remember {
            mutableStateOf(false)
        }

        val focusRequester = remember { FocusRequester() }
        var isFocused by remember { mutableStateOf(false) }
        val wasFocused = remember { isFocused }

        val scrollStateVertical = rememberScrollState()

        val containerColor = colorResource(id = R.color.lavender)
        LaunchedEffect(true) {
            if (wasFocused) {
                focusRequester.requestFocus()
            }
        }

        val uploadState by viewModel.upload.observeAsState()

        when (val uiState = uploadState) {
            is UiState.Loading -> {

            }

            is UiState.Success -> {
                navController.navigate(Screen.Login.route) {
                    popUpTo(0)
                }
            }

            is UiState.Error -> {

            }

            else -> {}
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollStateVertical)
                .background(blueBackground)
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
                androidx.compose.material3.OutlinedTextField(
                    value = viewModel.name,
                    onValueChange = { newUser ->
                        viewModel.name = newUser
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = containerColor,
                        unfocusedContainerColor = containerColor,
                        disabledContainerColor = containerColor,
                    ),
                    modifier = Modifier
                        .padding(top = 20.dp)
//                        .background(
//                            color = colorResource(id = color.white),
//                            shape = RoundedCornerShape(15.dp)
//                        )
//                        .height(50.dp),
                        .focusRequester(focusRequester)
                        .onFocusChanged {
                            isFocused = it.isFocused
                        },
                    label = { Text(text = "Name") },
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
                androidx.compose.material3.OutlinedTextField(
                    value = viewModel.username,
                    onValueChange = { newUsername ->
                        viewModel.username = newUsername
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = containerColor,
                        unfocusedContainerColor = containerColor,
                        disabledContainerColor = containerColor,
                    ),
                    modifier = Modifier
                        .padding(top = 15.dp)
//                        .background(
//                            color = colorResource(id = color.white),
//                            shape = RoundedCornerShape(15.dp)
//                        )
//                        .height(50.dp),
                        .focusRequester(focusRequester)
                        .onFocusChanged {
                            isFocused = it.isFocused
                        },
                    label = { Text(text = "Username") },
                    shape = RoundedCornerShape(15.dp),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
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
                androidx.compose.material3.OutlinedTextField(
                    value = viewModel.email,
                    onValueChange = { newEmail ->
                        viewModel.email = newEmail
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = containerColor,
                        unfocusedContainerColor = containerColor,
                        disabledContainerColor = containerColor,
                    ),
                    modifier = Modifier
                        .padding(top = 15.dp)
//                        .background(
//                            color = colorResource(id = color.white),
//                            shape = RoundedCornerShape(15.dp)
//                        )
//                        .height(50.dp)
                        .focusRequester(focusRequester)
                        .onFocusChanged {
                            isFocused = it.isFocused
                        },
                    label = { Text(text = "Email") },
                    shape = RoundedCornerShape(15.dp),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .padding(),
                horizontalArrangement = Arrangement.Center
            ) {
                androidx.compose.material3.OutlinedTextField(
                    value = viewModel.password,
                    onValueChange = { newPass ->
                        viewModel.password = newPass
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = containerColor,
                        unfocusedContainerColor = containerColor,
                        disabledContainerColor = containerColor,
                    ),
                    modifier = Modifier
                        .padding(top = 15.dp)
//                        .background(
//                            color = colorResource(id = color.white),
//                            shape = RoundedCornerShape(15.dp)
//                        )
//                        .height(50.dp)
                        .focusRequester(focusRequester)
                        .onFocusChanged { //restore keyboard while rotation
                            isFocused = it.isFocused
                        },
                    label = { Text(text = "Password") },
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        if (showPassword) {
                            IconButton(onClick = { showPassword = false }) {
                                Icon(
                                    imageVector = Icons.Filled.Visibility,
                                    contentDescription = "hide_password"
                                )
                            }
                        } else {
                            IconButton(onClick = { showPassword = true }) {
                                Icon(
                                    imageVector = Icons.Filled.VisibilityOff,
                                    contentDescription = "hide_password"
                                )
                            }
                        }
                    },
                    shape = RoundedCornerShape(15.dp),
                    maxLines = 1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
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
                        viewModel.uploadData(
                            viewModel.name,
                            viewModel.username,
                            viewModel.email,
                            viewModel.password
                        )

                    },
                    shape = RoundedCornerShape(15.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = greenToska)

                ) {
                    Text(
                        text = "Create",
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
        SignUpScreen(navController = rememberNavController())
    }
}