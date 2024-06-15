package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCarrinho;
    private CarrinhoAdapter carrinhoAdapter;
    private List<ItemCarrinho> listaItensCarrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        // Inicializa a lista de itens do carrinho
        listaItensCarrinho = new ArrayList<>();

        // Configura RecyclerView
        recyclerViewCarrinho = findViewById(R.id.recyclerViewCarrinho);
        recyclerViewCarrinho.setHasFixedSize(true);
        recyclerViewCarrinho.setLayoutManager(new LinearLayoutManager(this));

        // Configura Adapter e lista de itens do carrinho
        carrinhoAdapter = new CarrinhoAdapter(this, listaItensCarrinho);
        recyclerViewCarrinho.setAdapter(carrinhoAdapter);

        // Atualiza total do carrinho
        atualizaTotalCarrinho();
    }

    // Adiciona um item ao carrinho
    public void adicionarItemAoCarrinho(ProdutoServico produto, int quantidade) {
        ItemCarrinho itemCarrinho = new ItemCarrinho(produto, quantidade);
        listaItensCarrinho.add(itemCarrinho);
        carrinhoAdapter.notifyDataSetChanged();

        // Atualiza o total do carrinho
        atualizaTotalCarrinho();
    }

    // Método para atualizar o total do carrinho
    private void atualizaTotalCarrinho() {
        double total = calcularTotalCarrinho();
        TextView textTotalCarrinho = findViewById(R.id.textTotalCarrinho);
        textTotalCarrinho.setText("Total: R$ " + total);
    }

    // Método para calcular o total do carrinho
    private double calcularTotalCarrinho() {
        double total = 0;
        for (ItemCarrinho item : listaItensCarrinho) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }
}
