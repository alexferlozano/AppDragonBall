package com.example.userlist.util;

import android.media.Image;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.squareup.picasso.Picasso;

public class BindingAdapterUtil {
    @BindingAdapter("android:URL")
    public static void setImageUrl(ImageView imageView, String url){
        Picasso.get().load(url).fit().into(imageView);
    }
}
