package com.example.fruteriafragment
import android.os.Parcel
import android.os.Parcelable

class Fruta(nombre:String, imagen:Int, cantidad:Int, descripcion:String):Parcelable{

    var nombre:String = ""
    var imagen:Int = 0
    var cantidad:Int= 0
    var descripcion:String = ""

    constructor(parcel: Parcel) : this(
        nombre = parcel.readString(),
        imagen = parcel.readInt(),
        cantidad = parcel.readInt(),
        descripcion = parcel.readString())

    init {
        this.nombre = nombre
        this.imagen = imagen
        this.cantidad= cantidad
        this.descripcion=descripcion
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(imagen)
        parcel.writeInt(cantidad)
        parcel.writeString(descripcion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Fruta> {
        override fun createFromParcel(parcel: Parcel): Fruta {
            return Fruta(parcel)
        }

        override fun newArray(size: Int): Array<Fruta?> {
            return arrayOfNulls(size)
        }
    }


}
