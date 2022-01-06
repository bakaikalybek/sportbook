package kg.bakai.sportbook.presentation.login.login

import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kg.bakai.sportbook.R
import kg.bakai.sportbook.domain.model.FieldType
import kg.bakai.sportbook.domain.model.LoginItem
import kg.bakai.sportbook.domain.model.OnboardingItem

class LoginFieldsAdapter: RecyclerView.Adapter<LoginFieldsAdapter.LoginFieldsViewHolder>() {
    private val list = mutableListOf<LoginItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginFieldsViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_login_field, parent, false)
        return LoginFieldsViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: LoginFieldsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun submitItems(items: List<LoginItem>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    class LoginFieldsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val name = itemView.findViewById<TextView>(R.id.tv_login_field_name)
        private val field = itemView.findViewById<TextInputEditText>(R.id.et_login_field)

        fun bind(item: LoginItem) {
            name.text = item.name
            when (item.type) {
                FieldType.None -> {
                    field.isVisible = false
                }
                FieldType.Number -> {
                    field.isVisible = true
                    field.inputType = InputType.TYPE_CLASS_NUMBER
                }
                FieldType.Text -> {
                    field.isVisible = true
                    field.inputType = InputType.TYPE_CLASS_TEXT
                }
                FieldType.Double -> {
                    field.isVisible = true
                    field.inputType = InputType.TYPE_CLASS_PHONE
                }
            }
        }
    }
}