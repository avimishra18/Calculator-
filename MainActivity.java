package com.example.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Declaring all the views and Variables
    Button one,two,three,four,five,six,seven,eight,nine,zero;
    Button dot,backSpace,AC,openBracket,closeBracket;
    Button plus,minus,multiply,divide,equalTo;

    TextView answer,calculation;

    List<String> input = new ArrayList<String>();
    String value="",output=""; //Value to get the number, and output to display the expression entered by the user.
    Integer ind,reset=0; // Stores the index of the ArrayList
    Double number1,number2,result;

    void setViewUI(){ //Setting all the Views

        one = findViewById(R.id.button1);
        two = findViewById(R.id.button2);
        three = findViewById(R.id.button3);
        four = findViewById(R.id.button4);
        five = findViewById(R.id.button5);
        six = findViewById(R.id.button6);
        seven = findViewById(R.id.button7);
        eight = findViewById(R.id.button8);
        nine = findViewById(R.id.button9);
        zero = findViewById(R.id.button0);

        dot = findViewById(R.id.buttonDot);
        backSpace = findViewById(R.id.buttonDelete);
        AC = findViewById(R.id.buttonAC);
        openBracket = findViewById(R.id.buttonOpen);
        closeBracket= findViewById(R.id.buttonClose);

        plus = findViewById(R.id.buttonPlus);
        minus = findViewById(R.id.buttonMinus);
        multiply = findViewById(R.id.buttonMulitply);
        divide = findViewById(R.id.buttonDivide);
        equalTo = findViewById(R.id.buttonEqual);

        //Using the necessary variables required
        answer = findViewById(R.id.answerTextView);
        calculation = findViewById(R.id.calculationTextView);

    }

    void checkReset(){ // Functions checks and reset the calculator after the calculation is performed.
        if(reset==1){
            output="";
            value="";
            answer.setText(output);
            calculation.setText(output);
            reset=0;
        }
    }

    void inputAndDisplay(String inputString){
        value+=inputString;
        output+=inputString;
        answer.setText(output);
    }

    void operation(String inputString){
        input.add(value);
        input.add(inputString);
        output+=inputString;
        answer.setText(output);
        value="";
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViewUI(); //Sets the Views

        //The equal to button
        equalTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.add(value);
                do{
                    for (String s:input){
                        if (input.contains("/"))
                        {
                            ind = input.indexOf("/");
                            number1 = Double.parseDouble(input.get(ind-1));
                            number2 = Double.parseDouble(input.get(ind+1));
                            result = number1/number2;
                            input.set(ind,String.valueOf(result));
                            break;
                        }
                        else if (input.contains("*"))
                        {
                            ind = input.indexOf("*");
                            number1 = Double.parseDouble(input.get(ind-1));
                            number2 = Double.parseDouble(input.get(ind+1));
                            result = number1*number2;
                            input.set(ind,String.valueOf(result));
                            break;
                        }
                        if (input.contains("+"))
                        {
                            ind = input.indexOf("+");
                            number1 = Double.parseDouble(input.get(ind-1));
                            number2 = Double.parseDouble(input.get(ind+1));
                            result = number1+number2;
                            input.set(ind,String.valueOf(result));
                            break;
                        }
                        else if (input.contains("-"))
                        {
                            ind = input.indexOf("-");
                            number1 = Double.parseDouble(input.get(ind-1));
                            number2 = Double.parseDouble(input.get(ind+1));
                            result = number1-number2;
                            input.set(ind,String.valueOf(result));
                            break;
                        }
                    }
                    input.remove(ind + 1);
                    input.remove(ind - 1);
                }while(input.contains("+")||input.contains("-")||input.contains("*")||input.contains("/"));

                calculation.setText(output);
                answer.setText("="+result);
                reset=1;
            }
        });



        //Setting On Click Listeners for Numbers
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("0");
            }
        });

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay("9");
            }
        });

        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkReset();
                inputAndDisplay(".");
            }
        });

        //Setting On Click Listeners for Operations
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation("+");
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation("-");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation("*");
            }
        });

        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation("/");
            }
        });

    }
}
