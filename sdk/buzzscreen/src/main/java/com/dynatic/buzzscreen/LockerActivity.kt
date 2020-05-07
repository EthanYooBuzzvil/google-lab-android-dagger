package com.dynatic.buzzscreen

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.dynatic.lockscreen.Lockscreen
import javax.inject.Inject

class LockerActivity : AppCompatActivity() {

    @Inject
    lateinit var lockscreen: Lockscreen

    override fun onCreate(savedInstanceState: Bundle?) {
        BuzzScreen.getInstance().buzzScreenComponent.inject(this)

        super.onCreate(savedInstanceState)

        lockscreen.init()

        setContentView(
            LinearLayout(this).apply {
                addView(lockscreen.inflateView(this@LockerActivity))
            }
        )
    }

    override fun onDestroy() {

        lockscreen.release()

        super.onDestroy()
    }
}
