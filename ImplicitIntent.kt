package com.example.demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.CallLog
import android.provider.ContactsContract
import android.provider.MediaStore
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class ImplicitIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicitintent)

        val btn1 = findViewById<Button>(R.id.b1) // Camera
        val btn2 = findViewById<Button>(R.id.b2) // Navigate
        val btn3 = findViewById<Button>(R.id.b3) // Call Log
        val btn4 = findViewById<Button>(R.id.b4) // Contacts
        val btn5 = findViewById<Button>(R.id.b5) // Gallery
        val btn6 = findViewById<Button>(R.id.b6) // Dialer
        val btn7 = findViewById<Button>(R.id.b7) // Dial Number

        btn1.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }

        btn2.setOnClickListener {
            // Define navigation intent here, e.g., Google Maps
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=restaurants"))
            startActivity(intent)
        }

        btn3.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                type = CallLog.Calls.CONTENT_TYPE
            }
            startActivity(intent)
        }

        btn4.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
            startActivity(intent)
        }

        btn5.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
                type = "image/*"
            }
            startActivity(intent)
        }

        btn6.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+91123456789"))
            startActivity(intent)
        }

        btn7.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+91123456789"))
            startActivity(intent)
        }
    }
}
