package com.example.viewpattern.mvp_pattern

object DogListData { //로컬 혹은 리모트 데이터를 받아오는 Object라고 생각 (편의를 위해 더미 데이터 이용)
    fun getDogListData() : List<Dog>{
        return listOf(
            Dog("일식이",1),
            Dog("이식이",2),
            Dog("삼식이",3)
        )
    }
}