package com.example.exercise1.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exercise1.databinding.ActivityMainBinding




class MainActivity : ComponentActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: JokeAdapter

    private val viewModel: JokeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.jokeLiveData.observe(this) {
            Log.d("viewModel","$it")
            adapter.addItems(it)
        }

        binding.jokesList.layoutManager = LinearLayoutManager(applicationContext)
        adapter = JokeAdapter()
        binding.jokesList.adapter = adapter

        viewModel.tellJoke()
    }
}