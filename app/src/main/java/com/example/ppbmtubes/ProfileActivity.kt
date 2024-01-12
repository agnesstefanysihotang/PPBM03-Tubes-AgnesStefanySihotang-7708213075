package com.example.ppbmtubes

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ppbmtubes.databinding.ActivityProfileBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProfileActivity : AppCompatActivity() {

    // ... (kode yang sudah ada)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_home -> {
                    startActivity(Intent(applicationContext, MenuActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_profile -> {
                    // Do nothing if already in the ProfileActivity
                    return@setOnItemSelectedListener true
                }



                R.id.bottom_search -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_course -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }

        // ... (kode yang sudah ada)

        val buttonClick = findViewById<ImageView>(R.id.btnback)
        buttonClick.setOnClickListener {
            val intent = Intent(this, MenuActivity::class.java)
            startActivity(intent)
            finish()
        }

        val buttonlogout = findViewById<TextView>(R.id.btnlogout)
        buttonlogout.setOnClickListener {
            val intent = Intent(this, LoginSignup::class.java)
            startActivity(intent)
            finish()
        }

        val someTextView = findViewById<TextView>(R.id.switchacc)
        someTextView.setOnClickListener {
            showBottomDialog()
        }
    }

    private fun showBottomDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.bottomsheetlayout)

        val videoLayout: LinearLayout = dialog.findViewById(R.id.layoutVideo)
        val shortsLayout: LinearLayout = dialog.findViewById(R.id.layoutShorts)
        val liveLayout: LinearLayout = dialog.findViewById(R.id.layoutLive)
        val cancelButton: ImageView = dialog.findViewById(R.id.cancelButton)

        videoLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Profile 1 is clicked", Toast.LENGTH_SHORT).show()
            // Pindah ke aktivitas yang sesuai untuk profil 1

        }

        shortsLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Profile 2 is Clicked", Toast.LENGTH_SHORT).show()
            // Pindah ke aktivitas yang sesuai untuk profil 2
            startActivity(Intent(this, Profile2Activity::class.java))
        }

        liveLayout.setOnClickListener {
            dialog.dismiss()
            Toast.makeText(this, "Add Profile is Clicked", Toast.LENGTH_SHORT).show()
            // Tambahkan kode sesuai kebutuhan untuk Go live
            startActivity(Intent(this, LoginSignup::class.java))
        }

        cancelButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.attributes?.windowAnimations = R.style.DialogAnimation
        dialog.window?.setGravity(Gravity.BOTTOM)
    }
}