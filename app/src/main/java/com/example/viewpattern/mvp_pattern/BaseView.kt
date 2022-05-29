package com.example.viewpattern.mvp_pattern

import java.lang.Error

interface BaseView {    //View에서 기본적으로 자주 사용할 내용들 미리 명시
    fun showError(error: Error)
}