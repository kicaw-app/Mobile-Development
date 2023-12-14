package com.satriopndt.kicawcapstone.ui.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
import com.satriopndt.kicawcapstone.ui.component.HistoryCard
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,

) {
//    val groupBirds: StateFlow<Map<Char, List<KicawModel>>> get() = _groupHistory

    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(title = {
            Text(
                text = stringResource(id = R.string.history_screen),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                textAlign = TextAlign.Center
            )
            Icon(imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = stringResource(
                    id = R.string.btn_back
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { navController.navigate(Screen.Home.route) })
        }
        )
        HistoryCard()
//        LazyColumn(modifier = Modifier,
//            contentPadding = PaddingValues(vertical = 8.dp))
//        {
//
//        }

    }
}

@Preview(showBackground = true)
@Composable
fun HistoryScreenPreview() {
    KicawCapstoneTheme {
        HistoryScreen(navController = rememberNavController())
    }
}
