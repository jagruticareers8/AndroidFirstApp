package com.jagruti.myfirstapp

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.database.core.Context
import com.jagruti.myfirstapp.databinding.ListViewItemsBinding

class   ContactAdapter (val context: Activity, val arrayList: ArrayList<ContactData>) :
        ArrayAdapter<ContactData>(context, R.layout.list_view_items,arrayList){
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val binding: ListViewItemsBinding
        val view: View

//        val inflater = LayoutInflater.from(context)
//        val  view= inflater.inflate(R.layout.list_view_items,null)

        if (convertView == null) {
            val inflater = LayoutInflater.from(context)
            binding = ListViewItemsBinding.inflate(inflater, parent, false)
            view = binding.root
            view.tag = binding   // store binding in tag for recycling
        } else {
            view = convertView
            binding = view.tag as ListViewItemsBinding
        }

        val contact = arrayList[position]

        binding.ivProfile.setImageResource(contact.imageId)
        binding.tvName.text = contact.name
        binding.tvTime.text = contact.lastMsgTime
        binding.tvMessage.text = contact.lastMsgTime


        return view
    }
}