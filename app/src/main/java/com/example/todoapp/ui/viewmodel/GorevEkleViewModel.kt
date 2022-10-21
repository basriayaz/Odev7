package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.GorevlerDaoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GorevEkleViewModel @Inject constructor (var grepo : GorevlerDaoRepository): ViewModel() {
    fun gorevKayit(gorev_ad:String){

    }
}