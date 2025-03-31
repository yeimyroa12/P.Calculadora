package com.example.myapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edt_num_1, edt_num_2;
    TextView txt_resultado;
    Button btn_sumar;
    Spinner spinner_operadores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edt_num_1 = findViewById(R.id.edt_num_1);
        edt_num_2 = findViewById(R.id.edt_num_2);
        txt_resultado = findViewById(R.id.txt_resultado);
        btn_sumar = findViewById(R.id.btn_sumar);
        spinner_operadores = findViewById(R.id.spinner_operadores);

        btn_sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                procesar();
            }
        });
    }

    private void procesar() {
        String num1 = edt_num_1.getText().toString();
        String num2 = edt_num_2.getText().toString();
        String operador = spinner_operadores.getSelectedItem().toString();

        if (num1.isEmpty() || num2.isEmpty()) {
            Toast.makeText(MainActivity.this, "Por favor llenar todos los campos", Toast.LENGTH_LONG).show();
        } else {
            try {
                int numero1 = Integer.parseInt(num1);
                int numero2 = Integer.parseInt(num2);
                int resultado = 0;

                switch (operador) {
                    case "+":
                        resultado = numero1 + numero2;
                        break;
                    case "-":
                        resultado = numero1 - numero2;
                        break;
                    case "*":
                        resultado = numero1 * numero2;
                        break;
                    case "/":
                        if (numero2 != 0) {
                            resultado = numero1 / numero2;
                        } else {
                            Toast.makeText(MainActivity.this, "No se puede dividir por cero", Toast.LENGTH_LONG).show();
                            return;
                        }
                        break;
                }

                txt_resultado.setText(String.valueOf(resultado));
            } catch (NumberFormatException e) {
                Toast.makeText(MainActivity.this, "Por favor ingrese números válidos", Toast.LENGTH_LONG).show();
            }
        }
    }
}