package com.kmpstudy.di


import org.kodein.di.DI

val appModule = DI.Module("appModule") {
    import(dataModule)
    import(networkModule)
    import(repoModule)
    import(viewmodelModule)
}

//val commonDI by DI.lazy {
//    import(appModule)
//}
