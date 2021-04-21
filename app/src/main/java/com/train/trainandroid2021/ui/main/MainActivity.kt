package com.train.trainandroid2021.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.train.trainandroid2021.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViewModel()
        initViewData()
    }

    private fun initViewModel() {
        viewModel.newsData.observe(this, Observer {
            Toast.makeText(this, "load complete", Toast.LENGTH_SHORT).show()
        })
    }

    private fun initViewData() {
        viewModel.getNews("Apple")
    }
}