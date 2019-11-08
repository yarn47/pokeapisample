package com.yap.pokedex_android.ui

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.yap.pokedex_android.common.BaseActivity
import com.yap.pokedex_android.ui.search.SearchActivity
import com.yarn.pokedex_android.R
import com.yarn.pokedex_android.databinding.ActivitySplashBinding

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activitySplashBinding : ActivitySplashBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_splash)

        // 일단은
        activitySplashBinding.root.postDelayed({
            startActivity(Intent(this, SearchActivity::class.java))
            finish()
        }, 3000)
    }
}
