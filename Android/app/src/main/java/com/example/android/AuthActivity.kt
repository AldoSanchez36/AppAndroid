package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)






        //set up
        singUpButton.setOnClickListener {

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(emailEditTex.text.toString(),
                passwordEditText.text.toString()).addOnCompleteListener {
                    if(it.isSuccessful){
                        showHome(it.result?.user?.email ?:"",ProviderType.BASIC)

                    }
            }
        }

        logInButton.setOnClickListener{

            FirebaseAuth.getInstance().signInWithEmailAndPassword(emailEditTex.text.toString(),
                passwordEditText.text.toString()).addOnCompleteListener {
                if(it.isSuccessful){
                    showHome(it.result?.user?.email ?:"",ProviderType.BASIC)
                }
            }
        }



    }

    private fun showHome(email:String,usuario: ProviderType){

        val homeIntent = Intent(this,HomeActivity::class.java).apply {
            putExtra("email",email)
            putExtra("usuario",usuario.name)
        }
        startActivity(homeIntent)
    }


}