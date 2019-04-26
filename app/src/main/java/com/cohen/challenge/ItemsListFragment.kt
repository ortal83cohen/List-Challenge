package com.cohen.challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager


class ItemsListFragment : androidx.fragment.app.Fragment() {


    private var columnCount = 100
    lateinit var listViewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        listViewModel = ViewModelProviders.of(activity!!).get(ListViewModel::class.java)
        listViewModel.init(activity as AppCompatActivity)
        // Set the adapter
        if (view is androidx.recyclerview.widget.RecyclerView) {
            with(view) {
                LinearLayoutManager(context)
                adapter = ItemsRecyclerViewAdapter(listViewModel, activity!!)
            }
        }
        return view
    }


    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemsListFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}
