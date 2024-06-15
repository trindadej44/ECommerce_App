package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



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
    private List<ProdutoServico> mListaProdutos;
    private List<ProdutoServico> mListaProdutosFiltrados;

    public ProdutoServicoAdapter(Context context, List<ProdutoServico> listaProdutos) {
        mContext = context;
        mListaProdutos = listaProdutos;
        mListaProdutosFiltrados = listaProdutos;
    }

    @NonNull
    @Override
    public ProdutoServicoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_produto_servico, parent, false);
        return new ProdutoServicoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdutoServicoViewHolder holder, int position) {
        ProdutoServico produtoServico = mListaProdutosFiltrados.get(position);
        holder.textNomeProduto.setText(produtoServico.getNome());
        holder.textDescricaoProduto.setText(produtoServico.getDescricao());
        holder.textPrecoProduto.setText("R$ " + String.valueOf(produtoServico.getPreco()));
        holder.imageProduto.setImageResource(produtoServico.getImagem());
    }

    @Override
    public int getItemCount() {
        return mListaProdutosFiltrados.size();
    }

    public static class ProdutoServicoViewHolder extends RecyclerView.ViewHolder {

        ImageView imageProduto;
        TextView textNomeProduto, textDescricaoProduto, textPrecoProduto;

        public ProdutoServicoViewHolder(@NonNull View itemView) {
            super(itemView);
            imageProduto = itemView.findViewById(R.id.imageProduto);
            textNomeProduto = itemView.findViewById(R.id.textNomeProduto);
            textDescricaoProduto = itemView.findViewById(R.id.textDescricaoProduto);
            textPrecoProduto = itemView.findViewById(R.id.textPrecoProduto);
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString().toLowerCase().trim();
                if (charString.isEmpty()) {
                    mListaProdutosFiltrados = mListaProdutos;
                } else {
                    List<ProdutoServico> filteredList = new ArrayList<>();
                    for (ProdutoServico produto : mListaProdutos) {
                        if (produto.getNome().toLowerCase().contains(charString)) {
                            filteredList.add(produto);
                        }
                    }
                    mListaProdutosFiltrados = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mListaProdutosFiltrados;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mListaProdutosFiltrados = (List<ProdutoServico>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
