package com.satriopndt.kicawcapstone.ui.discuss

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.history.HistoryScreen
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscussScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(title = {
            androidx.compose.material.Text(
                text = stringResource(id = R.string.discuss_screen),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            androidx.compose.material.Icon(imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = stringResource(
                    id = R.string.btn_back
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { navController.navigate(Screen.Home.route) })
        })
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(Color.White, shape = RoundedCornerShape(16.dp))
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                TextField(
                    value = title,
                    onValueChange = { title = it },
                    label = { Text(text = "Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text(text = "Description") },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
        Button(
            onClick = { /* TODO: Create logic for add discussion */ },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
                .background(Color(0xFF079AA4), shape = RoundedCornerShape(15.dp))
        ) {
            Text(text = "Add", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiscussScreenPreview() {
    KicawCapstoneTheme {
        DiscussScreen(navController = rememberNavController())
    }
}
