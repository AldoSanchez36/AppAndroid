package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*
import kotlinx.android.synthetic.main.activity_home.*

enum class ProviderType{
    BASIC
}


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val bundle:Bundle?= intent.extras
        val email =bundle?.getString("email")
        val usuario = bundle?.getString("usuario")
        setup(email?:"",usuario?:"")
    }

    private fun setup(email:String,usuario: String){

        emailTextView.text = email
        usuarioTextView.text = usuario
        logOutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }


}