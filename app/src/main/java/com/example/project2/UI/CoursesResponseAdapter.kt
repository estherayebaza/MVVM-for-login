import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project2.R
import com.example.project2.models.CoursesResponse

class CoursesResponseAdapter (var courseResponse: List<CoursesResponse>): RecyclerView.Adapter<CoursesResponseViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoursesResponseViewHolder {
        var itemView = LayoutInflater.from(parent.context).inflate(R.layout.course_list_item, parent, false)
        return CoursesResponseViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CoursesResponseViewHolder, position: Int) {
        var courseList = courseResponse.get(position)
        holder.tvDateCreated.text = courseList.date_created
        holder.tvDateUpdated.text = courseList.date_updated
        holder.tvUpdatedBy.text = courseList.updated_by
        holder.tvCourseId.text = courseList.course_id
        holder.tvCoursename.text = courseList.course_name
        holder.tvCourseCode.text = courseList.course_code
        holder.tvCourseDescription.text = courseList.description
        holder.tvCreatedBy.text = courseList.created_by
        holder.tvActive.text = courseList.active.toString()
        holder.tvInstructor.text  = courseList.instructor
    }

    override fun getItemCount(): Int {
        return courseResponse.size
    }
}

class CoursesResponseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
    var tvDateCreated = itemView.findViewById<TextView>(R.id.tvDate)
    var tvDateUpdated = itemView.findViewById<TextView>(R.id.tvUpdatedBy)
    var tvUpdatedBy = itemView.findViewById<TextView>(R.id.tvUpdatedBy)
    var tvCourseId = itemView.findViewById<TextView>(R.id.tvCourseCode)
    var tvCoursename = itemView.findViewById<TextView>(R.id.tvCourseName)
    var tvCourseCode = itemView.findViewById<TextView>(R.id.tvCourseCode)
    var tvCourseDescription = itemView.findViewById<TextView>(R.id.tvDescription)
    var tvCreatedBy = itemView.findViewById<TextView>(R.id.tvCreatedBy)
    var tvActive = itemView.findViewById<TextView>(R.id.tvActive)
    var tvInstructor = itemView.findViewById<TextView>(R.id.tvCourseInstructor)
}