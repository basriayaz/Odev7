package com.example.todoapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.example.todoapp.data.entity.Gorevler
import com.example.todoapp.room.GorevlerDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GorevlerDaoRepository(var gdao:GorevlerDao)  {

    var gorevlerListesi:MutableLiveData<List<Gorevler>>

    init {
        gorevlerListesi = MutableLiveData()
    }
    fun gorevleriGetir() : MutableLiveData<List<Gorevler>> {
        return gorevlerListesi
    }


    fun gorevKayit(gorev_ad:String){

    }

    fun gorevGuncelle(gorev_id:Int,gorev_ad:String){

    }
    fun gorevAra(aramaKelimesi:String){

    }

    fun gorevSil(gorev_id: Int){

    }

    fun tumGorevleriAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            gorevlerListesi.value = gdao.tumGorevler()

        }

    }




}