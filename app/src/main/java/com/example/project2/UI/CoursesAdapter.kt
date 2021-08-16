package com.example.project2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.models.Course

class CoursesAdapter(var courseList: List<Course>):RecyclerView.Adapter<CoursesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesViewHolder {
        var itemView=LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CoursesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesViewHolder, position: Int) {
     var currentCourse=courseList.get(position)
        holder.tvCourseName.text=currentCourse.courseName
        holder.tvCourseCode.text=currentCourse.courseCode
        holder.tvCourseDescription.text=currentCourse.courseDescription
        holder.tvCourseInstructor.text=currentCourse.instructor

    }

    override fun getItemCount(): Int {
      return courseList.size
    }
}
class CoursesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvCourseName=itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvCourseCode=itemView.findViewById<TextView>(R.id.tvCourseCode)
    var tvCourseDescription=itemView.findViewById<TextView>(R.id.tvCourseDescription)
    var tvCourseInstructor=itemView.findViewById<TextView>(R.id.tvInstructor)



}