package com.example.fruteriafragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list_fruit.*


class ListFruitFragment : Fragment() {


    interface OnButtonPressedListenerListFragment{
        fun onButtonImagePressed(fruta: Fruta)
    }

    lateinit var listener: OnButtonPressedListenerListFragment


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_fruit, container, false)
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        listener = activity as OnButtonPressedListenerListFragment
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val frutas = ArrayList<Fruta>()
        frutas.add(Fruta("Platano", R.drawable.platano,4,"Es un platano normal"))
        frutas.add(Fruta("Durazno", R.drawable.durazno,4,"Es un Durazno normal"))
        frutas.add(Fruta("Manzana", R.drawable.manzana,4,"Es un Manzana normal"))
        frutas.add(Fruta("Sandia", R.drawable.sandia,4,"Es un Sandia normal"))
        frutas.add(Fruta("cereza", R.drawable.cherry,4,"Es un cereza normal"))

        val adaptador = Adaptador(this.context!!,frutas)

        lista.adapter = adaptador

        lista.setOnItemClickListener { _, _, position, _ ->

            listener.onButtonImagePressed(frutas[position])

        }




    }



}
