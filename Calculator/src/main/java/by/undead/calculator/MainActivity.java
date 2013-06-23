package by.undead.calculator;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    public String num1;
    public String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editResult = (EditText) findViewById(R.id.editResult);

        Button btn0 = (Button) findViewById(R.id.btn0);
        btn0.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("0");
            }

        });

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("1");
            }

        });

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("2");
            }

        });

        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("3");
            }

        });

        Button btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("4");
            }

        });

        Button btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("5");
            }

        });

        Button btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("6");
            }

        });

        Button btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("7");
            }

        });

        Button btn8 = (Button) findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("8");
            }

        });

        Button btn9 = (Button) findViewById(R.id.btn9);
        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setNumber("9");
            }

        });

        Button btnC = (Button) findViewById(R.id.btnC);
        btnC.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                editResult.setText("0");
            }

        });

        Button btnDot = (Button) findViewById(R.id.btnDot);
        btnDot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = editResult.getText().toString();
                if (text.indexOf('.') >= 0) {
                    return;
                }
                if (text.length() == 1) {
                    text = "0." + text;
                } else {
                    text = text + ".";
                }
                editResult.setText(text);
            }

        });

        Button btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String text = editResult.getText().toString();
                if (text.equals("0") || text.length() == 1) {
                    text = "0";
                } else {
                    text = text.substring(0, text.length() - 1);
                }
                editResult.setText(text);
            }

        });

        Button btnClean = (Button) findViewById(R.id.btnClean);
        btnClean.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                num1 = null;
                editResult.setText("0");
            }

        });

        Button btnMultiply = (Button) findViewById(R.id.btnMultiply);
        btnMultiply.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setOperation("multiply");
            }

        });

        Button btnDivide = (Button) findViewById(R.id.btnDivide);
        btnDivide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setOperation("divide");
            }

        });

        Button btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMinus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setOperation("minus");
            }

        });

        Button btnPlus = (Button) findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                setOperation("plus");
            }

        });

        Button btnEqually = (Button) findViewById(R.id.btnEqually);
        btnEqually.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                result();
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void setNumber(String num) {
        EditText editResult = (EditText) findViewById(R.id.editResult);
        String text = editResult.getText().toString();
        if (text.equals("0")) {
            text = num;
        } else {
            text = text + num;
        }
        editResult.setText(text);
    }

    public void setOperation(String operation) {
        EditText editResult = (EditText) findViewById(R.id.editResult);
        //if (this.num1 == null) {
        this.num1 = editResult.getText().toString();
        TextView txtNum1 = (TextView) findViewById(R.id.txtNum1);
        txtNum1.setText(this.num1);
        //}
        this.operation = operation;
        editResult.setText("0");
    }

    public void result() {

        if (operation == null) {
            return;
        }

        EditText editResult = (EditText) findViewById(R.id.editResult);

        Double n1 = Double.parseDouble(this.num1);
        Double n2 = Double.parseDouble(editResult.getText().toString());

        if (this.operation.equals("plus")) {
            num1 = n1 + n2 + "";
        } else if (this.operation.equals("minus")) {
            num1 = n1 - n2 + "";
        } else if (this.operation.equals("multiply")) {
            num1 = n1 * n2 + "";
        } else if (this.operation.equals("divide")) {
            num1 = n1 / n2 + "";
        }
        editResult.setText(num1);

        TextView txtNum1 = (TextView) findViewById(R.id.txtNum1);
        txtNum1.setText(this.num1);
        this.operation = null;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_theme1: {
                Log.i("TAG", "Theme1");
                setTheme(R.style.MyTheme1);
                setContentView(R.layout.activity_main);
                return true;
            }
            case R.id.action_theme2:{
                Log.i("TAG", "Theme2");
                setTheme(R.style.MyTheme2);
                setContentView(R.layout.activity_main);
                return true;
            }
            case R.id.action_about:{
                Intent myIntent = new Intent(MainActivity.this,About.class);
                startActivity(myIntent);
                return true;
            }
            default:{
                return super.onOptionsItemSelected(item);
            }
        }


    }
}
