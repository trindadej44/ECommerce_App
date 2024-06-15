package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.CarrinhoManager;
import com.example.myapplication.ItemCarrinho;
import com.example.myapplication.R;
import java.util.List;

public class CarrinhoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCarrinho;
    private TextView textMensagemCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        recyclerViewCarrinho = findViewById(R.id.recyclerViewCarrinho);
        textMensagemCompra = findViewById(R.id.textMensagemCompra);

        mostrarItensCarrinho();
    }

    private void mostrarItensCarrinho() {
        List<ItemCarrinho> itensCarrinho = CarrinhoManager.getItensCarrinho();

        CarrinhoAdapter carrinhoAdapter = new CarrinhoAdapter(this, itensCarrinho);
        recyclerViewCarrinho.setAdapter(carrinhoAdapter);
        recyclerViewCarrinho.setLayoutManager(new LinearLayoutManager(this));

        // Exibir a mensagem de compra finalizada
        if (CarrinhoManager.isCompraFinalizada()) {
            textMensagemCompra.setVisibility(View.VISIBLE);
            textMensagemCompra.setText("Compra finalizada! Obrigado pela sua compra!");
        } else {
            textMensagemCompra.setVisibility(View.GONE);
        }
    }

    // Método para finalizar a compra
    public void finalizarCompra(View view) {
        CarrinhoManager.finalizarCompra();
        CarrinhoManager.limparCarrinho();

        // Exibe a mensagem de compra finalizada
        textMensagemCompra.setVisibility(View.VISIBLE);
        textMensagemCompra.setText("Compra finalizada! Obrigado pela sua compra!");

        // Atualiza o RecyclerView após a compra
        mostrarItensCarrinho();
    }
}
