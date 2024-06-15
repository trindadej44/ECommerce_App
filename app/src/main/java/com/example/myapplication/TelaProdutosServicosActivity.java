package com.example.myapplication;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TelaProdutosServicosActivity extends AppCompatActivity {

    private RecyclerView recyclerViewProdutos;
    private ProdutoServicoAdapter produtoServicoAdapter;
    private List<ProdutoServico> listaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_produtos_servicos);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Configura RecyclerView
        recyclerViewProdutos = findViewById(R.id.recyclerViewProdutos);
        recyclerViewProdutos.setHasFixedSize(true);
        recyclerViewProdutos.setLayoutManager(new LinearLayoutManager(this));

        // Configura Adapter e lista de produtos
        listaProdutos = new ArrayList<>();
        listaProdutos.add(new ProdutoServico("Mochila", "Mochila resistente e espaçosa para viagens", 199.99, R.drawable.mochilha));
        listaProdutos.add(new ProdutoServico("Tênis Esportivo", "Tênis de alta performance para corridas", 249.99, R.drawable.tenis));
        listaProdutos.add(new ProdutoServico("Relógio Inteligente", "Relógio inteligente com monitor de saúde", 349.99, R.drawable.relogio));
        listaProdutos.add(new ProdutoServico("Calça Jeans", "Calça jeans moderna e confortável", 149.99, R.drawable.calca));
        listaProdutos.add(new ProdutoServico("Celular Avançado", "Smartphone com câmera de alta resolução", 1499.99, R.drawable.celular));
        listaProdutos.add(new ProdutoServico("Notebook Ultrafino", "Notebook leve e potente para trabalho", 2999.99, R.drawable.notebook));
        // Adicionar mais produtos conforme necessário

        produtoServicoAdapter = new ProdutoServicoAdapter(this, listaProdutos);
        recyclerViewProdutos.setAdapter(produtoServicoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_carrinho, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        // Configuração do SearchView
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                produtoServicoAdapter.getFilter().filter(newText);
                return true;  // Indica que a consulta foi tratada
            }
        });

        return true;
    }
}
