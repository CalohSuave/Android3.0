package com.example.fruteriafragment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class Adaptador(val context: Context, val items: ArrayList<Fruta>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var holder: ViewHolder? = null
        var vista: View? = convertView


        if (vista == null) {
            vista = LayoutInflater.from(context).inflate(R.layout.template_listview, null)
            holder = ViewHolder(vista)
            vista?.tag = holder

        } else {
            holder = vista.tag as? ViewHolder
        }

        val item = getItem(position) as Fruta
        holder?.name?.text = item.nombre
        holder?.stock?.text = item.cantidad.toString()
        holder?.imagen?.setImageResource(item.imagen)


        holder?.deletetext?.setOnClickListener {
            items.removeAt(position)
            notifyDataSetChanged()
        }
        return vista!!
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.count()
    }

    private class ViewHolder(vista: View) {
        var name: TextView? = null
        var imagen: ImageView? = null
        var stock: TextView? = null
        var deletetext: TextView? = null


        init {
            name = vista.findViewById(R.id.modelName)
            imagen = vista.findViewById(R.id.FrutaImage)
            stock = vista.findViewById(R.id.Fruteria_cantidad)
            deletetext = vista.findViewById(R.id.delModel)
        }

    }

}