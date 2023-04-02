package com.nzdevelope009.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/*
* we use modifier = Modifier.verticalScroll(rememberScrollState()) but it list all in one time
* in jetpack compose, recycle-able list to implement we use LazyColumn for vertical list and
* LazyRow for horizontal List show
*
* */

@Preview(heightDp = 500)
@Composable
fun previewItem() {
    /* Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
         getCategoryList().map { item ->
             BlogCategory(imgId = item.img, title = item.title, subtitle = item.subtitle)
         }
     }*/
    /*
    * Here list is render, where item is loading Lazyly
    * */
    LazyColumn(content = {
        items(getCategoryList()) { item ->
            BlogCategory(imgId = item.img, title = item.title, subtitle = item.subtitle)
        }
    })

}

@Composable
fun BlogCategory(imgId: Int, title: String, subtitle: String) {
    Card(elevation = 8.dp, modifier = Modifier.padding(8.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(
                    id = imgId
                ),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            itemDescription(title, subtitle, Modifier.weight(.8f))
        }
    }
}

@Composable
fun itemDescription(title: String, subtitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.subtitle1,
            fontWeight = FontWeight.Thin
        )
    }
}

data class Category(val img: Int, val title: String, val subtitle: String)


fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.ic_person_pin, "Programming", "Learn Different Languages"))
    list.add(Category(R.drawable.ic_person_pin, "Technology", "News About new Tech"))
    list.add(
        Category(
            R.drawable.ic_person_pin,
            "Full Stack Development",
            "From Backend to FrontEnd"
        )
    )
    list.add(Category(R.drawable.ic_person_pin, "DevOps", "Deployment, CI, CD etc,"))
    list.add(Category(R.drawable.ic_person_pin, "AI & ML", "Basic Artificial Intelligence"))
    list.add(Category(R.drawable.ic_person_pin, "Programming", "Learn Different Languages"))
    list.add(Category(R.drawable.ic_person_pin, "Technology", "News About new Tech"))
    list.add(
        Category(
            R.drawable.ic_person_pin,
            "Full Stack Development",
            "From Backend to FrontEnd"
        )
    )
    list.add(Category(R.drawable.ic_person_pin, "DevOps", "Deployment, CI, CD etc,"))
    list.add(Category(R.drawable.ic_person_pin, "AI & ML", "Basic Artificial Intelligence"))
    list.add(Category(R.drawable.ic_person_pin, "Programming", "Learn Different Languages"))
    list.add(Category(R.drawable.ic_person_pin, "Technology", "News About new Tech"))
    list.add(
        Category(
            R.drawable.ic_person_pin,
            "Full Stack Development",
            "From Backend to FrontEnd"
        )
    )
    list.add(Category(R.drawable.ic_person_pin, "DevOps", "Deployment, CI, CD etc,"))
    list.add(Category(R.drawable.ic_person_pin, "AI & ML", "Basic Artificial Intelligence"))
    list.add(Category(R.drawable.ic_person_pin, "Programming", "Learn Different Languages"))
    list.add(Category(R.drawable.ic_person_pin, "Technology", "News About new Tech"))
    list.add(
        Category(
            R.drawable.ic_person_pin,
            "Full Stack Development",
            "From Backend to FrontEnd"
        )
    )
    list.add(Category(R.drawable.ic_person_pin, "DevOps", "Deployment, CI, CD etc,"))
    list.add(Category(R.drawable.ic_person_pin, "AI & ML", "Basic Artificial Intelligence"))

    return list
}