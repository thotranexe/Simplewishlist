package com.example.simplewishlist

class fetcher {
    companion object {
        var item = mutableListOf<String>()
        var price = mutableListOf<String>()
        var url = mutableListOf<String>()

        fun getlist(): MutableList<wishlist> {
            var wishlist: MutableList<wishlist> = ArrayList()
            println(item[0])
            if(item.isNotEmpty()&& price.isNotEmpty()&&url.isNotEmpty()) {
                //println("in ur mom")
                for (i in 0..item.size-1) {
                    val wishlists = wishlist(item[i], price[i], url[i])
                    wishlist.add(wishlists)
                }
            }
            return wishlist
        }
        fun wappend(itemname: String, itemprice: String, itemurl:String){
            item.add(itemname)
            price.add(itemprice)
            url.add(itemurl)
        }
    }
}