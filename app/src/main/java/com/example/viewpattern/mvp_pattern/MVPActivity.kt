package com.example.viewpattern.mvp_pattern

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.viewpattern.R
import java.lang.Error

class MVPActivity: BaseActivity(), SearchContract.View {

    private lateinit var searchPresenter: SearchContract.Presenter
    private lateinit var pbLoading : ProgressBar
    private lateinit var searchBtn : Button
    private lateinit var dogTv1 : TextView
    private lateinit var dogTv2 : TextView
    private lateinit var dogTv3 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvpactivity)

        //프레젠터에 현재 Activity를 View로 사용할 것임을 알린다.
        searchPresenter.takeView(this)

        initView()
        setButton()

    }
    private fun initView() {
        pbLoading = findViewById(R.id.searchRefresh)
        searchBtn = findViewById(R.id.getDogListButton)
        dogTv1 = findViewById(R.id.firstDogText)
        dogTv2 = findViewById(R.id.secondDogText)
        dogTv3 = findViewById(R.id.thirdDogText)
    }
    private fun setButton() {
        searchBtn.setOnClickListener {
            //사용자 이벤트가 발생하면 Presenter에게 알린다.(MVP 패턴 특징)
            searchPresenter.getDogList()
        }
    }

    //Presenter가 Model로 부터 받은 데이터를 View에게 전달해주는 통로
    override fun showDogList(dogList: List<Dog>) { 
        dogTv1.text = "NAME : ${dogList[0].name}, AGE : ${dogList[0].age}"
        dogTv2.text = "NAME : ${dogList[1].name}, AGE : ${dogList[1].age}"
        dogTv3.text = "NAME : ${dogList[2].name}, AGE : ${dogList[2].age}"
    }

    //액티비티가 종료될때 Presenter도 종료 (메모리 누수 방지)
    override fun onDestroy() {
        super.onDestroy()
        searchPresenter.dropView()
    }

    //BaseActivity의 추상메소드라서 가장 먼저 실행됨
    override fun initPresenter() {
        searchPresenter = SearchPresenter()
    }

    override fun showLoading() {
        pbLoading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pbLoading.visibility = View.GONE
    }

    override fun showError(error: Error) {
        Toast.makeText(this, error.toString() ,Toast.LENGTH_SHORT).show()
    }

}