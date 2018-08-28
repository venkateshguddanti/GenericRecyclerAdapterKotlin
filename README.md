# GenericRecyclerAdapterKotlin

In project level build.gradle add following

allprojects {
    repositories {
       --------        
       --------
        maven { url 'https://jitpack.io' } 
    }
  }
under depedencies add the follwing gradle pllugin

dependencies {
    -----
    compile 'com.github.venkateshguddanti:GenericRecyclerAdapterKotlin:1.0.1'
}

In android its very common to show the data in list . Usually we do that using ListView or RecyclerView.

If a project has 10 different lists with ten different items then usually people end up in creating 10 different adapter.
we can resolve this problem by creating single adapter but writing 10 different view holders for it.
