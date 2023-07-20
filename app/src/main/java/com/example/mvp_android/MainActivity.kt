package com.example.mvp_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import com.example.mvp_android.contracts.MainActivityContract
import com.example.mvp_android.databinding.ActivityMainBinding
import com.example.mvp_android.models.MainModel
import com.example.mvp_android.network.model.quoteList
import com.example.mvp_android.network.retrofit.ApiService
import com.example.mvp_android.presenter.MainPresenter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(),MainActivityContract.View {

    @Inject
    lateinit var apiService: ApiService

    private lateinit var presenter: MainPresenter

    private var _binding: ActivityMainBinding?=null
    private val binding:ActivityMainBinding
        get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = MainPresenter(this@MainActivity,MainModel(apiService))

        presenter.getUniversity("Random String")

    }

    override fun onLoading() {
        binding.progressBar.visibility = ProgressBar.VISIBLE;
    }

    override fun onSuccess(list: quoteList) {
        binding.progressBar.visibility = ProgressBar.GONE;
        binding.textView.text = list.toString()
    }

    override fun onError(message: String) {
        binding.progressBar.visibility = ProgressBar.GONE;
        binding.textView.text = message
    }
}