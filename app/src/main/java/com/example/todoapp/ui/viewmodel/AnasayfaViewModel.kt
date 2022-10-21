package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.Gorevler
import com.example.todoapp.data.repo.GorevlerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AnasayfaViewModel @Inject constructor(var grepo : GorevlerDaoRepository) : ViewModel() {

    var gorevlerListesi = MutableLiveData<List<Gorevler>>()

    init {
        gorevleriYukle()
        gorevlerListesi = grepo.gorevleriGetir()
    }


    fun ara(aramaKelimesi:String){
        grepo.gorevAra(aramaKelimesi)
    }
    fun sil(gorev_id: Int){
        grepo.gorevSil(gorev_id)
    }

        fun gorevleriYukle(){
        grepo.tumGorevleriAl()
        }









}