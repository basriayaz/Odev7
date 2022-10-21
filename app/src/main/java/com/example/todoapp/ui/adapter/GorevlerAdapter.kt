package com.example.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.Gorevler
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel
import com.example.todoapp.util.gecisYap
import com.google.android.material.snackbar.Snackbar


class GorevlerAdapter(var mContext: Context,
                      var gorevlerListesi:List<Gorevler>,
                      var viewModel : AnasayfaViewModel) :
    RecyclerView.Adapter<GorevlerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardTasarimBinding

        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim:CardTasarimBinding = DataBindingUtil.inflate(layoutInflater,R.layout.card_tasarim,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val gorev  = gorevlerListesi.get(position)
        val t = holder.tasarim
        t.gorevNesnesi = gorev

        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.gorevDetayGecis(gorev = gorev)
            Navigation.gecisYap(gecis,it)

        }

        t.imageViewSil.setOnClickListener{
            Snackbar.make(it,"Görev Silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                   viewModel.sil(gorev.gorev_id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
       return gorevlerListesi.size
    }


}