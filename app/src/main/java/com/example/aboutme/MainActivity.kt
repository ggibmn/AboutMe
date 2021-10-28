package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    private val myName: MyName = MyName("Project Name")

    //экземпляр класса myName
    private val myName: MyName = MyName("Project Name")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        //on clickListener
//        findViewById<Button>(R.id.done_button).setOnClickListener() {
//            addNickname(it)
//        }

        binding.doneButton.setOnClickListener() {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            nicknameText.text = binding.nicknameEdit.text
            invalidateAll() //Чтобы экран получил новые данные, надо снова передать биндингу измененный объект
            //change visibility of edit and done_button to GONE
            nicknameText.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }


        //hide keyboard after onClick
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}