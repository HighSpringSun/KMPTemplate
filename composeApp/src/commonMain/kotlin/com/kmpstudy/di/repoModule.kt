package com.kmpstudy.di

import org.kodein.di.DI


val repoModule = DI.Module("repoModule") {
    // Repositories can be bound here
    // Repository 实例 - 使用 bindSingleton，因为 Repository 本身不依赖平台特定资源
}