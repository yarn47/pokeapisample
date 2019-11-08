package com.yap.pokedex_android.common

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.BroadcastReceiver
import android.content.ContentProvider
import androidx.fragment.app.Fragment
import androidx.multidex.MultiDexApplication
import com.google.errorprone.annotations.ForOverride
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

abstract class BaseApplication : MultiDexApplication(), HasActivityInjector,
    HasSupportFragmentInjector,
    HasServiceInjector,
    HasBroadcastReceiverInjector,
    HasContentProviderInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var broadcastReceiverInjector: DispatchingAndroidInjector<BroadcastReceiver>
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var serviceInjector: DispatchingAndroidInjector<Service>
    @Inject
    lateinit var contentProviderInjector: DispatchingAndroidInjector<ContentProvider>
    @Volatile
    private var needToInject = true

    override fun onCreate() {
        super.onCreate()
        injectIfNecessary()
    }

    /**
     * Implementations should return an [AndroidInjector] for the concrete [ ]. Typically, that injector is a [dagger.Component].
     */
    @ForOverride
    protected abstract fun applicationInjector(): AndroidInjector<out BaseApplication>

    /**
     * Lazily injects the [DaggerApplication]'s members. Injection cannot be performed in [ ][Application.onCreate] since [android.content.ContentProvider]s' [ ][android.content.ContentProvider.onCreate] method will be called first and might
     * need injected members on the application. Injection is not performed in the constructor, as
     * that may result in members-injection methods being called before the constructor has completed,
     * allowing for a partially-constructed instance to escape.
     */
    private fun injectIfNecessary() {
        if (needToInject) {
            synchronized(this) {
                if (needToInject) {
                    val applicationInjector =
                        applicationInjector() as AndroidInjector<BaseApplication>
                    applicationInjector.inject(this)
                    if (needToInject) {
                        throw IllegalStateException(
                            "The AndroidInjector returned from applicationInjector() did not inject the " + "DaggerApplication"
                        )
                    }
                }
            }
        }
    }

    @Inject
    internal fun setInjected() {
        needToInject = false
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return activityInjector
    }


    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment> {
        return fragmentInjector
    }

    override fun broadcastReceiverInjector(): DispatchingAndroidInjector<BroadcastReceiver> {
        return broadcastReceiverInjector
    }

    override fun serviceInjector(): DispatchingAndroidInjector<Service> {
        return serviceInjector
    }

    // injectIfNecessary is called here but not on the other *Injector() methods because it is the
    // only one that should be called (in AndroidInjection.inject(ContentProvider)) before
    // Application.onCreate()
    override fun contentProviderInjector(): AndroidInjector<ContentProvider> {
        injectIfNecessary()
        return contentProviderInjector
    }
}
