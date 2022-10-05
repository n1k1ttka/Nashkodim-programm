package com.example.cryptoinfo

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cryptoinfo.network.CryptoLabel


@BindingAdapter("imageUrl")
fun bindCryptoLabel(imgView: ImageView, LabelUrl: String?){
    LabelUrl?.let {
        // Загрузите изображение в фоновом режиме с помощью Coil.
        val CryptoLabelUri = LabelUrl.toUri()
            .buildUpon().scheme("https") // TODO Чтобы использовать схему HTTPS
            .build() // TODO Создали объект Uri

        /* imgView.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_broken_image)
        }*/
    }
}
fun bindRecyclerView(recyclerView: RecyclerView, data: List<CryptoLabel>?) {
    val adapter = recyclerView.adapter as
    adapter.submitList(data) // TODO Сообщаем RecyclerView, когда новый список доступен
}
@BindingAdapter("marsApiStatus")
fun bindStatus(statusImageView: ImageView,
               status: MarsApiStatus?){
    when(status){
        MarsApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        MarsApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        MarsApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}