package com.example.otp_edit_text

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.otp_edit_text.databinding.OtpEditTextBinding

class OtpEditText : ConstraintLayout {

    private lateinit var binding: OtpEditTextBinding

    private lateinit var inputOTP1: EditText
    private lateinit var inputOTP2: EditText
    private lateinit var inputOTP3: EditText
    private lateinit var inputOTP4: EditText

    constructor(context: Context) : super(context) {
        //init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet) {
        val inflater = LayoutInflater.from(context)
        binding = OtpEditTextBinding.inflate(inflater, this, true)

        inputOTP1 = binding.Text1
        inputOTP2 = binding.Text2
        inputOTP3 = binding.Text3
        inputOTP4 = binding.Text4

        addTextChangeListener()
    }

    private fun addTextChangeListener() {
        inputOTP1.addTextChangedListener(EditTextWatcher(inputOTP1))
        inputOTP2.addTextChangedListener(EditTextWatcher(inputOTP2))
        inputOTP3.addTextChangedListener(EditTextWatcher(inputOTP3))
        inputOTP4.addTextChangedListener(EditTextWatcher(inputOTP4))
    }

    fun getText(): String {
        return inputOTP1.text.toString() + inputOTP2.text.toString() + inputOTP3.text.toString() + inputOTP4.text.toString()
    }

    fun Clear(){
        inputOTP1.setText("")
        inputOTP2.setText("")
        inputOTP3.setText("")
        inputOTP4.setText("")
        inputOTP1.requestFocus()
    }

    inner class EditTextWatcher(private val editText: EditText) : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        override fun afterTextChanged(p0: Editable?) {
            val text = p0.toString()
            val textid = editText.id

            if(textid==R.id.Text1){
                if(text.length==1){
                    if(inputOTP2.text.isEmpty())
                        inputOTP2.requestFocus()
                    else if(inputOTP3.text.isEmpty())
                        inputOTP3.requestFocus()
                    else
                        inputOTP4.requestFocus()
                }
                else if(text.length>1){
                    val otp = text
                    inputOTP1.setText(otp[0].toString())

                    if(text.length==3){
                        inputOTP2.setText(otp[1].toString())
                        inputOTP3.setText(otp[2].toString())
                        inputOTP4.requestFocus()
                    }else if(text.length==4){
                        inputOTP2.setText(otp[1].toString())
                        inputOTP3.setText(otp[2].toString())
                        inputOTP4.setText(otp[3].toString())
                        inputOTP4.setSelection(inputOTP4.text.length)
                    }else if(inputOTP2.text.isEmpty()){
                        inputOTP2.setText(otp[1].toString())
                        inputOTP3.requestFocus()
                    }else if(inputOTP3.text.isEmpty())
                        inputOTP3.requestFocus()
                    else
                        inputOTP4.requestFocus()
                }
            }

            if(textid==R.id.Text2){
                if(text.length==1){
                    if(inputOTP3.text.isEmpty())
                        inputOTP3.requestFocus()
                    else
                        inputOTP4.requestFocus()
                }else if(text.length>1){
                    val otp = text
                    inputOTP2.setText(otp[0].toString())
                    if(inputOTP3.text.isEmpty()){
                        inputOTP3.setText(otp[1].toString())
                    }
                    inputOTP4.requestFocus()
                }
                else if (text.isEmpty() && inputOTP3.text.isEmpty()){
                    inputOTP1.requestFocus()
                    inputOTP1.setSelection(inputOTP1.text.length)
                }
            }

            if(textid==R.id.Text3){
                if(text.length==1){
                    inputOTP4.requestFocus()
                }
                else if(text.length>1){
                    val otp = text
                    inputOTP3.setText(otp[0].toString())
                    if(inputOTP4.text.isEmpty()){
                        inputOTP4.setText(otp[1].toString())
                    }
                    inputOTP4.requestFocus()
                }
                else if (text.isEmpty() && inputOTP4.text.isEmpty()){
                    inputOTP2.requestFocus()
                    inputOTP2.setSelection(inputOTP2.text.length)
                }
            }

            if(textid==R.id.Text4){
                if(text.isEmpty()){
                    inputOTP3.requestFocus()
                }
            }
        }
    }
}