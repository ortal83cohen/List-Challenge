package com.cohen.challenge

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


class ListViewModel : ViewModel() {


    private var items = MutableLiveData<ArrayList<Item>>()


    fun init(appCompatActivity: AppCompatActivity) {

        val reader = appCompatActivity.assets.open("imagesoftheday.json", Context.MODE_PRIVATE).reader()

        val imagesObject = Gson().fromJson<ImagesObject>(reader, object : TypeToken<ImagesObject>() {}.type)

        items.postValue(imagesObject.images)
    }

    fun getItems(): LiveData<ArrayList<Item>> {
        return items
    }

}
