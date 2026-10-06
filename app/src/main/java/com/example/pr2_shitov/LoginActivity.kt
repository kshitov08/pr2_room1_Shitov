package com.example.pr2_shitov

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

        val editLogin = findViewById<EditText>(R.id.editTextLogin)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val btnRegister = findViewById<Button>(R.id.buttonRegister)

        val savedLogin = prefs.getString("login", "")
        if (!savedLogin.isNullOrEmpty()) {
            editLogin.setText(savedLogin)
        }

        btnRegister.setOnClickListener {
            val login = editLogin.text.toString().trim()
            val password = editPassword.text.toString().trim()

            if (login.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (login == "ects" && password == "ects2023") {
                prefs.edit().putString("login", login).apply()

                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}