package com.example.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setonclicklistner for numbers
        tvOne.setOnClickListener { appendOnExpression("1" , true) }
        tvTwo.setOnClickListener { appendOnExpression("2" , true) }
        tvThree.setOnClickListener { appendOnExpression("3" , true) }
        tvFour.setOnClickListener { appendOnExpression("4" , true) }
        tvFive.setOnClickListener { appendOnExpression("5" , true) }
        tvSix.setOnClickListener { appendOnExpression("6" , true) }
        tvSeven.setOnClickListener { appendOnExpression("7" , true) }
        tvEight.setOnClickListener { appendOnExpression("8" , true) }
        tvNine.setOnClickListener { appendOnExpression("9" , true) }
        tvZero.setOnClickListener { appendOnExpression("0" , true) }
        tvPoint.setOnClickListener { appendOnExpression("." , true) }

        //setonclicklistener for Operatoes

        tvAdd.setOnClickListener { appendOnExpression("+" , false) }
        tvSub.setOnClickListener { appendOnExpression("-" , false) }
        tvMul.setOnClickListener { appendOnExpression("*" , false) }
        tvDiv.setOnClickListener { appendOnExpression("/" , false) }
        tvOpen.setOnClickListener { appendOnExpression("(" , false) }
        tvClose.setOnClickListener { appendOnExpression(")" , false) }

        tvClear.setOnClickListener {
            tvExp.text = ""
            tvres.text = ""
        }

        tvBack.setOnClickListener {
            val string = tvExp.text.toString()
            if(string.isNotEmpty())
            {
                tvExp.text = string.substring(0 , string.length-1)
            }
            tvres.text = ""
        }

        tvEquals.setOnClickListener {
            try {
                    val expression = ExpressionBuilder(tvExp.text.toString()).build()
                    val result = expression.evaluate()
                    val LongResult = result.toLong()
                    if(result == LongResult.toDouble())
                    {
                        tvres.text = LongResult.toString()
                    }
                    else{
                        tvres.text = result.toString()
                    }
            }
                        catch (e:Exception){
                        Log.d("Exception" ,"message : "  + e.message )
                }
            }
    }

    fun appendOnExpression(string: String , canClear : Boolean)
    {
        if(tvres.text.isNotEmpty())
        {
            tvExp.text = ""
        }
        if(canClear)
        {
            tvres.text = ""
            tvExp.append(string)
        }
        else{
            tvExp.append(tvres.text)
            tvExp.append(string)
            tvres.text = ""
        }

    }


}
