package com.example.viewpattern.mvc_pattern

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.viewpattern.data.Book
import com.example.viewpattern.databinding.ActivityMainBinding
import com.example.viewpattern.databinding.ActivityMvcactivityBinding
import com.example.viewpattern.utils.Constansts
import com.example.viewpattern.utils.Constansts.TAG

class MVCActivity : AppCompatActivity() {

    /*MVC패턴*/

    /*바인딩 객체 선언 (가져올 바인딩 클래스 선언)
    fragment에서는 onDestroty에서 null처리 해줘야 한다.*/
    val binding by lazy { ActivityMvcactivityBinding.inflate(layoutInflater) } //뷰 참조 (xml파일)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "MVCActivity: onCreate() - called")

        //뷰 바인딩 (레이아웃 내부의 최상위 위치 뷰의 인스턴스 전달)
        setContentView(binding.root) //뷰 참조 (xml파일)


        //컨트롤러 (버튼 이벤트 발생하면 뷰와 모델을 제어할 수 있다.)
        binding.changeBtn.setOnClickListener {
            Log.d(TAG, "MVCActivity: 버튼 클릭발생")
            binding.bookNameTv.text = "책 이름 : "
            binding.authorNameTv.text = "작가 : "

            //모델 참조 (데이터 타입)
            val book1 = Book("${binding.bookNameEt.text}","${binding.authorNameEt.text}")
            binding.bookNameTv.append(book1.name)
            binding.authorNameTv.append(book1.author)
        }

    }
}