package com.example.viewpattern.mvp_pattern

interface BasePresenter<T> { //Presenter에서 기본적으로 자주 사용할 내용들 미리 명시
    
    fun takeView(view: T) //View가 생성 혹은 bind 될 때를 Presenter에 전달
    fun dropView() //View가 제거되거나 unBind 될 때를 Presenter에 전달
}