package com.nextgen.jetcoffeecompose.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nextgen.jetcoffeecompose.R
import com.nextgen.jetcoffeecompose.ui.theme.JetCoffeeComposeTheme

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
) {
    //remember -> beruabah ketika berubah orientasi
    //remembersaveable -> save instance ketika dirotasi -> sebaiknya hanya menampung data primitif
    var query by remember {
        mutableStateOf("")
    }
    TextField(
        value = query,
        onValueChange = {newQuery ->
            query= newQuery
        },
        leadingIcon= {
                     Icon(
                         imageVector = Icons.Default.Search ,
                         contentDescription = null)
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface,
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        placeholder = {
                      Text(
                          text = stringResource(id = R.string.placeholder_search) )
        },
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
            .heightIn(min = 48.dp)
            .clip(RoundedCornerShape(16.dp))
    )

}

@Preview
@Composable
fun SearchBarPreview() {
    JetCoffeeComposeTheme {
        SearchBar()
    }
    
}