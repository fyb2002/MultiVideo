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
    lateinit var subVideos : Array<VideoView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init VideoView objects.
        mainVideo.setVideoURI(Uri.parse(main_URL));

        subVideos = arrayOf(subVideo1, subVideo2, subVideo3)

        for(subVideo in subVideos) {
            subVideo.setVideoURI(Uri.parse(pip_URL))
            subVideo.setVisibility(View.INVISIBLE)

            // 이 방식으로도 되고
            subVideo.setZOrderOnTop(true)
        }

        // 아래 방식으로도 됨.
        //mainVideo.setZOrderMediaOverlay(false)
        //subVideo.setZOrderMediaOverlay(true)
    }

    override fun onStart() {
        mainVideo.start()

        super.onStart()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        for(subVideo in subVideos) {
            if (subVideo.visibility == View.VISIBLE) {
                subVideo.stopPlayback()
                subVideo.setVisibility(android.view.View.INVISIBLE)

            } else {
                subVideo.setVisibility(android.view.View.VISIBLE)
                subVideo.start()
            }
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