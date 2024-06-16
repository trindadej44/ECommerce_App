package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
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
        listaProdutos.add(new ProdutoServico("Câmera Digital", "Câmera com alta resolução e zoom óptico", 999.99, R.drawable.camera));
        listaProdutos.add(new ProdutoServico("Fone de Ouvido", "Fone de ouvido com cancelamento de ruído", 199.99, R.drawable.fone));
        listaProdutos.add(new ProdutoServico("Smart TV", "TV inteligente com 4K e 55 polegadas", 2999.99, R.drawable.tv));
        listaProdutos.add(new ProdutoServico("Tablet", "Tablet com tela de 10 polegadas e grande memória", 799.99, R.drawable.tablet));
        listaProdutos.add(new ProdutoServico("Impressora", "Impressora multifuncional com scanner e Wi-Fi", 499.99, R.drawable.impressora));
        listaProdutos.add(new ProdutoServico("Bicicleta", "Bicicleta de montanha com 21 marchas", 1199.99, R.drawable.bicicleta));
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
                // Aqui você pode executar a ação de pesquisa
                // Exemplo: realizar a busca de acordo com o texto inserido
                produtoServicoAdapter.getFilter().filter(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Aqui você pode reagir à mudança de texto na caixa de pesquisa
                produtoServicoAdapter.getFilter().filter(newText);
                return true;
            }
        });

        return true;
    }

    // Método para adicionar um item ao carrinho a partir do adaptador
    private void adicionarItemAoCarrinho(ProdutoServico produto, int quantidade) {
        // Implementa a lógica para adicionar o item ao carrinho aqui
        CarrinhoManager.adicionarItem(produto, quantidade);

        // Atualiza a interface do usuário, se necessário
        invalidateOptionsMenu();
        Toast.makeText(TelaProdutosServicosActivity.this, "Item Adicionado Ao Carrinho!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_carrinho) {
            // Abre a tela do carrinho aqui, substitua pela sua lógica
            startActivity(new Intent(this, CarrinhoActivity.class));
            return true;
        } else if (id == R.id.action_perfil) {
            // Abre a tela do perfil aqui
            startActivity(new Intent(this, PerfilActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
