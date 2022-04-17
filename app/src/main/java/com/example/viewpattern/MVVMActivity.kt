package com.example.viewpattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewpattern.databinding.ActivityMvvmactivityBinding
import com.example.viewpattern.utils.Constansts.TAG

class MVVMActivity : AppCompatActivity() {

    /*MVVM패턴*/
    
    //나중에 값이 설정될거라고 lateinit으로 설정
    lateinit var myNumberViewModel: MyNumberViewModel

    private lateinit var binding : ActivityMvvmactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvmactivity)

        //ViewModelProvider를 통해 View모델 Activity에 가져오기
        //LifeCycle을 가지고 있는 녀석을 넣어줌 즉 자기 자신
        myNumberViewModel = ViewModelProvider(this).get(MyNumberViewModel::class.java)

        //DataBinding사용한다면 굳이 LiveData의 observe를 사용할 필요가 없다.
        myNumberViewModel.count.observe(this , Observer {
            Log.d(TAG, "MVVMActivity: myNumberViewModel - count의 LiveData값 변경 : $it")
        })

        myNumberViewModel.inputText.observe(this , Observer {
            Log.d(TAG, "MVVMActivity: myNumberViewModel - inputText값 변경 : $it")
        })

        // 뷰 모델 객체에 실제 lifecycleowner를 현재 activity로 지정해줘야 함
        // (그래야 동적으로 상태 변화를 인지할 수 있음)
        binding.lifecycleOwner = this
        // 뷰(xml)에 정의한 model 변수를 ViewModel과 연결 (ViewModel을 바인딩 변수로 사용함)
        binding.model = myNumberViewModel
0    }


}