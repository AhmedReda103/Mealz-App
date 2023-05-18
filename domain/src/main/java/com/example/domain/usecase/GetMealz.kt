package com.example.domain.usecase

import com.example.domain.repo.MealsRepo

class GetMealz(private val mealzRepo: MealsRepo) {
    suspend operator fun invoke() = mealzRepo.getMealsFromRemote()
}