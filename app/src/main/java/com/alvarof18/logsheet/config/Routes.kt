package com.alvarof18.logsheet.config

sealed class Routes(val route:String){
    object LoginScreenNav:Routes("login")
    object DashboardScreenNav:Routes("dashboard")
    object SSGPPScreenNav:Routes("ssgpp")
    object GeneratorParm:Routes("generator_control_parameter")
    object CondensingSystem:Routes("condensing_system")
    object SteamTurbineParameters:Routes("steam_turbine")
    object BOPElectrical:Routes("bop")
    object FieldMainProcess:Routes("field_main_process")
}

sealed class MainRoutes(val routes:String){
    object LoginGraph:Routes("LoginGraph")
    object DashboardGraph:Routes("DashboardGraph")
    object SSGPPGraph:Routes("SSGPPGraph")

}

