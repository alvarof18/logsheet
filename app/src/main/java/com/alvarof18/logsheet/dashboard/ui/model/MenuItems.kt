package com.alvarof18.logsheet.dashboard.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alvarof18.logsheet.R

data class MenuItems(@DrawableRes val icon: Int = 0, @StringRes val title: Int = 0)

val getItemsMenu = listOf<MenuItems>(
    MenuItems(icon = R.drawable.dashboard_menu_item, title = R.string.dashboard_title),
    MenuItems(icon = R.drawable.measure_menu_item, title = R.string.measure_title)
)
