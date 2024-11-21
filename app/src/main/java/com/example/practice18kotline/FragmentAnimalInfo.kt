package com.example.practice18kotline

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentAnimalInfo : Fragment() {

    private lateinit var animalImage: ImageView
    private lateinit var animalInfo: TextView
    private lateinit var showBreedsButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_animal_info, container, false)
        animalImage = view.findViewById(R.id.animal_image)
        animalInfo = view.findViewById(R.id.animal_info)
        showBreedsButton = view.findViewById(R.id.show_breeds_button)
        return view
    }

    fun showAnimalInfo(animalType: String, imageResId: Int, textResId: Int) {
        animalImage.setImageResource(imageResId)
        animalImage.visibility = View.VISIBLE

        animalInfo.setText(textResId)
        animalInfo.visibility = View.VISIBLE

        showBreedsButton.visibility = View.VISIBLE
        showBreedsButton.setOnClickListener {
            (activity as? MainActivity)?.showBreeds(animalType)
        }
    }

    fun updateAnimalInfo(breed: String?) {
        if (breed == null) return

        val imageResId: Int
        val textResId: Int

        when (breed) {
            "Британская короткошерстная" -> {
                imageResId = R.drawable.cat_british
                textResId = R.string.cat_british
            }
            "Сиамская кошка" -> {
                imageResId = R.drawable.cat_siamese
                textResId = R.string.cat_siamese
            }
            "Немецкая овчарка" -> {
                imageResId = R.drawable.dog_german
                textResId = R.string.dog_german
            }
            "Лабрадор" -> {
                imageResId = R.drawable.dog_labrador
                textResId = R.string.dog_labrador
            }
            else -> {
                imageResId = 0
                textResId = R.string.unknown_animal
            }
        }

        if (imageResId != 0) {
            animalImage.setImageResource(imageResId)
            animalImage.visibility = View.VISIBLE
        } else {
            animalImage.visibility = View.GONE
        }

        animalInfo.setText(textResId)
        animalInfo.visibility = View.VISIBLE
        showBreedsButton.visibility = View.GONE
    }
}
