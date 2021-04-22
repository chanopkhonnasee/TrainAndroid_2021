package com.train.trainandroid2021.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.train.trainandroid2021.R
import com.train.trainandroid2021.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main).apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }
    }

    private var articleAdapter: ArticleAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        initViewData()
    }

    private fun initViewModel() {
        viewModel.newsData.observe(this, Observer {
            articleAdapter?.articles = it.articles
        })
    }

    private fun initViewData() {
        articleAdapter = ArticleAdapter()
        binding.adapter = articleAdapter
        viewModel.getNews("Apple")
    }
}