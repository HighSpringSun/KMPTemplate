package com.kmpstudy.di


import org.kodein.di.DI


val dataModule = DI.Module("dataModule") {
    // Define your data layer dependencies here
    // For example:
    // bind<YourRepository>() with singleton { YourRepositoryImpl(instance()) }
    // 数据库实例

}