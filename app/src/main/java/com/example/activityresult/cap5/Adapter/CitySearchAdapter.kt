package com.example.activityresult.cap5.Adapter

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import com.example.activityresult.cap5.util.removeAccents

class CitySearchAdapter(
    context: Context,
    layout: Int,
    private val fullList: List<String>
) : ArrayAdapter<String>(context, layout, fullList), Filterable {

    private var results: List<String>
    private val cityFilter: Filter

    init {
        this.results = fullList
        this.cityFilter = CityFilter()
    }

    override fun getCount(): Int = results.size

    override fun getItem(item: Int): String? =
        if (results.isNotEmpty() && item < results.size) {
            results[item]
        } else {
            null
        }

    override fun getFilter(): Filter = cityFilter

    private inner class CityFilter : Filter() {
        override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {
            val filterResult = Filter.FilterResults()
            var temp:List<String> = ArrayList()

            if(constraint != null){
                val term =  constraint.toString().toLowerCase()
                temp = fullList.filter {
                    it.removeAccents().indexOf(term) > -1
                }
            }

            filterResult.values = temp
            filterResult.count = temp.size
            return filterResult
        }

        override fun publishResults(constraint: CharSequence?, filterResults: Filter.FilterResults) {
            results =  filterResults.values as List<String>
            notifyDataSetChanged()
        }
    }
}