package edu.cecyt9.ipn.practica_13_hilos;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.ArrayList;


public class MainActivity extends Activity {
    private EditText entrada, entrada2;
    private TextView salida, salida2;
    private Button calcular;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);
        entrada2 = (EditText) findViewById(R.id.entrada2);
        salida2 = (TextView) findViewById(R.id.salida2);
        calcular = (Button) findViewById(R.id.calcular);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                salida.setText(fibonacci(Integer.parseInt(entrada.getText().toString())));
            }
        });
    }

    //public void calcularOperacion(View view) {
    //    int n = Integer.parseInt(entrada.getText().toString());
    //    salida.append(n +" .- ");
    //    int res = fibonacci(n);
    //    salida.append(res + "\n");
    //}

    public String fibonacci(int n) {
        String texto = "";
        ArrayList<BigInteger> fibo = new ArrayList<>();
        BigInteger primeronum = new BigInteger("0");
        BigInteger segundonum = new BigInteger("1");
        fibo.add(primeronum);
        fibo.add(segundonum);
        for(int i = 1; i < n; i++){
            fibo.add(fibo.get(i).add(fibo.get(i-1)));
        }
        for(int i = 1; i <= n; i++){
            texto = texto + i + " .- " + fibo.get(i-1) + "\n";
        }
        SystemClock.sleep(10);
        return texto;

    }

    public void calcularOperacion(View view) {
        int n = Integer.parseInt(entrada2.getText().toString());
        salida2.append(n +"! = ");
        int res = factorial(n);
        salida2.append(res + "\n");
    }

    public int factorial(int n) {
        int res=1;
        for (int i=1; i<=n; i++){
            res*=i;
            SystemClock.sleep(10);
        }

        return res;

    }

    class MiThread extends Thread {
        private int n;
        private String res;

        public MiThread(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            res = fibonacci(n);
            salida.append(res + "\n");
        }
    }
}