package com.azatberdimyradov.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.azatberdimyradov.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var buttons = hashMapOf<Int, Button>()
    private val textList = arrayListOf<String>()
    private var order = true
    private val PLAYER_ONE = "X"
    private val PLAYER_TWO = "O"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            buttons[1] = button1
            buttons[2] = button2
            buttons[3] = button3
            buttons[4] = button4
            buttons[5] = button5
            buttons[6] = button6
            buttons[7] = button7
            buttons[8] = button8
            buttons[9] = button9
        }

    }

    fun retryClick(view: View) {
        println("ok")
        binding.apply {
            retryButton.isVisible = false
            textWinner.isVisible = false
            order = true
            for (i in 1..9) {
                buttons[i]?.isEnabled = true
                buttons[i]?.text = ""
            }
        }
    }

    fun click(view: View) {
        if ((view as Button).text.equals("")) {
            if (order) {
                view.text = PLAYER_ONE
                order = false
            } else {
                view.text = PLAYER_TWO
                order = true
            }
            if (checkWin()) {
                retry(view.text.toString())
            }
        }
    }

    private fun retry(winner: String) {
        binding.apply {
            retryButton.isVisible = true
            textWinner.isVisible = true
            textWinner.text = "Winner: $winner"
            for (i in 1..9) {
                buttons[i]?.isEnabled = false
            }
        }
    }

    fun checkWin(): Boolean {
        textList.clear()
        for (i in 1..9) {
            textList.add(buttons[i]?.text.toString())
        }
        if (textList[0].equals(textList[1]) && textList[0].equals(textList[2]) && !textList[0].equals("")) {
            return true
        }
        if (textList[3].equals(textList[4]) && textList[3].equals(textList[5]) && !textList[3].equals("")) {
            return true
        }
        if (textList[6].equals(textList[7]) && textList[6].equals(textList[8]) && !textList[6].equals("")) {
            return true
        }
        if (textList[0].equals(textList[4]) && textList[0].equals(textList[8]) && !textList[0].equals("")) {
            return true
        }
        if (textList[1].equals(textList[4]) && textList[1].equals(textList[7]) && !textList[1].equals("")) {
            return true
        }
        if (textList[2].equals(textList[5]) && textList[2].equals(textList[8]) && !textList[2].equals("")) {
            return true
        }
        if (textList[0].equals(textList[3]) && textList[0].equals(textList[6]) && !textList[0].equals("")) {
            return true
        }
        if (textList[2].equals(textList[4]) && textList[2].equals(textList[6]) && !textList[2].equals("")) {
            return true
        }
        return false
    }
}