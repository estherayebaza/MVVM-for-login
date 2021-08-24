package com.example.project2.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.CoursesAdapter
import com.example.project2.R
import com.example.project2.ViewModel.CoursesViewModel
import com.example.project2.databinding.ActivityCoursesBinding
import com.example.project2.models.Course

class CoursesActivity : AppCompatActivity() {

    lateinit var binding: ActivityCoursesBinding
    val coursesViewModel: CoursesViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)

        binding = ActivityCoursesBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResume(){
        super.onResume()
        coursesViewModel.coursesLiveData.observe(this, { coursesResponse->

        })
    }
}
