package com.satriopndt.kicawcapstone.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.satriopndt.kicawcapstone.R
import com.satriopndt.kicawcapstone.ui.theme.KicawCapstoneTheme

@Composable
fun SearchBar(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
){

    TextField(
        value = query,
        onValueChange = onQueryChange,
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search"
            )
        },
        placeholder = {
            Text(stringResource(R.string.search_bird))
        },
        modifier = modifier
            .padding(16.dp)
            .width(295.dp)
            .clip(RoundedCornerShape(15.dp))
            .testTag("Search")
    )
}

@Preview
@Composable
fun SearchBarPreview(){
    KicawCapstoneTheme {
        SearchBar(
            query = "",
            onQueryChange = {}
        )
    }
}