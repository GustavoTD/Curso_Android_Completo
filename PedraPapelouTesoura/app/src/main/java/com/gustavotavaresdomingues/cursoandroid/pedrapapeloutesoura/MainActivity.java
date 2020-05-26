package com.gustavotavaresdomingues.cursoandroid.pedrapapeloutesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    Opções do Usuário
    public void selecionadoPedra(View view){
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view){
        opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        opcaoSelecionada("tesoura");
    }

//    Gera escolha do app (aleatório) e define o resultado (ganhou, perdeu, empate)
    public void opcaoSelecionada(String opcaoUsr){

        ImageView imgOpcao = findViewById(R.id.imgEscolhaApp);
        TextView txtRes = findViewById(R.id.txtResultado);

        int numero = new Random().nextInt(3); // 0 1 2
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp){
            case "pedra":
                imgOpcao.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgOpcao.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgOpcao.setImageResource(R.drawable.tesoura);
                break;
        }

        //app ganha
        if(opcaoApp.equals("tesoura") && opcaoUsr.equals("papel") ||
                opcaoApp.equals("papel") && opcaoUsr.equals("pedra") ||
                opcaoApp.equals("pedra") && opcaoUsr.equals("tesoura")){

            txtRes.setText("Você perdeu");

            //Usuário ganha
        } else if (opcaoUsr.equals("tesoura") && opcaoApp.equals("papel") ||
                opcaoUsr.equals("papel") && opcaoApp.equals("pedra") ||
                opcaoUsr.equals("pedra") && opcaoApp.equals("tesoura")) {

            txtRes.setText("Você ganhou!");

            //Empate
        } else {
            txtRes.setText("Empate");
        }

    }

}
