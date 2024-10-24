package com.example.application

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.application.databinding.ActivityMainBinding
import eightbitlab.com.blurview.RenderScriptBlur
import jp.co.cyberagent.android.gpuimage.GPUImage
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBoxBlurFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageBrightnessFilter
import jp.co.cyberagent.android.gpuimage.filter.GPUImageFilterGroup

class MainActivity : AppCompatActivity() {
        lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        val radius = 7f

        val decorView = window.decorView
// ViewGroup you want to start blur from. Choose root as close to BlurView in hierarchy as possible.
        val rootView = decorView.findViewById<ViewGroup>(android.R.id.content)

// Optional: Set drawable to draw in the beginning of each blurred frame.
// Can be used in case your layout has a lot of transparent space and your content
// gets a too low alpha value after blur is applied.
        val windowBackground = decorView.background

        binding.blurView.setupWith(rootView, RenderScriptBlur(this)) // or RenderEffectBlur
            .setFrameClearDrawable(windowBackground) // Optional
            .setBlurRadius(radius)



        binding.relativeTitle.setupWith(rootView, RenderScriptBlur(this)) // or RenderEffectBlur
            .setFrameClearDrawable(windowBackground) // Optional
            .setBlurRadius(radius)






    }
}