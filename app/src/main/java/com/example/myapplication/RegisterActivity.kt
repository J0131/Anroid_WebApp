package com.example.myapplication

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        var isExistBlank = false // edit_text를 비웠는지 확인하는 변수
        var isPwSame = false // 기입한 비밀번호와 재입력한 비밀번호가 같은지 확인하는 변수

        val registerButton : Button = findViewById<Button>(R.id.okay);
        val cancelButton : Button = findViewById<Button>(R.id.cancel)

        val registerIntent = Intent(this,RegisterActivity::class.java)
        val cancelIntent = Intent(this, loginActivity::class.java)

        registerButton.setOnClickListener(
            View.OnClickListener {
                //startActivity()
                val id = id.text.toString()
                val pw = password1.text.toString()
                val pw2 = password2.text.toString()

                if(id.isEmpty() || pw.isEmpty() || pw2.isEmpty())
                // 아이디를 비우거나, 비밀번호를 비우거나, 비밀번호 확인을 비웠을 때
                {
                    isExistBlank = true
                }
                else{
                    if (pw == pw2)
                    {
                        isPwSame = true
                    }
                }

                if(!isExistBlank && isPwSame)
                {
                   // 회원가입 성공 토스트 메세지 띄우기
                    Toast.makeText(this, "회원가입 성공!!", Toast.LENGTH_SHORT).show()

                    // 유저가 입력한 id, pw를 쉐어드 프리퍼런스에 저장
                    val sharedPreference = getSharedPreferences("file name", Context.MODE_PRIVATE)
                    val editor = sharedPreference.edit()

                    editor.putString("id",id)
                    editor.putString("pw",pw)
                    editor.apply()

                    // 로그인 화면으로 이동
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }

                else{

                    if(isExistBlank)
                    {
                        dialog("blank")
                    }
                    else if(!isPwSame)
                    {
                        dialog("not same")
                    }
                }
            }
       )

        cancelButton.setOnClickListener(
            View.OnClickListener {
            startActivity(cancelIntent)
        })
    }


    fun dialog(type : String)
    {
        val dialog = AlertDialog.Builder(this)

        if(type.equals("blank"))
        {
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("입력란을 모두 작성해주세요")
        }

        else if(type.equals("not same"))
        {
            dialog.setTitle("회원가입 실패")
            dialog.setMessage("비밀번호가 다릅니다.")
        }

        val dialog_listener = object: DialogInterface.OnClickListener{
            override fun onClick(dialog: DialogInterface?, which: Int) {
                when(which)
                {
                    DialogInterface.BUTTON_POSITIVE ->
                        Log.d("Register","다이얼로그")
                }
            }
        }

        dialog.setPositiveButton("확인",dialog_listener)
        dialog.show()
    }

    override fun toString(): String {
        return super<AppCompatActivity>.toString()
    }
    val a = 3


}