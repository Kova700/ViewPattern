package com.example.viewpattern.mvp_pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewpattern.R

abstract class BaseActivity : AppCompatActivity() {

    //override를 갖는 멤버는 그 자체로 open임으로 하위 클래스에서 override가능하다. (못하게 하려면 final로 명시해야한다.)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initPresenter ()
    }
    abstract fun initPresenter() //View와 상호작용할 Presenter를 주입하기 위해
}