package com.jagruti.myfirstapp

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jagruti.myfirstapp.databinding.ActivityDialogTypesBinding
import com.jagruti.myfirstapp.databinding.CustomeDialogViewBinding

class DialogTypes : AppCompatActivity() {
    lateinit var binding: ActivityDialogTypesBinding
    lateinit var bindingDialog: CustomeDialogViewBinding

    // create a variable of type Dialog
    lateinit var dialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDialogTypesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dialog = Dialog(this)
        bindingDialog = CustomeDialogViewBinding.inflate(layoutInflater)
        dialog.setContentView(bindingDialog.root)
        dialog.window?.setBackgroundDrawableResource(R.drawable.bg_alert_box)
        bindingDialog.btnSend.setOnClickListener {
            dialog.dismiss()
        }
        bindingDialog.btnSendFeedback.setOnClickListener {
            Toast.makeText(this, "SendFeedback Clicked", Toast.LENGTH_LONG).show()
        }


        binding.button.setOnClickListener {
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Are you sure?")
            builder1.setMessage("Do you want to close the app?")
            builder1.setPositiveButton(
                "Yes",
                DialogInterface.OnClickListener { dialoginterface, i ->
                    finish()
                })
            builder1.setNegativeButton("No", DialogInterface.OnClickListener { dialoginterface, i ->
                Toast.makeText(this, "No Clicked", Toast.LENGTH_LONG).show()
            })
            builder1.show()
        }

        binding.button2.setOnClickListener {
            val options = arrayOf("Pizza", "Burger", "Pani Puri", "Sandwich")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Which is your favourite items")
            builder1.setSingleChoiceItems(
                options,
                0,
                DialogInterface.OnClickListener { dialog, which ->
                    Toast.makeText(this, "You Clicked on ${options[which]}", Toast.LENGTH_LONG)
                        .show()
                })
//            builder1.setMessage("Do you want to close the app?")
            builder1.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialoginterface, i ->
                })
            builder1.setNegativeButton(
                "Decline",
                DialogInterface.OnClickListener { dialoginterface, i ->
                    Toast.makeText(this, "No Clicked", Toast.LENGTH_LONG).show()
                })
            builder1.show()
        }

        binding.button3.setOnClickListener {
            val options = arrayOf("Pizza", "Burger", "Pani Puri", "Sandwich")
            val builder1 = AlertDialog.Builder(this)
            builder1.setTitle("Which is your favourite items")
            builder1.setMultiChoiceItems(
                options,
                null,
                DialogInterface.OnMultiChoiceClickListener { dialog, which, ischecked ->
                    Toast.makeText(this, "You Clicked on ${options[which]}", Toast.LENGTH_LONG)
                        .show()
                })
//            builder1.setMessage("Do you want to close the app?")
            builder1.setPositiveButton(
                "Submit",
                DialogInterface.OnClickListener { dialoginterface, i ->
                })
            builder1.setNegativeButton(
                "Decline",
                DialogInterface.OnClickListener { dialoginterface, i ->
                    Toast.makeText(this, "No Clicked", Toast.LENGTH_LONG).show()
                })
            builder1.show()
        }


        binding.button4.setOnClickListener {
            dialog.show()
        }
    }
}