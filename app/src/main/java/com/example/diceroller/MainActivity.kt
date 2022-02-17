package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
//            val toast = Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT)
//            toast.show()
            //Similar to
//            Toast.makeText(this, "Dice Rolled!", Toast.LENGTH_SHORT).show()
//            val resultTextView : TextView = findViewById(R.id.textView)
//            resultTextView.text = "6"
            rollDice()
        }

    }

    /**
     * Roll the dice and update the screen with the result.
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)
        when (diceRoll) {
            1 -> diceImage.setImageResource(R.drawable.dice_1)
            2 -> diceImage.setImageResource(R.drawable.dice_2)
            3 -> diceImage.setImageResource(R.drawable.dice_3)
            4 -> diceImage.setImageResource(R.drawable.dice_4)
            5 -> diceImage.setImageResource(R.drawable.dice_5)
            6 -> diceImage.setImageResource(R.drawable.dice_6)
        }
        // Update the content description
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(val numSides: Int) {
        fun roll(): Int {
            return (1..6).random()
        }
    }
}






