package com.example.fruteriafragment

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fruteriafragment.ListFruitFragment.OnButtonPressedListenerListFragment
import com.example.fruteriafragment.R.*

class MainActivity : AppCompatActivity() , OnButtonPressedListenerListFragment{


    override fun onButtonImagePressed(fruta: Fruta) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        val list = ListFruitFragment()
        supportFragmentManager.beginTransaction()
            .add(id.firstContainer,list)
            .commit()
    }
}
