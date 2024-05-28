package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myapplication.Util.ConfiguraBd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.example.myapplication.model.Usuario;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class TelaLogin extends AppCompatActivity {

   

    EditText campoEmail, camposSenha; // Campos de entrada para email e senha
    Button botaoAcesso; // Botão de acesso
    private FirebaseAuth auth; // Instância do FirebaseAuth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // EdgeToEdge.enable(this); // Habilita layout de borda a borda
        setContentView(R.layout.activity_tela_login); // Define o layout da atividade

        auth = ConfiguraBd.Fireautenticacao(); // Obtém a instância do FirebaseAuth
        inicializarComponente(); // Inicializa os componentes da interface

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.logo_android), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom); // Ajusta o padding para suportar áreas de recorte da tela
            return insets;
        });
    }

    // Método para validar a autenticação do usuário
    public void validarAutenticacao(View view) {
        String email = campoEmail.getText().toString().trim(); // Remove espaços em branco extras
        String senha = camposSenha.getText().toString();

        if (!email.isEmpty()) { // Verifica se o campo email não está vazio
            if (!senha.isEmpty()) { // Verifica se o campo senha não está vazio
                // Verifica se o endereço de e-mail é válido
                if (isValidEmail(email)) {
                    Usuario usuario = new Usuario();
                    usuario.setEmail(email); // Define o email do usuário
                    usuario.setSenha(senha); // Define a senha do usuário

                    logar(usuario); // Chama o método para logar o usuário
                } else {
                    Toast.makeText(this, "Endereço de e-mail inválido", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Preencher a senha", Toast.LENGTH_SHORT).show(); // Exibe mensagem se o campo senha estiver vazio
            }
        } else {
            Toast.makeText(this, "Preencha o e-mail", Toast.LENGTH_SHORT).show(); // Exibe mensagem se o campo email estiver vazio
        }
    }

    // Método para verificar se um endereço de e-mail é válido usando expressão regular
    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }

    // Método para logar o usuário utilizando Firebase Authentication
    private void logar(Usuario usuario) {
        auth.signInWithEmailAndPassword(
                usuario.getEmail(), usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    abrirHome(); // Se o login for bem-sucedido, abre a tela principal
                } else {
                    String excecao = "";
                    try {
                        throw task.getException();
                    } catch (FirebaseAuthInvalidUserException e) {
                        excecao = "Usuário não está cadastrado"; // Captura exceção para usuário não cadastrado
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        excecao = "Email ou senha incorreto"; // Captura exceção para credenciais incorretas
                    } catch (Exception e) {
                        e.printStackTrace(); // Adicionado para imprimir a stack trace completa da exceção
                        excecao = "Erro ao logar: " + e.getMessage(); // Captura outras exceções
                    }

                    Toast.makeText(TelaLogin.this, excecao, Toast.LENGTH_SHORT).show(); // Exibe a mensagem de exceção
                }
            }
        });
    }


    // Método para abrir a tela principal
    private void abrirHome() {
        Intent in = new Intent(TelaLogin.this, MainActivity.class);
        startActivity(in);
    }

    // Método para abrir a tela de cadastro
    public void TelaLogin(View view) {
        Intent in = new Intent(TelaLogin.this, MainActivity.class);
        startActivity(in);
    }

    // Inicializa os componentes da interface
    public void inicializarComponente() {
        campoEmail = findViewById(R.id.edit_email);
        camposSenha = findViewById(R.id.edit_senha);
        botaoAcesso = findViewById(R.id.login_button);
    }
}