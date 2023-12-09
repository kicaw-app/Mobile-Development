package com.satriopndt.kicawcapstone.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.History
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ViewModelFactory
import com.satriopndt.kicawcapstone.di.Injection
import com.satriopndt.kicawcapstone.model.OrderBird
import com.satriopndt.kicawcapstone.ui.component.BirdItem
import com.satriopndt.kicawcapstone.ui.component.BottomBar
import com.satriopndt.kicawcapstone.ui.component.SearchBar
import com.satriopndt.kicawcapstone.ui.component.Welcome
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = ViewModelFactory(
            Injection.provideRepository()
        ),
    ),
    navigateToDetail: (Long) -> Unit,
) {
    val groupBirds by viewModel.groupBirds.collectAsState()
    val query by viewModel.query

    Column(
        modifier = modifier
    ) {
        Welcome()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SearchBar(
                query = query,
                onQueryChanged = viewModel::Search
            );
            IconButton(
                modifier = Modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(12.dp)),
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                onClick = { /*TODO*/ }) {
                Icon(
                    modifier = Modifier
                        .size(35.dp),
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
                    BirdItem(photoUrl = it.photoUrl,
                        name = it.name,
                        modifier.clickable { navigateToDetail(it.id) })
                }
            }

        }

    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeContent(
    orderBird: List<OrderBird>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding()
    ) {

        Column(
            modifier = Modifier
        ) {
            Welcome()
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SearchBar(query = "",
                    onQueryChanged = {})
                IconButton(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(12.dp)),
//                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                    onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier
                            .size(35.dp),
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
                items(orderBird) { data ->
                    BirdItem(
                        photoUrl = data.kicawModel.photoUrl,
                        name = data.kicawModel.name,
                        modifier = Modifier.clickable {
                            navigateToDetail(data.kicawModel.id)
                        }
                    )
                }
            }
        }


    }
}


//@Preview(showBackground = true)
//@Composable
//fun HomeScreenPreview() {
//    KicawCapstoneTheme {
//        HomeContent()
//    }
//}