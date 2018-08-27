package org.hm.com.genericadatperkotlin

import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class ProductHolder : RecyclerView.ViewHolder,GenericAdapter.Binder<Product>
{
    var tv_name : TextView;

    constructor(itemView : View) : super(itemView)
    {
             tv_name = itemView.findViewById(R.id.textView)
    }
    override fun bind(data: Product) {

        tv_name.text = data.name
    }

}
