package com.example.viewpattern

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viewpattern.utils.Constansts.TAG

enum class ActionType{
    PLUS , MINUS
}

//데이터의 변경
//뷰모델은 데이터의 변경사항을 알려주는 라이브 데이터를 가지고 있다.
class MyNumberViewModel :ViewModel(){

    // 뮤터블 라이브 데이터 - 수정 가능한 녀석
    // 라이브 데이터 - 값 변경불가(읽기 전용)

    // 내부에서 설정하는 자료형은 뮤터블로
    // 변경가능하도록 설정
    private val _count = MutableLiveData<Int>()

    //EditText에서 사용자가 입력한 값
    var inputText = MutableLiveData<String>()

    // 변경되지 않는 데이터를 가져 올때 이름을 _(언더스코어) 없이 설정
    // 공개적으로 가져오는 변수는 private이 아닌 public으로 외부에서도 접근가능하도록 설정
    // 하지만 값을 직접 LiveData에 접근하지 않고 ViewModel을 통해 가져올 수 있도록 설정
    val count : LiveData<Int>
        get() = _count



    //초기값 설정
    init {
        Log.d(TAG, "MyNumberViewModel - 생성자 호출")
        _count.value = 0
    }
    
    // ViewModel이 가지고 있는 값을 변경하는 메소드
    fun updateValue(actionType: ActionType) {
        when(actionType){
            ActionType.PLUS ->{
                Log.d(TAG, "MyNumberViewModel: updateValue-PLUS() - called")
                _count.value = _count.value?.plus(inputText.value!!.toInt())
            }
            ActionType.MINUS ->{
                Log.d(TAG, "MyNumberViewModel: updateValue-MINUS() - called")
                _count.value = _count.value?.minus(inputText.value!!.toInt())
            }
        }
    }
}