package com.example.practice18kotline

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), FragmentAnimalList.OnAnimalSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Загружаем список животных
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_list, FragmentAnimalList())
                .commit()

            // Загружаем пустую информацию
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_info, FragmentAnimalInfo())
                .commit()
        }
    }

    override fun onAnimalSelected(breedOrAnimal: String?) {
        if (breedOrAnimal == null) return

        val fragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container_info) as? FragmentAnimalInfo

        if (breedOrAnimal == "Кошка") {
            fragment?.showAnimalInfo("Кошка", R.drawable.cat_general, R.string.cat_general)
        } else if (breedOrAnimal == "Собака") {
            fragment?.showAnimalInfo("Собака", R.drawable.dog_general, R.string.dog_general)
        } else {

            fragment?.updateAnimalInfo(breedOrAnimal)
        }
    }

    fun showBreeds(animalType: String) {
        val breeds = when (animalType) {
            "Кошка" -> arrayOf("Британская короткошерстная", "Сиамская кошка")
            "Собака" -> arrayOf("Немецкая овчарка", "Лабрадор")
            else -> emptyArray()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_list, FragmentAnimalList.newInstance(breeds))
            .commit()
    }
}