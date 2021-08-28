package com.migc.jethinge.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.migc.jethinge.R
import com.migc.jethinge.ui.utils.Conversions.toDp

@Composable
fun PhotosGrid() {
    val gridTitle = stringResource(id = R.string.edit_photos_list_title)
    val numColumns = integerResource(id = R.integer.photos_grid_number_columns)
    val numRows = integerResource(id = R.integer.photos_grid_number_rows)
    val currentContext = LocalContext.current
    var gridWidth by remember { mutableStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .onGloballyPositioned {
                gridWidth = it.size.width.toDp(currentContext) / numColumns
            }
    ) {
        Text(
            text = gridTitle,
            modifier = Modifier.padding(start = 12.dp, top = 36.dp),
            color = Color.Gray
        )
        LazyColumn {
            items(numRows) {
                Row {
                    for (i in 0 until numColumns) {
                        PhotoListItem(gridWidth.dp)
                    }
                }
            }
        }
    }

}

@Composable
fun PhotoListItem(gridWidth: Dp) {
    Box(
        modifier = Modifier.size(gridWidth)
    ) {
        Image(
            ColorPainter(Color.Gray),
            contentDescription = "content description",
            modifier = Modifier
                .padding(4.dp)
                .clip(RoundedCornerShape(4.dp))
                .align(Alignment.Center)
        )
        CircledClose(
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

@Composable
fun CircledClose(modifier: Modifier) {
    OutlinedButton(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .size(30.dp)
            .then(modifier),
        shape = CircleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        Icon(Icons.Default.Close, contentDescription = "content description", tint = Color.Black)
    }
}