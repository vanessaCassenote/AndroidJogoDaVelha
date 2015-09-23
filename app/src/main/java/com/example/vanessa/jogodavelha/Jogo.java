package com.example.vanessa.jogodavelha;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Jogo extends AppCompatActivity {

    Button btna;
    Button btnb;
    Button btnc;
    Button btnd;
    Button btne;
    Button btnf;
    Button btng;
    Button btnh;
    Button btni;
    //Button btnnovoJogo;
    TextView jogando;
    private int jogador = 1;
    private char[][] matrizJogo = new char[3][3];
    Drawable buttonBackground;
    String[] mensagemRecebida = new String[2];
    String[] nomeJogadores;
    public final static String MENSAGEM = "com.example.vanessa.activities.MENSAGEM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jogo);
        btna = (Button) findViewById(R.id.a);
        btnb = (Button) findViewById(R.id.b);
        btnc = (Button) findViewById(R.id.c);
        btnd = (Button) findViewById(R.id.d);
        btne = (Button) findViewById(R.id.e);
        btnf = (Button) findViewById(R.id.f);
        btng = (Button) findViewById(R.id.g);
        btnh = (Button) findViewById(R.id.h);
        btni = (Button) findViewById(R.id.i);
        //btnnovoJogo = (Button) findViewById(R.id.buttonNovoJogo);
        btna.setOnClickListener(buttona);
        btnb.setOnClickListener(buttonb);
        btnc.setOnClickListener(buttonc);
        btnd.setOnClickListener(buttond);
        btne.setOnClickListener(buttone);
        btnf.setOnClickListener(buttonf);
        btng.setOnClickListener(buttong);
        btnh.setOnClickListener(buttonh);
        btni.setOnClickListener(buttoni);
        //btnnovoJogo.setOnClickListener(buttonnovoJogo);
        buttonBackground = btna.getBackground();
        limpaMatriz();
        jogando = (TextView) findViewById(R.id.Jogadores);

        Bundle b = this.getIntent().getExtras();
        nomeJogadores = b.getStringArray("MENSAGEM");
        jogando.setText(nomeJogadores[0]+"[X]  vs  "+nomeJogadores[1]+"[O]");
    }
    public void limpaMatriz(){
        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                matrizJogo[i][j] = ' ';
            }
        }
    }
    public void chamaTelaJogador(){
        Intent i = new Intent(getApplicationContext(), TelaVencedor.class);
        //Antes de testar se alguem ganhou o jogador é alterado
        //por isso o inverso e testado abaixo
        if(jogador == 2){
            i.putExtra(MENSAGEM,nomeJogadores[0]);
        }else if(jogador == 1){
            i.putExtra(MENSAGEM, nomeJogadores[1]);
        }
        startActivity(i);
    }
    View.OnClickListener buttona = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[0][0] == ' ') {
                if (jogador == 1) {
                    btna.setText("X");
                    matrizJogo[0][0] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btna.setText("O");
                    matrizJogo[0][0] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[0][1] == matrizJogo[0][2]) && (matrizJogo[0][0] == matrizJogo[0][2])) {
                    btna.setBackgroundColor(173216230);
                    btnb.setBackgroundColor(173216230);
                    btnc.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[1][0] == matrizJogo[2][0]) && (matrizJogo[0][0] == matrizJogo[2][0])) {
                    btna.setBackgroundColor(173216230);
                    btnd.setBackgroundColor(173216230);
                    btng.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[1][1] == matrizJogo[2][2]) && (matrizJogo[0][0] == matrizJogo[2][2])) {
                    btna.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    View.OnClickListener buttonb = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[0][1] == ' ') {
                if (jogador == 1) {
                    btnb.setText("X");
                    matrizJogo[0][1] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btnb.setText("O");
                    matrizJogo[0][1] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[0][1] == matrizJogo[0][2]) && (matrizJogo[0][0] == matrizJogo[0][2])) {
                    btna.setBackgroundColor(173216230);
                    btnb.setBackgroundColor(173216230);
                    btnc.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][1] == matrizJogo[1][1]) && (matrizJogo[0][1] == matrizJogo[2][1])) {
                    btnb.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btnh.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    View.OnClickListener buttonc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[0][2] == ' ') {
                if (jogador == 1) {
                    btnc.setText("X");
                    matrizJogo[0][2] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btnc.setText("O");
                    matrizJogo[0][2] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[0][1] == matrizJogo[0][2]) && (matrizJogo[0][0] == matrizJogo[0][2])) {
                    btna.setBackgroundColor(173216230);
                    btnb.setBackgroundColor(173216230);
                    btnc.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][2] == matrizJogo[1][2]) && (matrizJogo[0][2] == matrizJogo[2][2])) {
                    btnc.setBackgroundColor(173216230);
                    btnf.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][2] == matrizJogo[1][1]) && (matrizJogo[0][2] == matrizJogo[2][0])) {
                    btnc.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btng.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    View.OnClickListener buttond = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[1][0] == ' ') {
                if (jogador == 1) {
                    btnd.setText("X");
                    matrizJogo[1][0] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btnd.setText("O");
                    matrizJogo[1][0] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[1][0] == matrizJogo[0][0]) && (matrizJogo[1][0] == matrizJogo[2][0])) {
                    btna.setBackgroundColor(173216230);
                    btnd.setBackgroundColor(173216230);
                    btng.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[1][0] == matrizJogo[1][1]) && (matrizJogo[1][0] == matrizJogo[1][2])) {
                    btnd.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btnf.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    View.OnClickListener buttone = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[1][1] == ' ') {
                if (jogador == 1) {
                    btne.setText("X");
                    matrizJogo[1][1] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btne.setText("O");
                    matrizJogo[1][1] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[1][1] == matrizJogo[2][2]) && (matrizJogo[0][0] == matrizJogo[2][2])) {
                    btna.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][2] == matrizJogo[1][1]) && (matrizJogo[1][1] == matrizJogo[2][0])) {
                    btnc.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btng.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][1] == matrizJogo[1][1]) && (matrizJogo[1][1] == matrizJogo[2][1])) {
                    btnb.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btnh.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[1][0] == matrizJogo[1][1]) && (matrizJogo[1][1] == matrizJogo[1][2])) {
                    btnd.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btnf.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    View.OnClickListener buttonf = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[1][2] == ' ') {
                if (jogador == 1) {
                    btnf.setText("X");
                    matrizJogo[1][2] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btnf.setText("O");
                    matrizJogo[1][2] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[0][2] == matrizJogo[1][2]) && (matrizJogo[1][2] == matrizJogo[2][2])) {
                    btnc.setBackgroundColor(173216230);
                    btnf.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else  if ((matrizJogo[1][0] == matrizJogo[1][2]) && (matrizJogo[1][2] == matrizJogo[1][1])) {
                    btnd.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btnf.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    View.OnClickListener buttong = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[2][0] == ' ') {
                if (jogador == 1) {
                    btng.setText("X");
                    matrizJogo[2][0] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btng.setText("O");
                    matrizJogo[2][0] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[2][1] == matrizJogo[2][0]) && (matrizJogo[2][0] == matrizJogo[2][2])) {
                    btng.setBackgroundColor(173216230);
                    btnh.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][0] == matrizJogo[2][0]) && (matrizJogo[2][0] == matrizJogo[1][0])) {
                    btna.setBackgroundColor(173216230);
                    btnd.setBackgroundColor(173216230);
                    btng.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[1][1] == matrizJogo[2][0]) && (matrizJogo[2][0] == matrizJogo[0][2])) {
                    btng.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btnc.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    View.OnClickListener buttonh = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[2][1] == ' ') {
                if (jogador == 1) {
                    btnh.setText("X");
                    matrizJogo[2][1] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btnh.setText("O");
                    matrizJogo[2][1] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[2][1] == matrizJogo[2][0]) && (matrizJogo[2][0] == matrizJogo[2][2])) {
                    btng.setBackgroundColor(173216230);
                    btnh.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][1] == matrizJogo[2][1]) && (matrizJogo[2][1] == matrizJogo[1][1])) {
                    btnb.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btnh.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    View.OnClickListener buttoni = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(matrizJogo[2][2] == ' ') {
                if (jogador == 1) {
                    btni.setText("X");
                    matrizJogo[2][2] = 'X';
                    jogador = 2;

                } else if (jogador == 2) {
                    btni.setText("O");
                    matrizJogo[2][2] = 'O';
                    jogador = 1;
                }
                if ((matrizJogo[2][1] == matrizJogo[2][0]) && (matrizJogo[2][0] == matrizJogo[2][2])) {
                    btng.setBackgroundColor(173216230);
                    btnh.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][0] == matrizJogo[2][2]) && (matrizJogo[2][2] == matrizJogo[1][1])) {
                    btna.setBackgroundColor(173216230);
                    btne.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                } else if ((matrizJogo[0][2] == matrizJogo[2][2]) && (matrizJogo[2][2] == matrizJogo[1][2])) {
                    btnc.setBackgroundColor(173216230);
                    btnf.setBackgroundColor(173216230);
                    btni.setBackgroundColor(173216230);
                    chamaTelaJogador();
                }
            }
        }
    };
    /*View.OnClickListener buttonnovoJogo = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            btna.setText("");
            btnb.setText("");
            btnc.setText("");
            btnd.setText("");
            btne.setText("");
            btnf.setText("");
            btng.setText("");
            btnh.setText("");
            btni.setText("");
            limpaMatriz();
            btna.setBackground(buttonBackground);
            btnb.setBackground(buttonBackground);
            btnc.setBackground(buttonBackground);
            btnd.setBackground(buttonBackground);
            btne.setBackground(buttonBackground);
            btnf.setBackground(buttonBackground);
            btng.setBackground(buttonBackground);
            btnh.setBackground(buttonBackground);
            btni.setBackground(buttonBackground);
            jogador = 1;
        }
    };*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jogo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
