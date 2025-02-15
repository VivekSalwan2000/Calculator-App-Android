package com.example.calculatorapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum = 0; // Stores the first operand
    double memoryValue = 0; // to store the saved value
    String operation; // Stores the current operation (+, -, X, ÷)
    private String currentValue = "0"; // The current value displayed in the calculator

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize number buttons
        Button num0 = findViewById(R.id.num0);
        Button num1 = findViewById(R.id.num1);
        Button num2 = findViewById(R.id.num2);
        Button num3 = findViewById(R.id.num3);
        Button num4 = findViewById(R.id.num4);
        Button num5 = findViewById(R.id.num5);
        Button num6 = findViewById(R.id.num6);
        Button num7 = findViewById(R.id.num7);
        Button num8 = findViewById(R.id.num8);
        Button num9 = findViewById(R.id.num9);

        // Initialize function buttons
        Button ac = findViewById(R.id.ac);
        Button del = findViewById(R.id.del);
        Button mul = findViewById(R.id.multiply);
        Button equal = findViewById(R.id.equal);
        Button plus = findViewById(R.id.plus);
        Button minus = findViewById(R.id.sub);
        Button dot = findViewById(R.id.dot);
        Button div = findViewById(R.id.div);
        Button save = findViewById(R.id.sa1);
        Button recall = findViewById(R.id.re1);


        // Initialize the display screen
        TextView screen = findViewById(R.id.screen);

        // Restore the saved state if it exists
        if (savedInstanceState != null) {
            currentValue = savedInstanceState.getString("currentValue");
            screen.setText(currentValue);
        }


        // Clear all (AC) button functionality
        ac.setOnClickListener(view -> {
            firstNum = 0;
            operation = null;
            screen.setText("0");
        });


        // Add all number buttons to an Array list
        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        // Set click listeners for all number buttons
        for (Button b : nums) {
            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }

        // Add all operator buttons to an Array list
        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(mul);
        opers.add(plus);
        opers.add(minus);

        // Set click listeners for all number buttons
        for (Button b : opers) {
            b.setOnClickListener(view -> {
                String currentText = screen.getText().toString();
                // If an operation was already set, calculate the current result first
                if (operation != null && !currentText.endsWith(operation)) {
                    String[] parts = currentText.split(" ");
                    if (parts.length >= 3) {
                        double secondNum = Double.parseDouble(parts[2]);
                        firstNum = calculateResult(firstNum, secondNum, operation);
                        screen.setText(String.valueOf(firstNum));
                    }
                } else {
                    firstNum = Double.parseDouble(currentText);
                }
                operation = b.getText().toString();
                screen.setText(firstNum + " " + operation + " ");
            });
        }

        // Delete (DEL) button functionality
        del.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length() > 1) {
                screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length() == 1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        // Dot (.) button functionality
        dot.setOnClickListener(view -> {
            if (!screen.getText().toString().contains(".")) {
                screen.setText(screen.getText().toString() + ".");
            }
        });

        // Equals (=) button functionality
        equal.setOnClickListener(view -> {
            String[] parts = screen.getText().toString().split(" ");
            if (parts.length < 3) {
                return; // Prevents evaluating if there's no complete expression
            }

            double secondNum = Double.parseDouble(parts[2]);
            firstNum = calculateResult(firstNum, secondNum, operation);
            screen.setText(String.valueOf(firstNum));
            operation = null; // Clear the operation after evaluation
        });

        // Save button stores the current value displayed on the screen into memory
        save.setOnClickListener(view -> {
            memoryValue = Double.parseDouble(screen.getText().toString());
        });

        // Recall button sets the screen to the stored memory value
        recall.setOnClickListener(view -> {
            screen.setText(String.valueOf(memoryValue));
        });
    }

    // Method to perform the calculation
    private double calculateResult(double firstNum, double secondNum, String operation) {
        double result;
        switch (operation) {
            case "÷":
                if (secondNum == 0) {
                    return 0; // Handle division by zero
                }
                result = firstNum / secondNum;
                break;

            case "X":
                result = firstNum * secondNum;
                break;

            case "+":
                result = firstNum + secondNum;
                break;

            case "-":
                result = firstNum - secondNum;
                break;

            default:
                result = firstNum;
        }
        return result;
    }

    @Override //Save the current value to the Bundle for switching between layouts
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView screen = findViewById(R.id.screen); // Make sure your TextView's ID matches "screen"
        outState.putString("currentValue", screen.getText().toString());
    }
}







