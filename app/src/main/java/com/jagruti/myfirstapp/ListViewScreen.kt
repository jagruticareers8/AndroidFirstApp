package com.jagruti.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jagruti.myfirstapp.databinding.ActivityListViewScreenBinding

class ListViewScreen : AppCompatActivity() {
    lateinit var binding: ActivityListViewScreenBinding
    lateinit var contactArrayList: ArrayList<ContactData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListViewScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val name = arrayOf("Jagruti", "Kundan","Krishiv","Mishri","Abc" )
        val lastMsg= arrayOf("Hey whats app","I am fine", "Good", "Awesome", "Cool")
        val  lastMsgTime = arrayOf("6:25 AM","7:30 AM","8:05 PM","11:25 PM","7:25 AM")
        val  phoneNo = arrayOf("9867896545","1276785646","9871234987","9127896543","9128643678")
        val  imageId= intArrayOf(R.drawable.myimage,R.drawable.virat,R.drawable.pic0,R.drawable.sachin,R.drawable.checkbox)

        contactArrayList = ArrayList()
        for (index in name.indices){
            val contact = ContactData(name[index], lastMsg[index],
                lastMsgTime[index],
                phoneNo[index],
            imageId[index])
            contactArrayList.add(contact)
        }

        binding.lvContact.isClickable = true
        binding.lvContact.adapter = ContactAdapter(this,contactArrayList)

        binding.lvContact.setOnItemClickListener { parent, view, position, id ->
            val contact = contactArrayList[position]
            Toast.makeText(this, "Clicked: ${contact.name}", Toast.LENGTH_SHORT).show()
            val i = Intent(this, ContactDetailsActivity::class.java)
            i.putExtra("CONTACT_DATA", contact)
            startActivity(i)
        }

        val taskList = arrayListOf<String>()
        taskList.add("Attend Exam")
        taskList.add("Complete the App Dev Project")
        taskList.add("go to market for buy vegis ")
        taskList.add("back to home")
        taskList.add("work on resume")
        taskList.add("Improve Internet Presence")


        val  adapterForListview = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,taskList)
        binding.lvTodo.adapter = adapterForListview

        binding.lvTodo.setOnItemClickListener { parent, view, position, id ->
            val text = "Clicked on item : "+(view as TextView).text.toString()
            Toast.makeText(this,text, Toast.LENGTH_SHORT).show()
        }

    }
}