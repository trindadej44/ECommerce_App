package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.TelaLogin;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;

public class TelaCadastro extends AppCompatActivity {

    private EditText editTextNome, editTextEmail, editTextSenha;
    private Button buttonCadastrar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        mAuth = FirebaseAuth.getInstance();

        editTextNome = findViewById(R.id.edit_nome);
        editTextEmail = findViewById(R.id.edit_email);
        editTextSenha = findViewById(R.id.edit_senha);
        buttonCadastrar = findViewById(R.id.register_button);

        buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString().trim();
                String email = editTextEmail.getText().toString().trim();
                String senha = editTextSenha.getText().toString().trim();

                cadastrarUsuario(nome, email, senha);
            }
        });
    }

    private void cadastrarUsuario(String nome, String email, String senha) {
        mAuth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Registro bem-sucedido, atualize os detalhes do perfil
                            mAuth.getCurrentUser().updateProfile(new UserProfileChangeRequest.Builder()
                                    .setDisplayName(nome)
                                    .build());

                            // Exibe a mensagem de sucesso
                            Toast.makeText(TelaCadastro.this, "USUÁRIO CADASTRADO COM SUCESSO", Toast.LENGTH_SHORT).show();

                            // Abre a tela principal (MainActivity neste caso)
                            Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
                            startActivity(intent);
                            finish(); // Encerra a atividade de registro para que o usuário não possa voltar a ela pressionando o botão "voltar"

                        } else {
                            // Se o registro falhar, exiba uma mensagem para o usuário.
                            Toast.makeText(TelaCadastro.this, "Erro ao registrar. Tente novamente mais tarde.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
