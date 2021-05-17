package com.example.weekendtask.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weekendtask.R
import com.example.weekendtask.databinding.RowPostBinding
import com.example.weekendtask.repo.Posts
import javax.inject.Inject


class PostAdapter @Inject constructor() : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {
    private var posts: List<Posts>? = null
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): PostViewHolder {
        val rowPostBinding:RowPostBinding = DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            R.layout.row_post, viewGroup, false
        )
        return PostViewHolder(rowPostBinding)
    }

    override fun onBindViewHolder(postViewHolder: PostViewHolder, i: Int) {
        val currentStudent= posts!![i]
        postViewHolder.rowPostBinding.post=currentStudent
    }

    override fun getItemCount(): Int {
        return if (posts != null) {
            posts!!.size
        } else {
            0
        }
    }

    fun setPostList(employees: List<Posts>?) {
        this.posts = employees
        notifyDataSetChanged()
    }

    inner class PostViewHolder(rowPostBinding: RowPostBinding) :
        RecyclerView.ViewHolder(rowPostBinding.root) {
        val rowPostBinding: RowPostBinding = rowPostBinding
    }
}