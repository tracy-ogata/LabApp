package com.tracyogata.labapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*
import com.tracyogata.labapp.Models.Post


class MainActivity : AppCompatActivity() {

    lateinit var mrecylerview : RecyclerView
    lateinit var ref: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //initialize recyclerview and FIrebase objects
        mrecylerview = findViewById<RecyclerView>(R.id.recyclerview)
        val llm = LinearLayoutManager(this)
        llm.stackFromEnd = true
        llm.reverseLayout = true
        mrecylerview.layoutManager = llm
        mrecylerview.setHasFixedSize(true)
        ref = FirebaseDatabase.getInstance().getReference().child("Posts")

        val newPostButton = findViewById(R.id.newPost_button) as Button
        newPostButton.setOnClickListener()
        {
            val intent = Intent(this, NewPostActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@MainActivity, "New Post", Toast.LENGTH_SHORT).show()
        }

        firebaseData()

    }


    fun firebaseData() {


        val option = FirebaseRecyclerOptions.Builder<Post>()
            .setQuery(ref, Post::class.java)
            .setLifecycleOwner(this)
            .build()


        val firebaseRecyclerAdapter = object: FirebaseRecyclerAdapter<Post, MyViewHolder>(option) {


            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val itemView = LayoutInflater.from(this@MainActivity).inflate(R.layout.card_items,parent,false)
                return MyViewHolder(itemView)
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: Post) {
                val placeid = getRef(position).key.toString()

                ref.child(placeid).addValueEventListener(object: ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        Toast.makeText(this@MainActivity, "Error Occurred "+ p0.toException(), Toast.LENGTH_SHORT).show()

                    }

                    override fun onDataChange(p0: DataSnapshot) {

                        holder.txt_name.setText(model.title)
                        holder.desc_name.setText(model.description)

                    }
                })
            }
        }
        mrecylerview.adapter = firebaseRecyclerAdapter
        firebaseRecyclerAdapter.startListening()
    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        internal var txt_name: TextView = itemView!!.findViewById<TextView>(R.id.post_title_txtview)
        internal var desc_name: TextView = itemView!!.findViewById<TextView>(R.id.post_desc_txtview)


    }


}
