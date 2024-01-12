package com.example.ppbmtubes

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.AdapterView
import com.example.ppbmtubes.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    private var dataArrayList = ArrayList<ListData?>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imageList = intArrayOf(
            R.drawable.burger,
            R.drawable.porridge,
            R.drawable.milkyyakult,
            R.drawable.friedrice,
            R.drawable.chickenkatsu,
            R.drawable.scrambleegg,
            R.drawable.bananamilk,
            R.drawable.friedchicken,

            )
        val ingredientList = intArrayOf(
            R.string.pastaIngredients,
            R.string.maggiIngredients,
            R.string.cakeIngredients,
            R.string.bootstrap,
            R.string.pancakeIngredients,
            R.string.pizzaIngredients,
            R.string.burgerIngredients,
            R.string.maya,


            )
        val descList = intArrayOf(
            R.string.pastaDesc,
            R.string.maggieDesc,
            R.string.cakeDesc,
            R.string.bootstrap,
            R.string.pancakeDesc,
            R.string.pizzaDesc,
            R.string.burgerDesc,
            R.string.mayaDesc

        )
        val nameList = arrayOf("Hamburger", "Porridge", "Milky Yakult", "Fried Rice", "Chicken Katsu", "Scramble Egg", "Banana Milk", "Fried Chicken")
        val timeList = arrayOf("Intermediate", "Basic", "Intermediate", "Intermediate","Advanced", "Basic", "Intermediate","Intermediate")
        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                timeList[i], ingredientList[i], descList[i], imageList[i]
            )
            dataArrayList.add(listData)
        }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true
        binding.listview.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val intent = Intent(this@MainActivity, DetailedActivity::class.java)
                intent.putExtra("name", nameList[i])
                intent.putExtra("time", timeList[i])
                intent.putExtra("ingredients", ingredientList[i])
                intent.putExtra("desc", descList[i])
                intent.putExtra("image", imageList[i])
                startActivity(intent)
            }

        // Bottom Navigation handling
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        bottomNavigationView.selectedItemId = R.id.bottom_course

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.bottom_home -> {
                    startActivity(Intent(applicationContext, MenuActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_profile -> {
                    startActivity(Intent(applicationContext, ProfileActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }
                R.id.bottom_course -> return@setOnItemSelectedListener true
                R.id.bottom_search -> {
                    startActivity(Intent(applicationContext, SearchActivity::class.java))
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    finish()
                    return@setOnItemSelectedListener true
                }

            }
            false
        }
    }
}