// package com.judahben149.listfromrestapi

// import android.content.Context
// import android.view.LayoutInflater
// import android.view.ViewGroup
// import androidx.recyclerview.widget.RecyclerView
// import com.judahben149.listfromrestapi.databinding.ListItemBinding
// import com.judahben149.listfromrestapi.model.PostItem

// class ListAdapter(val context: Context, val postItem: List<PostItem>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {


//     class ListViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
//         val userName = binding.nameField
//     }

//     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
//         val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false )
//         return ListViewHolder(binding)
//     }

//     override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
//         holder.userName.text = postItem[position].title
//     }

//     override fun getItemCount() = postItem.size
// }
