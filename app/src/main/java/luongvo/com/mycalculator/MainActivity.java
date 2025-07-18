package luongvo.com.mycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Variables to store input and result
    String currentInput = "";     // Stores current number being typed
    String firstNumber = "";      // Stores the first number (before operator)
    String selectedOperator = ""; // Stores the selected operator (+, -, *, /)

    // Text fields from layout
    TextView resultTextView;      // Displays result or current number
    TextView historyTextView;     // Shows previous calculations

    // Number buttons
    Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonDot;

    // Operator buttons
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;

    // Special buttons
    Button buttonClear, buttonEqual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 1: Connect XML UI to Java code
        linkUIComponents();

        // Step 2: Set number and dot button actions
        setNumberButtonListeners();

        // Step 3: Set operator and equal/clear actions
        setOperatorButtonListeners();
    }

    // ✅ Step 1: Connect buttons and text views to layout IDs
    private void linkUIComponents() {
        resultTextView = findViewById(R.id.text_view_result);
        historyTextView = findViewById(R.id.historyTextView); // New history display

        // Number buttons
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDot = findViewById(R.id.buttonDot); // NEW: Dot (decimal) button

        // Operators
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonSub = findViewById(R.id.buttonSub);
        buttonMul = findViewById(R.id.buttonMul);
        buttonDiv = findViewById(R.id.buttonDiv);

        // Others
        buttonClear = findViewById(R.id.buttonClear);
        buttonEqual = findViewById(R.id.buttonEqual);
    }

    // ✅ Step 2: Add click listeners to number buttons (0–9 and .)
    private void setNumberButtonListeners() {
        // When any number or dot is clicked, append to input
        View.OnClickListener numberListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                currentInput += b.getText().toString(); // Add pressed number to current input
                resultTextView.setText(currentInput);   // Show on screen
            }
        };

        // Apply this listener to all buttons
        button0.setOnClickListener(numberListener);
        button1.setOnClickListener(numberListener);
        button2.setOnClickListener(numberListener);
        button3.setOnClickListener(numberListener);
        button4.setOnClickListener(numberListener);
        button5.setOnClickListener(numberListener);
        button6.setOnClickListener(numberListener);
        button7.setOnClickListener(numberListener);
        button8.setOnClickListener(numberListener);
        button9.setOnClickListener(numberListener);
        buttonDot.setOnClickListener(numberListener); // ✅ Decimal point button
    }

    // ✅ Step 3: Operator buttons (+ - * /) and equal/clear
    private void setOperatorButtonListeners() {
        buttonAdd.setOnClickListener(v -> operatorClicked("+"));
        buttonSub.setOnClickListener(v -> operatorClicked("-"));
        buttonMul.setOnClickListener(v -> operatorClicked("*"));
        buttonDiv.setOnClickListener(v -> operatorClicked("/"));
        buttonEqual.setOnClickListener(v -> equalClicked());
        buttonClear.setOnClickListener(v -> clearAll());
    }

    // When operator button is clicked
    private void operatorClicked(String operator) {
        firstNumber = currentInput;     // Save the first number
        currentInput = "";              // Clear current input for second number
        selectedOperator = operator;    // Save which operator is used
        resultTextView.setText("");     // Clear display
    }

    // When equal (=) button is clicked
    private void equalClicked() {
        try {
            // Convert inputs to double to allow decimal calculation
            double num1 = Double.parseDouble(firstNumber);
            double num2 = Double.parseDouble(currentInput);
            double result = 0;

            // Perform operation based on selected operator
            switch (selectedOperator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        resultTextView.setText("Divide by 0 Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            // Show result and update history
            String expression = firstNumber + " " + selectedOperator + " " + currentInput + " = " + result;
            historyTextView.append(expression + "\n"); // Add to history
            currentInput = String.valueOf(result);     // Store result for next use
            resultTextView.setText(currentInput);      // Show result on screen

        } catch (Exception e) {
            resultTextView.setText("Error");
        }
    }

    // Clears all values when "CLEAR" is pressed
    private void clearAll() {
        currentInput = "";
        firstNumber = "";
        selectedOperator = "";
        resultTextView.setText("");
    }
}
