package com.example.myapplication; // Define o pacote ao qual esta classe pertence

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class PerfilActivity extends AppCompatActivity {

    private TextView tvNome, tvEmail;
    private Button buttonLogout;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil); // Define o layout da atividade como activity_perfil.xml

        // Inicializa os elementos da interface
        tvNome = findViewById(R.id.tv_nome);
        tvEmail = findViewById(R.id.tv_email);
        buttonLogout = findViewById(R.id.button_logout);

        mAuth = FirebaseAuth.getInstance(); // Inicializa o FirebaseAuth

        FirebaseUser currentUser = mAuth.getCurrentUser(); // Obtém o usuário atual

        if (currentUser != null) {
            // Se o usuário está logado, exibe nome e email na interface
            String nome = currentUser.getDisplayName();
            String email = currentUser.getEmail();

            tvNome.setText("Nome: " + (nome != null ? nome : "Não disponível"));
            tvEmail.setText("Email: " + email);
        } else {
            // Se o usuário não está logado, exibe um Toast e finaliza a atividade
            Toast.makeText(this, "Usuário não está logado", Toast.LENGTH_SHORT).show();
            finish();
        }

        // Configura o OnClickListener para o botão de logout
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut(); // Realiza o logout no FirebaseAuth
                Intent intent = new Intent(PerfilActivity.this, TelaLogin.class); // Cria uma Intent para abrir a TelaLogin
                startActivity(intent); // Inicia a TelaLogin
                finish(); // Finaliza a atividade atual (PerfilActivity)
            }
        });
    }
}
