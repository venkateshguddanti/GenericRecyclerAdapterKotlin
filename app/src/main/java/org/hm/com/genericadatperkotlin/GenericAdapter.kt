package org.hm.com.genericadatperkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


abstract class GenericAdapter<T>(val listItems: List<T>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    var listItmes : List<T> = this.listItems

   /* constructor(listItems : List<T>)
    {
        this.listItmes = listItmes
    }*/


    fun setItems(listItems: List<T>)
    {
        this.listItmes = listItmes
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return getViewHolder(LayoutInflater.from(parent.context)
                .inflate(viewType,parent,false)
                ,viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        (holder as Binder<T>).bind(listItmes[position])
    }

    override fun getItemCount(): Int {
        return listItmes.size
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(position,listItmes[position])
    }
    abstract fun getViewHolder(view : View,viewType: Int ) : RecyclerView.ViewHolder

    protected abstract fun getLayoutId(position : Int,type : T): Int

    internal interface Binder<T>
    {
        fun bind(data:T)
    }
}