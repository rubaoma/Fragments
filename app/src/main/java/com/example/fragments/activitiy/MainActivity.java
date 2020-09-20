package com.example.fragments.activitiy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.fragments.R;
import com.example.fragments.fragment.ContatosFragment;
import com.example.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button buttonConversa;
    private Button buttonContato;
    private FrameLayout frameLayout;


    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConversa = findViewById(R.id.buttonConversa);
        buttonContato = findViewById(R.id.buttonContatos);

        // remover a sombra do ActionBar
        getSupportActionBar().setElevation(0);

        //instanciando a fragment para ser manipulada dentro da MainActivity
        conversasFragment = new ConversasFragment();

        /**
         * Ao iniciar a Activity, por padrão será exibida a conversasFragment
         */
        //Configurar objeto para o fragmento
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); // iniciar a transação
        // 1º parametro o local onde será exibido a fragment, 2º qual fragment será exibida
        transaction.replace(R.id.frameLayout, conversasFragment); // .replace adiciona a fragment e substitui caso esteja sendo exibida outra fragment diferente do .add que sobrepoe (não fazer)
        //finalizar a transação
        transaction.commit();


        //usar os botes para chamar as fragments
        buttonContato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //instanciando o fragmento
                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, contatosFragment);
                transaction.commit();
            }
        });

        buttonConversa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //instanciando o fragmento
                contatosFragment = new ContatosFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout, conversasFragment);
                transaction.commit();
            }
        });
    }
}