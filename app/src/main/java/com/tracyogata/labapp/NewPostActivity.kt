package com.tracyogata.labapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.tracyogata.labapp.Models.Post
import kotlinx.android.synthetic.main.popup_add_post.*

class NewPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_post)

        val postButton = findViewById(R.id.post_button) as Button
        postButton.setOnClickListener()
        {
            var post:Post = Post(popup_title.text.toString(), popup_description.text.toString())
            addPost(post);
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this@NewPostActivity, "Uploading...", Toast.LENGTH_SHORT).show()

        }

    }

    private fun addPost(post:Post) {
        var database:FirebaseDatabase ;
        database = FirebaseDatabase.getInstance();
        var myRef: DatabaseReference;
        myRef = database.getReference("Posts").push();

        //get post ID and update post key
        var key = myRef.getKey();
        post.setPostKey(key);

        //add post data to firebase database

        myRef.setValue(post)

    }
}










