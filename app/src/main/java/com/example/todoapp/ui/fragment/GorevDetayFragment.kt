package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentGorevDetayBinding
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel
import com.example.todoapp.ui.viewmodel.GorevDetayViewModel
import com.example.todoapp.ui.viewmodel.GorevEkleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GorevDetayFragment : Fragment() {
    private lateinit var tasarim: FragmentGorevDetayBinding
    private lateinit var viewModel: GorevDetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_gorev_detay, container, false)
        tasarim.gorevDetayFragment = this
        tasarim.toolbarGorevEkle2.title = "Görev Detayları"

        val bundle:GorevDetayFragmentArgs by navArgs()
        val gelenGorev = bundle.gorev

        tasarim.gorevNesnesi = gelenGorev

        return tasarim.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : GorevDetayViewModel by viewModels()
        viewModel = tempViewModel

    }

    fun buttonGuncelle(gorev_id:Int,gorev_ad:String){
        viewModel.KisiGuncelle(gorev_id,gorev_ad)
    }


}