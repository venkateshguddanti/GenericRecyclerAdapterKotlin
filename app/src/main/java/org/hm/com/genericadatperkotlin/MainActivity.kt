package org.hm.com.genericadatperkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        val adapter = object : GenericAdapter<Product>(listOf(Product("one","url"),
                Product("one","url"),
                Product("one","url"),
                Product("one","url"),Product("one","url"))){
            override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {

                       return ProductHolder(view)
            }

            override fun getLayoutId(position: Int, type: Product): Int {
                return R.layout.list_item_product
            }

        }
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }
}
