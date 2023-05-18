package com.example.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.hamalawey.mealz.MealsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private val mealsViewModel: MealsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            val rv :RecyclerView = findViewById(R.id.category_rv)
            val mealsAdapter = MealsAdapter()

            mealsViewModel.getMeals()
            lifecycleScope.launch {
                mealsViewModel.categories.collectLatest {
                    mealsAdapter.submitList(it?.categories)
                    rv.adapter = mealsAdapter
                }
            }



    }
}