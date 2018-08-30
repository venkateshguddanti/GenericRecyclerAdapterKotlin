# GenericRecyclerAdapterKotlin

In project level build.gradle add following
```
allprojects {
    repositories {
        maven { url 'https://jitpack.io' } 
    }
  }
```
under depedencies add the follwing gradle pllugin

```
dependencies {
    -----
    compile 'com.github.venkateshguddanti:GenericRecyclerAdapterKotlin:1.0.1'
}
```
In android its very common to show the data in list . Usually we do that using ListView or RecyclerView.

If a project has 10 different lists with ten different items then usually people end up in creating 10 different adapter.
we can resolve this problem by creating single adapter but writing 10 different view holders for it.

When ever you want to use adapter use the follwoing snippet in your activity/fragment

```
   val adapter = object  : GenericAdapter<YourDataModel>(<your data list>)
        {
            override fun getLayoutId(position: Int, type: YourDataModel): Int {
            
                return  R.layout.list_item   //return the layout you want to inflate
            }

            override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
            
                return YourHolder(view)    // this will be your binding view holder
            }

        }

```

Your viewholder code is as fallows

```
class YourHolder RecyclerView.ViewHolder,GenericAdapter.Binder<YourDataModel>
{
    var tv_name : TextView
    var icon : ImageView

    constructor(itemView : View) : super(itemView)
    {
             tv_name = itemView.findViewById(R.id.textView)
             icon = itemView.findViewById(R.id.icon)
    }
    override fun bind(data: YourDataModel) {

        tv_name.text = data.name
        icon.setOnClickListener({
            
            //
        })
    }

}

```
With this adatper we can also inflate different layouts for each list item for this do as follows.

```
val myAdapter = object : GenericAdapter<Any>(listOf(Car("Audi",Color.BLACK),Bus("Benz",Color.WHITE))) {
    override fun getLayoutId(position: Int, obj: Any): Int {
        return when(obj){
            is Car->R.layout.car_layout
            is Bus->R.layout.bus_layout
            else->R.layout.car_layout
        }
    }

    override fun getViewHolder(view: View, viewType: Int): RecyclerView.ViewHolder {
        
        return when(viewType){
            
            R.layout.car_layout->CarViewHolder(view)
            R.layout.bus_layout->BusViewHolder(view)
            else->BusViewHolder(view)
        }
    }
}
```
