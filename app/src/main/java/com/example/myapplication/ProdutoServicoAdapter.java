package com.example.myapplication; // Define o pacote ao qual esta classe pertence

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProdutoServicoAdapter extends RecyclerView.Adapter<ProdutoServicoAdapter.ProdutoServicoViewHolder> implements Filterable {

    private Context mContext;
    private List<ProdutoServico> mListaProdutos; // Lista de produtos/serviços originais
    private List<ProdutoServico> mListaProdutosFiltrados; // Lista de produtos/serviços filtrados
    private OnItemClickListener mListener; // Listener para o clique no botão de adicionar ao carrinho

    // Interface para tratar o clique no botão de adicionar ao carrinho
    public interface OnItemClickListener {
        void onAdicionarCarrinhoClick(ProdutoServico produto, int quantidade);
    }

    // Construtor do adaptador
    public ProdutoServicoAdapter(Context context, List<ProdutoServico> listaProdutos, OnItemClickListener listener) {
        mContext = context;
        mListaProdutos = listaProdutos;
        mListaProdutosFiltrados = new ArrayList<>(mListaProdutos); // Inicializa com uma cópia da lista original
        mListener = listener;
    }

    // Método obrigatório: cria novas views (invocado pelo layout manager)
    @NonNull
    @Override
    public ProdutoServicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Cria uma nova view
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_produto_servico, parent, false);
        return new ProdutoServicoViewHolder(view);
    }

    // Método obrigatório: substitui o conteúdo da view (invocado pelo layout manager)
    @Override
    public void onBindViewHolder(@NonNull ProdutoServicoViewHolder holder, int position) {
        ProdutoServico produtoServico = mListaProdutosFiltrados.get(position);

        // Define os dados do produto/serviço para a view
        holder.textNomeProduto.setText(produtoServico.getNome());
        holder.textDescricaoProduto.setText(produtoServico.getDescricao());
        holder.textPrecoProduto.setText("R$ " + String.valueOf(produtoServico.getPreco()));
        holder.imageProduto.setImageResource(produtoServico.getImagem());

        // Configura o clique no botão de adicionar ao carrinho
        holder.btnAdicionarCarrinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onAdicionarCarrinhoClick(produtoServico, 1); // Chama o método do listener com o produto e a quantidade
            }
        });
    }

    // Método obrigatório: retorna o tamanho da lista (invocado pelo layout manager)
    @Override
    public int getItemCount() {
        return mListaProdutosFiltrados.size();
    }

    // ViewHolder: representa cada item da lista
    public static class ProdutoServicoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProduto;
        TextView textNomeProduto, textDescricaoProduto, textPrecoProduto;
        TextView btnAdicionarCarrinho;

        public ProdutoServicoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Associa os componentes da interface aos atributos da classe ViewHolder
            imageProduto = itemView.findViewById(R.id.imageProduto);
            textNomeProduto = itemView.findViewById(R.id.textNomeProduto);
            textDescricaoProduto = itemView.findViewById(R.id.textDescricaoProduto);
            textPrecoProduto = itemView.findViewById(R.id.textPrecoProduto);
            btnAdicionarCarrinho = itemView.findViewById(R.id.btnAdicionarCarrinho);
        }
    }

    // Método obrigatório da interface Filterable: retorna o filtro para a RecyclerView
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString().toLowerCase().trim();
                if (charString.isEmpty()) {
                    mListaProdutosFiltrados = new ArrayList<>(mListaProdutos); // Retorna a lista completa se o filtro estiver vazio
                } else {
                    List<ProdutoServico> filteredList = new ArrayList<>();
                    for (ProdutoServico produto : mListaProdutos) {
                        if (produto.getNome().toLowerCase().contains(charString)) {
                            filteredList.add(produto);
                        }
                    }
                    mListaProdutosFiltrados = filteredList; // Define a lista filtrada
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mListaProdutosFiltrados;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mListaProdutosFiltrados = (List<ProdutoServico>) results.values; // Aplica os resultados do filtro
                notifyDataSetChanged(); // Notifica o RecyclerView sobre a mudança nos dados
            }
        };
    }
}
