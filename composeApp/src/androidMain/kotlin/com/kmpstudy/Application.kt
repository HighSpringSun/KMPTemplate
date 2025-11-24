package com.kmpstudy

import android.app.Application
import com.kmpstudy.di.appModule
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.androidCoreModule
import org.kodein.di.android.x.androidXModule

class Application : Application(), DIAware {

    override val di: DI = DI.lazy {
        import(androidCoreModule(this@Application))
        import(androidXModule(this@Application))
        import(appModule)
    }

    override fun onCreate() {
        super.onCreate()
        // Initialize things here if needed
        ContextProvider.init(this)
    }
}