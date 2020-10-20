package com.develop.mycalculater

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buNumberEvent(view:View){

        if (isNewOp==true){
            edt_showNumber.setText("")
        }
        isNewOp = false

        val buSelect = view as Button
        var buClickValue:String = edt_showNumber.text.toString()

        when(buSelect.id){
              btn_zero.id->{
                  buClickValue += "0"
              }
            btn_1.id->{
                buClickValue += "1"
            }
            btn_2.id->{
                buClickValue += "2"
            }
            btn_3.id->{
                buClickValue += "3"
            }
            btn_4.id->{
                buClickValue += "4"
            }
            btn_5.id->{
                buClickValue += "5"
            }
            btn_6.id->{
                buClickValue += "6"
            }
            btn_7.id->{
                buClickValue += "7"
            }
            btn_8.id->{
                buClickValue += "8"
            }
            btn_9.id->{
                buClickValue += "9"
            }
            btn_dot.id ->{
                buClickValue +="."
            }
            btn_plus_minus.id ->{
                buClickValue = "-"+ buClickValue
            }
        }
        edt_showNumber.setText(buClickValue)
    }

    var op ="*"
    var oldNumber =""
    var isNewOp = true

    fun buOptionEvent(view: View){
        val buSelect = view as Button

        when(buSelect.id) {
            btn_divide.id -> {
           op= "/"
        }
            btn_multiply.id -> {
              op="*"
            }
            btn_minus.id -> {
               op="-"
            }
            btn_plus.id -> {
               op="+"
            }
        }
        oldNumber= edt_showNumber.text.toString()
        isNewOp = true
    }

    fun buEqualEvent(view:View){
        var newNumber = edt_showNumber.text.toString()

        var finalNumer:Double?=null

        when(op){
            "/"->{
            finalNumer= oldNumber.toDouble() / newNumber.toDouble()
            }
            "*"->{
                finalNumer= oldNumber.toDouble() * newNumber.toDouble()
            }
            "-"->{
                finalNumer= oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->{
                finalNumer= oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        edt_showNumber.setText(finalNumer.toString())
        isNewOp = true
    }

    fun buPercent(view: View){
        var number:Double = edt_showNumber.text.toString().toDouble()/100
        edt_showNumber.setText(number.toString())
        isNewOp=true
    }

    fun buClean(view: View){
        edt_showNumber.setText("0")
        isNewOp=true
    }
}