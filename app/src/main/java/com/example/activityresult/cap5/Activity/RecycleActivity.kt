package com.example.activityresult.cap5.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.activityresult.R
import com.example.activityresult.cap123.showShortToast
import com.example.activityresult.cap5.Adapter.MessageAdapter
import com.example.activityresult.cap5.Data.Message
import kotlinx.android.synthetic.main.activity_recycle.*

class RecycleActivity : AppCompatActivity() {
    private var messages = mutableListOf<Message>()
    private var adapter = MessageAdapter(messages, this::onMessageItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        lastCustomNonConfigurationInstance.let { savedMessages ->
            if (savedMessages is MutableList<*>) {
                messages.addAll(savedMessages.filterIsInstance(Message::class.java))
            }
        }

        initRecycleView()
        fabAdd.setOnClickListener {
            addMessage()
        }
        initSwipeGesture()
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return messages
    }

    private fun initRecycleView() {
        rcMessages.adapter = adapter
        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 2 else 1
            }
        }
        rcMessages.layoutManager = layoutManager
    }

    private fun addMessage() {
        val message = Message(
                title = edtTitleMessage.text.toString(),
                text = edtTextMessage.text.toString()
        )
        messages.add(message)
        adapter.notifyItemInserted(messages.lastIndex)
        edtTextMessage.text?.clear()
        edtTitleMessage.text?.clear()
        edtTitleMessage.requestFocus()
    }

    private fun onMessageItemClick(message: Message) {
        val msg = "${message.title}\n${message.text}"
        showShortToast(msg)
    }

    private fun initSwipeGesture() {
        val swipe = object : ItemTouchHelper.SimpleCallback(
                0, //Posições permitidas para mover a view. zero = nenhuma
                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT //Posições de swipe
        ) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = false //Não permite mover itens

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                messages.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipe)
        itemTouchHelper.attachToRecyclerView(rcMessages)
    }
}