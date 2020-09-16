package com.example.multivideo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.widget.VideoView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val main_URL = "https://vt.tumblr.com/tumblr_o600t8hzf51qcbnq0_480.mp4"
    val pip_URL = "https://vt.tumblr.com/tumblr_o600t8hzf51qcbnq0_480.mp4"//"http://techslides.com/demos/sample-videos/small.mp4"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init VideoView objects.
        mainVideo.setVideoURI(Uri.parse(main_URL));
        pipVideo.setVideoURI(Uri.parse(pip_URL));

        pipVideo.setVisibility(android.view.View.INVISIBLE)

        // 이 방식으로도 되고,
        pipVideo. setZOrderOnTop(true)

        // 아래 방식으로도 됨.
        //mainVideo.setZOrderMediaOverlay(false)
        //pipVideo.setZOrderMediaOverlay(true)
    }

    override fun onStart() {
        mainVideo.start()

        super.onStart()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if(pipVideo.visibility == View.VISIBLE) {

            Log.v("SLEE","s.lee : pip = visible !  so goto invisible and stop ! ")
            pipVideo.stopPlayback()
            pipVideo.setVisibility(android.view.View.INVISIBLE)

        }
        else {
            Log.v("SLEE","s.lee : pip = invisible !  so goto visible  and start ! ")
            pipVideo.setVisibility(android.view.View.VISIBLE)
            pipVideo.start()
        }

        return super.onTouchEvent(event)
    }

    /*
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if(pipVideo.visibility == View.VISIBLE) {
            pipVideo.stopPlayback()
            pipVideo.setVisibility(android.view.View.INVISIBLE)

        }
        else {
            pipVideo.setVisibility(android.view.View.VISIBLE)
            pipVideo.start()
        }

        return super.onKeyDown(keyCode, event)
    }
    */
}