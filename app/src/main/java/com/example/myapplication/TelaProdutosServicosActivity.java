package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.SearchView;
import androidx.annotation.NonNull;
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
        listaProdutos.add(new ProdutoServico("Mochila", "Mochila resistente e espaçosa para viagens", 199.99, R.drawable.mochila));
        listaProdutos.add(new ProdutoServico("Tênis Esportivo", "Tênis de alta performance para corridas", 249.99, R.drawable.tenis));
        listaProdutos.add(new ProdutoServico("Relógio Inteligente", "Relógio inteligente com monitor de saúde", 349.99, R.drawable.relogio));
        listaProdutos.add(new ProdutoServico("Calça Jeans", "Calça jeans moderna e confortável", 149.99, R.drawable.calca));
        listaProdutos.add(new ProdutoServico("Celular Avançado", "Smartphone com câmera de alta resolução", 1499.99, R.drawable.celular));
        listaProdutos.add(new ProdutoServico("Notebook Ultrafino", "Notebook leve e potente para trabalho", 2999.99, R.drawable.notebook));
        // Adicionar mais produtos conforme necessário

        produtoServicoAdapter = new ProdutoServicoAdapter(this, listaProdutos, new ProdutoServicoAdapter.OnItemClickListener() {
            @Override
            public void onAdicionarCarrinhoClick(ProdutoServico produto, int quantidade) {
                adicionarItemAoCarrinho(produto, quantidade);
            }
        });
        recyclerViewProdutos.setAdapter(produtoServicoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tela_produtos_servicos, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        // Configuração do SearchView
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                produtoServicoAdapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                produtoServicoAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    // Método para adicionar um item ao carrinho a partir do adaptador
    private void adicionarItemAoCarrinho(ProdutoServico produto, int quantidade) {
        // Adiciona o item ao carrinho
        CarrinhoManager.adicionarItem(produto, quantidade);

        // Mostra mensagem de sucesso
        Toast.makeText(this, "Item adicionado ao carrinho", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_carrinho) {
            // Abre a tela do carrinho
            startActivity(new Intent(this, CarrinhoActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
