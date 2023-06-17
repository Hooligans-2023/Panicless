package com.example.graduation.presentation.ui.chat

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.graduation.base.BaseFragment
import com.example.graduation.databinding.FragmentChatBotBinding
import com.example.graduation.domain.model.MessageModel
import com.example.graduation.presentation.ui.chat.adapter.ChatAdapter
import com.example.graduation.util.Constants.BOT
import com.example.graduation.util.Constants.USER
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChatBot : BaseFragment() {
    private val TAG = "ChatBot"
    private val binding by lazy {
        FragmentChatBotBinding.inflate(layoutInflater)
    }

    override fun getRootView(): View = binding.root
    private val questionList = mutableListOf<MessageModel>()
    private val chatList = mutableListOf<MessageModel>()
    private var questionIndex = 0
    private var yesCount = 0
    private var noCount = 0
    private var adapter = ChatAdapter()

    override fun initVar() {
        initQuestionData()
        questionIndex = 0
        if (questionIndex < questionList.size)
            chatList.add(questionList[questionIndex])
        binding.run {
            recycleChat.adapter = adapter
            adapter.differ.submitList(chatList)
        }
    }

    override fun onEvent() {
        binding.run {
            btnSend.setOnClickListener {
                if (etMessage.text.toString().isNotEmpty()) {
                    if (etMessage.text.toString().lowercase().contains("nahed")) {
                        chatList.add(
                            MessageModel(
                                id = 51 + questionIndex,
                                byMe = true,
                                sender = USER,
                                messageText = etMessage.text.toString()
                            )
                        )
                        chatList.add(
                            MessageModel(
                                id = 51 + questionIndex,
                                byMe = true,
                                sender = BOT,
                                messageText = "I love you ♥"
                            )
                        )
                        val newChat = mutableListOf<MessageModel>()
                        newChat.addAll(chatList)
                        adapter = ChatAdapter()
                        adapter.differ.submitList(newChat)
                        etMessage.setText("")
                        recycleChat.post {
                            recycleChat.scrollToPosition(
                                recycleChat.adapter?.itemCount?.minus(1) ?: 0
                            )
                        }
                    } else {
                        chatList.add(
                            MessageModel(
                                id = 51 + questionIndex,
                                byMe = true,
                                sender = USER,
                                messageText = etMessage.text.toString()
                            )
                        )
                        if (etMessage.text.toString().lowercase() == "yes") {
                            yesCount++
                        } else
                            noCount++

                        questionIndex++
                        if (questionIndex < questionList.size)
                            chatList.add(questionList[questionIndex])
                        else if (questionIndex == questionList.size)
                            chatList.add(
                                MessageModel(
                                    id = 51 + questionIndex,
                                    byMe = true,
                                    sender = BOT,
                                    messageText = if (yesCount >= noCount) "You Should Consider Going To The Doctor" else "We Believe That There is No serious Concern For You To See The Doctor"
                                )
                            )
                            val newChat = mutableListOf<MessageModel>()
                            newChat.addAll(chatList)
                            adapter = ChatAdapter()
                            adapter.differ.submitList(newChat)
                            etMessage.setText("")
                            recycleChat.post {
                                recycleChat.scrollToPosition(
                                    recycleChat.adapter?.itemCount?.minus(1) ?: 0
                                )
                            }
                            Log.d(TAG, "onEvent: $chatList")


                    }
                }
            }
        }
    }

    override fun render() {
    }


    private fun initQuestionData() {
        questionList.add(
            MessageModel(
                id = 0,
                byMe = false,
                sender = BOT,
                messageText = "Q.1 Do you experience aches in your stomach before almost every courageous event?"
            )
        )
        questionList.add(
            MessageModel(
                id = 1,
                byMe = false,
                sender = BOT,
                messageText = "Q.2 Are you feeling overwhelmed and anxious right now?"
            )
        )
        questionList.add(
            MessageModel(
                id = 2,
                byMe = false,
                sender = BOT,
                messageText = "Q.3 Do you find it difficult in general to catch your breath?"
            )
        )
        questionList.add(
            MessageModel(
                id = 3,
                byMe = false,
                sender = BOT,
                messageText = "Q.4 Do you experience excessive sweating?"
            )
        )
        questionList.add(
            MessageModel(
                id = 4,
                byMe = false,
                sender = BOT,
                messageText = "Q.5 Do you find it difficult to focus on tasks or stay attentive?"
            )
        )
        questionList.add(
            MessageModel(
                id = 5,
                byMe = false,
                sender = BOT,
                messageText = "Q.6 Do you have trouble falling asleep most nights or suddenly falling asleep during the day?"
            )
        )
        questionList.add(
            MessageModel(
                id = 6,
                byMe = false,
                sender = BOT,
                messageText = "Q.7 Are you facing challenges or difficulties in completing your work tasks effectively?"
            )
        )
        questionList.add(
            MessageModel(
                id = 7,
                byMe = false,
                sender = BOT,
                messageText = "Q.8 Does the feeling of hopelessness haunt you when you encounter difficulties in certain situations?"
            )
        )
        questionList.add(
            MessageModel(
                id = 8,
                byMe = false,
                sender = BOT,
                messageText = "Q.9 Do you easily get angry over simple things?"
            )
        )
        questionList.add(
            MessageModel(
                id = 9,
                byMe = false,
                sender = BOT,
                messageText = "Q.10 Do you find yourself reacting in an extreme manner to certain situations?"
            )
        )
        questionList.add(
            MessageModel(
                id = 10,
                byMe = false,
                sender = BOT,
                messageText = "Q.11 Have you noticed a significant change in your eating patterns recently?"
            )
        )
        questionList.add(
            MessageModel(
                id = 11,
                byMe = false,
                sender = BOT,
                messageText = "Q.12 Have you been experiencing thoughts of wanting to end your own life?"
            )
        )
        questionList.add(
            MessageModel(
                id = 12,
                byMe = false,
                sender = BOT,
                messageText = "Q.13 Are you constantly feeling exhausted and lacking energy?"
            )
        )
        questionList.add(
            MessageModel(
                id = 13,
                byMe = false,
                sender = BOT,
                messageText = "Q.14 Do you feel like you're lonely and don't have any close friends?"
            )
        )
        questionList.add(
            MessageModel(
                id = 14,
                byMe = false,
                sender = BOT,
                messageText = "Q.15 Do you find yourself spending excessive amounts of time on social media?"
            )
        )
        questionList.add(
            MessageModel(
                id = 15,
                byMe = false,
                sender = BOT,
                messageText = "Q.16 Have you noticed a significant increase in your body weight recently?"
            )
        )
        questionList.add(
            MessageModel(
                id = 16,
                byMe = false,
                sender = BOT,
                messageText = "Q.17 Do you feel a strong attachment to certain objects and find it difficult to let go of them?"
            )
        )
        questionList.add(
            MessageModel(
                id = 18,
                byMe = false,
                sender = BOT,
                messageText = "Q.18 Do you often prefer spending time alone rather than being in social gatherings?"
            )
        )
        questionList.add(
            MessageModel(
                id = 19,
                byMe = false,
                sender = BOT,
                messageText = "Q.19 Do you frequently find yourself involuntarily reliving stressful or traumatic memories?"
            )
        )
        questionList.add(
            MessageModel(
                id = 20,
                byMe = false,
                sender = BOT,
                messageText = "Q.20 Do you frequently experience nightmares?"
            )
        )
        questionList.add(
            MessageModel(
                id = 21,
                byMe = false,
                sender = BOT,
                messageText = "Q.21 Do you tend to purposefully avoid certain people or activities?"
            )
        )
        questionList.add(
            MessageModel(
                id = 22,
                byMe = false,
                sender = BOT,
                messageText = "Q.22 Do you often find yourself overwhelmed by negative emotions?"
            )
        )
        questionList.add(
            MessageModel(
                id = 23,
                byMe = false,
                sender = BOT,
                messageText = "Q.23 Do you frequently struggle to maintain focus or concentrate on tasks?"
            )
        )
        questionList.add(
            MessageModel(
                id = 24,
                byMe = false,
                sender = BOT,
                messageText = "Q.24 Do you tend to blame yourself for negative outcomes or mistakes, even when they may not be entirely your fault?"
            )
        )


    }

    override fun navigate() {
    }

    override fun showEffect() {
    }


}
