package com.example.muthootdemo2.main.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.domain.main.entities.CatResponse
import com.example.muthootdemo2.BaseActivity
import com.example.muthootdemo2.databinding.ActivityMainBinding
import com.example.muthootdemo2.main.viewmodel.MainViewModel
import com.example.muthootdemo2.states.NetworkResponseState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Init()
        initListener()
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launchWhenStarted {
            viewModel.myResponseFlow.collect {
                when (it) {
                    is NetworkResponseState.Loading -> {
                        showProgress()
                    }
                    is NetworkResponseState.Success -> {
                        hideProgress()
                        showSuccess(it.data as CatResponse)
                    }
                    is NetworkResponseState.Failure -> {
                        showApiError(it.e.message.toString())
                    }
                }
            }
        }
    }

    private fun showSuccess(catResponse: CatResponse) {
        Toast.makeText(this, catResponse.fact, Toast.LENGTH_SHORT).show()
    }

    private fun initListener() {
        binding.hello.setOnClickListener {
            viewModel.fetchApi(
            )
        }
    }

    private fun Init() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }
}