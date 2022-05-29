package com.example.viewpattern.mvp_pattern

//Contract(계약) = View와 Presenter가 구현해야할 인터페이스를 정의함
//구현하고자 하는 내용들을 View와 Presenter가 어떻게 분담하고 나눌지 미리 계획한 내용을 명세하는 곳
//View와 Presenter를 각각 정의하여 이해를 돕기 위해 사용한다.
//하나의 Contract interface에 View , Presenter를 작성하고, 이를 각각의 View와 Presenter에 implement하여 사용한다.
interface SearchContract {

    interface View :BaseView {  //대체적으로 받아온 데이터를 이용해서 UI작업하는 내용

        fun showLoading()   //데이터를 받아서 정제 하는동안 보일 ProgressBar관리하는 함수
        fun hideLoading()
        fun showDogList(dogList : List<Dog>)    //정제한 데이터를 Presenter에서 전달받을 함수
    }
    
    interface Presenter :BasePresenter<View>{ //대체적으로 데이터 정제,가공하는 내용

        fun getDogList()    //Model로 부터 데이터를 받아오기(정제하기) 위한 함수
    }
}