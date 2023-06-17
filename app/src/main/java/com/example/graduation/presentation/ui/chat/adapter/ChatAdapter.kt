package com.example.graduation.presentation.ui.chat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.graduation.databinding.ItemChatMeBinding
import com.example.graduation.databinding.ItemChatOtherBinding
import com.example.graduation.domain.model.MessageModel
import com.example.graduation.util.Constants.USER

private const val VIEW_TYPE_MY_MESSAGE = 1
private const val VIEW_TYPE_OTHER_MESSAGE = 2

class ChatAdapter :
    RecyclerView.Adapter<MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val chatMeBinding =
            ItemChatMeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val chatOtherBinding =
            ItemChatOtherBinding.inflate(LayoutInflater.from(parent.context), parent, false)


        return if (viewType == VIEW_TYPE_MY_MESSAGE) {
            MyMessageViewHolder(
                chatMeBinding,
                parent.context,
            )
        } else {
            OtherMessageViewHolder(
                chatOtherBinding,
                parent.context,
            )
        }

    }

    inner class MyMessageViewHolder(
        private val binding: ItemChatMeBinding,
        private val context: Context,
    ) : MessageViewHolder(binding.root) {

        override fun bind(message: MessageModel) {
            binding.message.text = message.messageText
        }
    }

    inner class OtherMessageViewHolder(
        private val binding: ItemChatOtherBinding,
        private val context: Context,
    ) : MessageViewHolder(binding.root) {

        override fun bind(message: MessageModel) {
            binding.message.text = message.messageText
        }
    }
    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.bind(differ.currentList[position])

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
    override fun getItemViewType(position: Int): Int {
        val message = differ.currentList[position]

        return if(USER == message.sender) {
            VIEW_TYPE_MY_MESSAGE
        }
        else {
            VIEW_TYPE_OTHER_MESSAGE
        }
    }

    private val callBack = object : DiffUtil.ItemCallback<MessageModel>() {
        override fun areItemsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MessageModel, newItem: MessageModel): Boolean {
            return oldItem == newItem
        }
    }
    var differ = AsyncListDiffer(this, callBack)


}