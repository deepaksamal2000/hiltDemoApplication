package com.deepak.hiltapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.deepak.hiltapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MainViewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    Toast.makeText(this,viewModel.getDummyTest(),Toast.LENGTH_LONG).show()
        viewModel.getData().observe(this, Observer { data->
            Toast.makeText(this,data,Toast.LENGTH_LONG).show()
        })
    }
}