package com.example.rxapiexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.rxapiexample.infra.repository.ZipCodeRepository
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

class MainActivity : AppCompatActivity() {

    private val subscription = CompositeSubscription()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subscription.clear()
        subscription.add(
            ZipCodeRepository.zipCodeApiClient.getZipCode("618", "0000")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    Log.e("test!!", "$it")
                }
                .doOnError {
                    it ->  Log.e("test!!", "${it.message}")
                }
                .doOnCompleted {
                }
                .subscribe())
    }

    override fun onDestroy() {
        super.onDestroy()
        subscription.unsubscribe()
    }
}