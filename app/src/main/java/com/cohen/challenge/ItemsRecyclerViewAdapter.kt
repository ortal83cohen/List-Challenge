package com.cohen.challenge


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_item.view.*


class ItemsRecyclerViewAdapter(
    private val listViewModel: ListViewModel,
    val activity: FragmentActivity
) : RecyclerView.Adapter<ItemsRecyclerViewAdapter.ViewHolder>() {

    init {
        listViewModel.getItems().observe(activity, Observer {
            notifyDataSetChanged()
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listViewModel.getItems().value?.get(position)
        holder.title.text = item?.title
        holder.subtitle.text = item?.explanation

        Glide
            .with(activity)
            .load(item?.url)
            .centerCrop()
            .placeholder(activity.resources.getDrawable(R.drawable.abc_ic_clear_material))
            .into(holder.image)
    }

    override fun getItemCount(): Int = listViewModel.getItems().value?.size ?: 0

    inner class ViewHolder( mView: View) : RecyclerView.ViewHolder(mView) {
        val title: TextView = mView.item_title
        val subtitle: TextView = mView.item_subtitle
        val image: ImageView = mView.item_image

        override fun toString(): String {
            return super.toString() + " '" + title.text + "'"
        }
    }
}
