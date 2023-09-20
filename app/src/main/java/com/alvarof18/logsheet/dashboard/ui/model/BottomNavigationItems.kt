package com.alvarof18.logsheet.dashboard.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.alvarof18.logsheet.R

sealed class BottomNavigationItems(@StringRes var title:Int, @DrawableRes var icon:Int){
    object PPU1:BottomNavigationItems(title = R.string.PPU1_title, icon = R.drawable.logsheets_icon )
    object SSGPP:BottomNavigationItems(title = R.string.SSGPP_title, icon = R.drawable.logsheets_icon )
}

val MyBottomNavigation = listOf(
    BottomNavigationItems.PPU1,
    BottomNavigationItems.SSGPP

)
