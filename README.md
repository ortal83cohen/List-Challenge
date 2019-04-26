Coding Challenge Android
This challenge is made for a 30 minutes timebox.
Objective: Write an Android app that displays given json
data in a RecyclerView.
Given json file format:
{
 "images": [
 {
 "copyright": "Marcel DrechslerBaerenstein Obs.",
 "date": "2018-09-19",
 "explanation": "Inside the Cocoon Nebula ...",
 "hdurl": "https://apod.nasa.gov/apod/image/1809/Cocoon_Drechsler_4000.jpg",
 "media_type": "image",
 "service_version": "v1",
 "title": "Cocoon Nebula Deep Field",
 "url": "https://apod.nasa.gov/apod/image/1809/Cocoon_Drechsler_960.jpg"
 },
 ...
}
Hint 1: Add these dependencies to your build.gradle and
update versions if needed (if you want to use Gson and
Glide):
implementation 'com.android.support:recyclerview-v7:28.0.0-rc02'
implementation 'com.google.code.gson:gson:2.8.2'
implementation 'com.github.bumptech.glide:glide:4.8.0'
Hint 2: Put the json file in your assets folder and read like this:
val reader = resources.assets.open("imagesoftheday.json", Context.MODE_PRIVATE).reader()
// reader can be passed to Gson as is
Hint 3: Do not spend too much time on beautifying the layout. You may use
this simple one if you like:
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
 xmlns:app="http://schemas.android.com/apk/res-auto"
 android:layout_width="match_parent"
 android:layout_height="120dp"
 android:padding="16dp">
 <ImageView
 android:id="@+id/item_image"
 android:layout_width="100dp"
 android:layout_height="100dp"
 android:layout_alignParentStart="true"
 android:layout_marginEnd="16dp"
 android:scaleType="centerCrop"
 app:srcCompat="@mipmap/ic_launcher" />
 <LinearLayout
 android:layout_width="match_parent"
 android:layout_height="match_parent"
 android:layout_toEndOf="@+id/item_image"
 android:orientation="vertical">
 <TextView
 android:id="@+id/item_title"
 android:layout_width="match_parent"
 android:layout_height="wrap_content" />
 <TextView
 android:id="@+id/item_subtitle"
 android:layout_width="match_parent"
 android:layout_height="wrap_content" />
 </LinearLayout>
</RelativeLayout>
Good luck!