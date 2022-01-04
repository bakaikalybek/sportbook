package kg.bakai.sportbook.presentation.login.onboarding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kg.bakai.sportbook.R
import kg.bakai.sportbook.domain.model.OnboardingItem

class OnboardingAdapter: RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder>() {
    private val list = mutableListOf<OnboardingItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnboardingViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_onboarding, parent, false)
        return OnboardingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OnboardingViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitItems(items: List<OnboardingItem>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    class OnboardingViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val image = itemView.findViewById<ImageView>(R.id.img_onboarding)
        private val title = itemView.findViewById<TextView>(R.id.tv_title)
        private val description = itemView.findViewById<TextView>(R.id.tv_description)

        fun bind(item: OnboardingItem) {
            Glide.with(itemView)
                .load(item.image)
                .into(image)

            title.text = item.title
            description.text = item.description
        }
    }
}