package com.mini.infotainment.UI

import android.os.Build
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.viewpager.widget.PagerAdapter

class PagerAdapter(private val pages: MutableList<ViewGroup>) : PagerAdapter() {
    private val pagesReady = Array(pages.size) { _ -> false }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun instantiateItem(collection: ViewGroup, position: Int): Any {
        if(!pagesReady[position]) {
            collection.addView(pages[position])
            pagesReady[position] = true
        }

        return pages[position]
    }

    override fun destroyItem(collection: ViewGroup, position: Int, view: Any){}
    override fun getCount() = pages.size
    override fun isViewFromObject(view: View, `object`: Any) = view === `object`
}