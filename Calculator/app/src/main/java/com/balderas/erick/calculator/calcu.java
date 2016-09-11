package com.balderas.erick.calculator;

import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class calcu extends AppCompatActivity implements OnClickListener {
    boolean dp = false;
    boolean suma = false;
    boolean resta = false;
    boolean division = false;
    boolean multipl = false;
    Double[] num = new Double[2];
    Double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcu);
        //recuperamos los objetos controles
        //TextView texto = (TextView) findViewById(R.id.res);

        Button n0 = (Button) findViewById(R.id.b0);//Crea una variable botón que asocia con el botón con id b0
        n0.setOnClickListener(this);//prepara al botón para "escuchar el evento OnClick"
        Button n1 = (Button) findViewById(R.id.b1);
        n1.setOnClickListener(this);
        Button n2 = (Button) findViewById(R.id.b2);
        n2.setOnClickListener(this);
        Button n3 = (Button) findViewById(R.id.b3);
        n3.setOnClickListener(this);
        Button n4 = (Button) findViewById(R.id.b4);
        n4.setOnClickListener(this);
        Button n5 = (Button) findViewById(R.id.b5);
        n5.setOnClickListener(this);
        Button n6 = (Button) findViewById(R.id.b6);
        n6.setOnClickListener(this);
        Button n7 = (Button) findViewById(R.id.b7);
        n7.setOnClickListener(this);
        Button n8 = (Button) findViewById(R.id.b8);
        n8.setOnClickListener(this);
        Button n9 = (Button) findViewById(R.id.b9);
        n9.setOnClickListener(this);
        //Botones de operaciones
        Button sum = (Button) findViewById(R.id.s);
        sum.setOnClickListener(this);
        Button res = (Button) findViewById(R.id.r);
        res.setOnClickListener(this);
        Button div = (Button) findViewById(R.id.d);
        div.setOnClickListener(this);
        Button mult = (Button) findViewById(R.id.m);
        mult.setOnClickListener(this);
        //Botón igual
        Button equal = (Button) findViewById(R.id.eq);
        equal.setOnClickListener(this);
        //Botón clear
        Button borrar = (Button) findViewById(R.id.clear);
        borrar.setOnClickListener(this);
        //Punto
        Button punto = (Button) findViewById(R.id.point);
        punto.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {//cada que hay un click
        TextView resultado = (TextView)findViewById(R.id.res);//asociar a la variable resultado el TextView con id res
        int selec = v.getId();//Obtiene el id del botón que se está oprimiendo
        String a = resultado.getText().toString();//obtiene el texto de la pantalla
        try {
            switch (selec) {
                case R.id.b0://si select es b0
                    resultado.setText(a+"0");//Va concatenando lo que hay en a con el nuevo valor
                    break;
                case R.id.b1:
                    resultado.setText(a+"1");
                    break;
                case R.id.b2:
                    resultado.setText(a+"2");
                    break;
                case R.id.b3:
                    resultado.setText(a+"3");
                    break;
                case R.id.b4:
                    resultado.setText(a+"4");
                    break;
                case R.id.b5:
                    resultado.setText(a+"5");
                    break;
                case R.id.b6:
                    resultado.setText(a+"6");
                    break;
                case R.id.b7:
                    resultado.setText(a+"7");
                    break;
                case R.id.b8:
                    resultado.setText(a+"8");
                    break;
                case R.id.b9:
                    resultado.setText(a+"9");
                    break;
                case R.id.s:
                    if(suma==false && resta==false && multipl==false && division==false) {//entra la primera vez para que no oprima dos veces seguidas + y borre el valor de num[0]
                        suma = true;//Sirve para saber en el case:eq qué operación es la que se va realizar
                        num[0] = Double.parseDouble(a);//almacena lo que hay en a
                        resultado.setText("");//Limpio pantalla
                        dp = false;//habilito punto decimal para que pueda ser usado con el segundo número
                    }else return;
                    break;
                case R.id.r:
                    if(suma==false && resta==false && multipl==false && division ==false) {
                        resta = true;
                        num[0] = Double.parseDouble(a);
                        resultado.setText("");
                        dp = false;
                    }else return;
                    break;
                case R.id.d:
                    if (suma==false && resta==false && multipl==false && division==false) {
                        division = true;
                        num[0] = Double.parseDouble(a);
                        resultado.setText("");
                        dp = false;
                    }else return;
                    break;
                case R.id.m:
                    if(suma==false && resta==false && multipl==false && division==false) {
                        num[0] = Double.parseDouble(a);
                        multipl = true;
                        resultado.setText("");
                        dp = false;
                    }else return;
                    break;
                case R.id.clear:
                    resultado.setText("");//borra lo que hay en la pantalla
                    dp = false;//habilita el botón punto otra vez
                    multipl = false;
                    division = false;
                    resta = false;
                    suma = false;
                    break;
                case R.id.point:
                    if(dp=false){
                        resultado.setText(a+".");
                        dp = true;
                    }else return;
                    break;
                case R.id.eq:
                    if(a=="."||a=="") {
                        resultado.setText("Syntax error. Press C");
                    }else{
                        num[1] = Double.parseDouble(a);//jala el segundo número
                        if (suma == true) {
                            result = num[0] + num[1];
                            resultado.setText(String.valueOf(result));
                        } else if (resta == true) {
                            result = num[0] - num[1];
                            resultado.setText(String.valueOf(result));
                        } else if (division == true) {
                            if (num[1] == 0)
                                resultado.setText("Math error. Press C");
                            else {
                                result = num[0] / num[1];
                                resultado.setText(String.valueOf(result));
                            }
                        } else if (multipl == true) {
                            result = num[0] * num[1];
                            resultado.setText(String.valueOf(result));
                        }
                        dp = false;//habilita el botón punto otra vez
                        multipl = false;
                        division = false;
                        resta = false;
                        suma = false;
                    }
                    break;
            }
        }catch(Exception e){
            resultado.setText("Syntax error :^(. Press C");
        }
    }
}
//las operaciones seran TODAS false cuando se termine de ejecutar una operación en particular o se
//limpie la pantalla