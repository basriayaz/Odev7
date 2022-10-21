package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.GorevlerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GorevDetayViewModel @Inject constructor (var grepo : GorevlerDaoRepository) : ViewModel(){

    fun KisiGuncelle(gorev_id:Int,gorev_ad:String){
        grepo.gorevGuncelle(gorev_id,gorev_ad)
    }


}