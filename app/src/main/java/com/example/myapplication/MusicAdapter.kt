package com.example.myapplication

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlin.contracts.contract


class MusicAdapter(val context : Activity, val datalist : List<Data>) :
    RecyclerView.Adapter<MusicAdapter.MusicViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.musictem, parent, false)
        return MusicViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        val currentdata = datalist[position]
        val mediaPlayer = MediaPlayer.create(context, currentdata.preview.toUri())
        holder.title.text = currentdata.title
        Picasso.get().load(currentdata.album.cover).into(holder.image);
holder.play.setOnClickListener{
    mediaPlayer.start()
}
 holder.pause.setOnClickListener{
     mediaPlayer.stop()
 }
    }

        class MusicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val image: ImageView
            val title: TextView
            val play: ImageView
            val pause: ImageView

            init {
                image = itemView.findViewById(R.id.musicImage)
                title = itemView.findViewById(R.id.musicTitle)
                play = itemView.findViewById(R.id.play)
                pause = itemView.findViewById(R.id.pause)
            }
        }
    }
