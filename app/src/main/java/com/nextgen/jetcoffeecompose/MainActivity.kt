package com.nextgen.jetcoffeecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nextgen.jetcoffeecompose.model.Menu
import com.nextgen.jetcoffeecompose.model.dummyBestSeller
import com.nextgen.jetcoffeecompose.model.dummyCategory
import com.nextgen.jetcoffeecompose.model.dummyMenu
import com.nextgen.jetcoffeecompose.ui.component.CategoryItem
import com.nextgen.jetcoffeecompose.ui.component.MenuItem
import com.nextgen.jetcoffeecompose.ui.component.SearchBar
import com.nextgen.jetcoffeecompose.ui.component.SectionText
import com.nextgen.jetcoffeecompose.ui.theme.JetCoffeeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeComposeTheme {
                    JetCoffeeApp()
            }
        }
    }
}

@Composable
fun JetCoffeeApp() {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        Banner()
        SectionText(title = stringResource(id = R.string.section_category))
        CategoryRow()
        SectionText(title = stringResource(id = R.string.section_favorite_menu))
        MenuRow(listMenu = dummyMenu)
        SectionText(title = stringResource(id = R.string.section_best_seller_menu))
        MenuRow(listMenu = dummyBestSeller)
    }
    
}

@Composable
fun Banner(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier){
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = modifier.height(160.dp)
        )
        SearchBar()
    }
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier =  modifier.padding(16.dp)
    ){
        items(dummyCategory, key = {it.textCategory}){category->
            CategoryItem(category = category)
        }
    }


}

@Composable
fun MenuRow(
    listMenu: List<Menu>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ){
        items(listMenu, key = {it.name}){menu->
            MenuItem(menu = menu)
            
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetCoffeeComposeTheme {
        JetCoffeeApp()
    }
}