package com.migc.jethinge.ui.components

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.unit.dp


@Composable
fun EditAppBar() {
    TopAppBar(
        modifier = Modifier.height(100.dp),
        content = { EditAppBarRow() },
        elevation = 4.dp
    )
}

@Composable
private fun EditAppBarRow() {
    Column {
        Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
            IconButton(
                onClick = { /*TODO*/ },
                content = {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = "Return Previous Screen"
                    )
                }
            )
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {
                Text(text = "name")
                Text(text = "100% Complete")
            }
        }
        TopTabs()
    }
}

@Composable
private fun TopTabs() {
    var tabIndex by remember { mutableStateOf(0) }
    val tabData = Tabs.values()

    TabRow(
        modifier = Modifier.padding(end = 200.dp),
        selectedTabIndex = tabIndex,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.customTabIndicatorOffset(tabPositions[tabIndex])
            )
        }
    ) {
        tabData.forEachIndexed { index, title ->
            Tab(
                selected = tabIndex == index,
                onClick = {
                    tabIndex = index
                    Log.d("TopTabs", "tabIndex = index: $tabIndex")
                },
                text = {
                    Text(
                        text = title.title
                    )
                }
            )

        }
    }
}

fun Modifier.customTabIndicatorOffset(currentTabPosition: TabPosition): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "mTabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val indicatorWidth = 32.dp
    val currentTabWidth = currentTabPosition.width
    val indicatorOffset by animateDpAsState(
        // https://developer.android.com/reference/kotlin/androidx/compose/ui/Modifier#(androidx.compose.ui.Modifier).composed(kotlin.Function1,kotlin.Function1)
        targetValue = currentTabPosition.left + currentTabWidth / 2 - indicatorWidth / 2,
        animationSpec = tween(durationMillis = 350)
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset(x = indicatorOffset)
        .width(indicatorWidth)
}

private enum class Tabs(val title: String) {
    Edit("Edit"),
    View("View")
}


