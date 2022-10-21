package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentGorevEkleBinding
import com.example.todoapp.ui.viewmodel.GorevDetayViewModel
import com.example.todoapp.ui.viewmodel.GorevEkleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GorevEkleFragment : Fragment() {
    private lateinit var tasarim:FragmentGorevEkleBinding
    private lateinit var viewModel:GorevEkleViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_gorev_ekle, container, false)
        tasarim.gorevEkleFragment = this

        tasarim.gorevEkleToolbarBaslik = "Görev Ekle"


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : GorevEkleViewModel by viewModels()
        viewModel = tempViewModel

    }

    fun buttonKaydet(gorev_ad:String){
        viewModel.gorevKayit(gorev_ad)
    }

}