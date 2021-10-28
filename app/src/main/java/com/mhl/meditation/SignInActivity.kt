package com.mhl.meditation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.mhl.meditation.recadapters.login
import com.mhl.meditation.retroshit.ApiRet
import com.mhl.meditation.retroshit.MyRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInActivity : AppCompatActivity() {
    private lateinit var loginText : EditText
    private lateinit var passwordText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        loginText = findViewById(R.id.email)
        passwordText = findViewById(R.id.password)

    }

    fun Register(view: View) {}
    fun signin(view: View) {
        var login = loginText.text.toString()
        var password = passwordText.text.toString()
        if (login.isNotEmpty() && password.isNotEmpty()) {
            val log = MyRetrofit().getRetrofit()
            val logApi = log.create(ApiRet::class.java)
            var hashMap : HashMap<String, String> = HashMap<String, String>()
            hashMap.put("email", login)
            hashMap.put("password", password)
            val logCall : Call<login> = logApi.getAuth(hashMap)
            logCall.enqueue(object : Callback<login>{
                override fun onResponse(call: Call<login>, response: Response<login>) {
                    if (response.isSuccessful){
                        val intent = Intent(this@SignInActivity, MenuActivity::class.java)
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<login>, t: Throwable) {
                    Log.d("TAG", t.toString())
                }

            })
        }
        else{
            AlertDialog.Builder(this)
                .setTitle("Ошибка")
                .setMessage("У вас есть незаполненные поля")
                .setPositiveButton("Ok", null)
                .create()
                .show()
        }
    }
}