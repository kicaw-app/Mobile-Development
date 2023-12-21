package com.satriopndt.kicawcapstone.ui.home

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.ViewModelFactory
import com.satriopndt.kicawcapstone.di.Injection
import com.satriopndt.kicawcapstone.navigation.Screen
import com.satriopndt.kicawcapstone.ui.component.BirdItem
import com.satriopndt.kicawcapstone.ui.component.SearchBar
import com.satriopndt.kicawcapstone.ui.component.Welcome
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme
import com.satriopndt.kicawcapstone.ui.theme.blueBackground

@Composable
fun HomeScreen(
    context: Context = LocalContext.current,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository(context)
        ),
    ),
    navigateToDetail: (Long) -> Unit,
    navController: NavHostController,
) {
    val groupBirds by viewModel.groupBirds.collectAsState()
//    var query by remember {
//        mutableStateOf("")
//    }
    val query by viewModel.query

    var showMenu by remember {
        mutableStateOf(false)
    }


    Column(
        modifier = modifier.background(blueBackground)
    ) {

        TopAppBar(
            title = {},
            actions = {
                IconButton(onClick = { /*TODO*/ }
                ) {
                    Icon(imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",

                    )
                }
            },
            backgroundColor = blueBackground
        )

        Welcome(modifier = Modifier.background(blueBackground))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar(
                query = query,
                onQueryChange = viewModel::Search
            );
            IconButton(
                modifier = Modifier

                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White),
                onClick = { navController.navigate(Screen.History.route) }) {
                Icon(
                    modifier = Modifier
                        .size(50.dp),
                    imageVector = Icons.Default.History,
                    contentDescription = "History",

                    )
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(90.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
        ) {
            groupBirds.forEach { _, kicawModels ->
                items(kicawModels) {
                    BirdItem(
                        photoUrl = it.photoUrl,
                        name = it.name,
                        onClick = {navController.navigate(Screen.DetailBirds.route)})
                }
            }

        }

    }
}

//@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
//@Composable
//fun HomeContent(
//    orderBird: List<OrderBird>,
//    modifier: Modifier = Modifier,
//    navigateToDetail: (Long) -> Unit,
//    navController: NavHostController
//) {
//
//    Surface(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)
//            .padding()
//    ) {
//
//        Column(
//            modifier = Modifier
//        ) {
//            Welcome()
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                SearchBar(query = "",
//                    onQueryChanged = {})
//                IconButton(
//                    modifier = Modifier
//                        .size(50.dp)
//                        .clip(RoundedCornerShape(12.dp)),
////                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
//                    onClick = { navController.navigate(Screen.History.route) }) {
//                    Icon(
//                        modifier = Modifier
//                            .size(35.dp),
//                        imageVector = Icons.Default.History,
//                        contentDescription = "History",
//
//                        )
//                }
//            }
//            LazyVerticalGrid(
//                columns = GridCells.Adaptive(90.dp),
//                contentPadding = PaddingValues(16.dp),
//                horizontalArrangement = Arrangement.spacedBy(16.dp),
//                verticalArrangement = Arrangement.spacedBy(16.dp),
//                modifier = modifier
//            ) {
//                items(orderBird) { data ->
//                    BirdItem(
//                        photoUrl = data.kicawModel.photoUrl,
//                        name = data.kicawModel.name,
//                        modifier = Modifier.clickable {
//                            navController.navigate(Screen.DetailBirds.route)
//                        }
//                    )
//                }
//            }
//        }
//
//
//    }
//}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    KicawCapstoneTheme {
        HomeScreen(navigateToDetail = {}, navController = rememberNavController())
    }
}