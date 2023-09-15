package com.alvarof18.logsheet.config

sealed class Routes(val route:String){
    object LoginScreenNav:Routes("login")
    object DashboardScreenNav:Routes("dashboard")
    object SSGPPScreenNav:Routes("ssgpp")
}

sealed class MainRoutes(val routes:String){
    object LoginGraph:Routes("LoginGraph")
    object DashboardGraph:Routes("DashboardGraph")

}
