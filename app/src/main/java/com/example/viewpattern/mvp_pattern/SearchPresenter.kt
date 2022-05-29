package com.example.viewpattern.mvp_pattern

import android.os.Handler

//미리 내용을 정의 했던 Contract 인터페이스로 View와 1:1관계를 유지할 Presenter 구현
class SearchPresenter : SearchContract.Presenter {

    private var searchView : SearchContract.View? = null    //해당 Presenter가 담당하는 View 명시

    override fun takeView(view: SearchContract.View) {  //View와 Presenter를 연결해준다.
        searchView = view
    }

    override fun dropView() {
        searchView = null
    }

    override fun getDogList() {
        searchView?.showLoading() //View에 ProgressBar를 노출하도록 요청한다.
        Handler().postDelayed({
            val dogList = DogListData.getDogListData()  //Model에서 DogList를 전달 받는다.
            searchView?.showDogList(dogList) // Model에서 전달받은 데이터를 View에게 전달한다.
            searchView?.hideLoading() //트워크 통신이 끝났으니 View에 ProgressBar를 숨기도록 요청한다.
        }, 1000) //지연시간을 강제로 줌
    }

}