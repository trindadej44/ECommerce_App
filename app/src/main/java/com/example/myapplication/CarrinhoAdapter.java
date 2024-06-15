package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder> {

    private Context mContext;
    private List<ItemCarrinho> mListaItensCarrinho;

    public CarrinhoAdapter(Context context, List<ItemCarrinho> listaItensCarrinho) {
        mContext = context;
        mListaItensCarrinho = listaItensCarrinho;
    }

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_carrinho, parent, false);
        return new CarrinhoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {
        ItemCarrinho itemCarrinho = mListaItensCarrinho.get(position);
        holder.textNomeProduto.setText(itemCarrinho.getProduto().getNome());
        holder.textQuantidade.setText("Quantidade: " + itemCarrinho.getQuantidade());
        holder.textPreco.setText("R$ " + itemCarrinho.getProduto().getPreco());
    }

    @Override
    public int getItemCount() {
        return mListaItensCarrinho.size();
    }

    public static class CarrinhoViewHolder extends RecyclerView.ViewHolder {

        TextView textNomeProduto, textQuantidade, textPreco;

        public CarrinhoViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeProduto = itemView.findViewById(R.id.textNomeProduto);
            textQuantidade = itemView.findViewById(R.id.textQuantidade);
            textPreco = itemView.findViewById(R.id.textPreco);
        }
    }
}
