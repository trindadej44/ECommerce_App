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

    private Context mContext;             // Contexto da aplicação
    private List<ItemCarrinho> mItensCarrinho;  // Lista de itens no carrinho

    // Construtor da classe
    public CarrinhoAdapter(Context context, List<ItemCarrinho> itensCarrinho) {
        mContext = context;
        mItensCarrinho = itensCarrinho;
    }

    // Método chamado quando o ViewHolder precisa ser criado
    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Infla o layout do item do carrinho
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_carrinho, parent, false);
        return new CarrinhoViewHolder(view);  // Retorna um novo ViewHolder
    }

    // Método chamado para associar os dados aos elementos visuais do ViewHolder
    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {
        // Obtém o item do carrinho na posição fornecida
        ItemCarrinho item = mItensCarrinho.get(position);

        // Define os textos dos TextViews com os dados do item
        holder.textNomeProduto.setText(item.getProduto().getNome());
        holder.textQuantidade.setText("Quantidade: " + item.getQuantidade());
        holder.textPrecoTotal.setText("Total: R$ " + (item.getQuantidade() * item.getProduto().getPreco()));
    }

    // Retorna o número total de itens na lista
    @Override
    public int getItemCount() {
        return mItensCarrinho.size();
    }

    // ViewHolder que mantém referências aos elementos visuais do item de carrinho
    public static class CarrinhoViewHolder extends RecyclerView.ViewHolder {

        TextView textNomeProduto, textQuantidade, textPrecoTotal;

        // Construtor do ViewHolder
        public CarrinhoViewHolder(@NonNull View itemView) {
            super(itemView);
            // Inicializa os TextViews com base nos IDs fornecidos no layout do item
            textNomeProduto = itemView.findViewById(R.id.textNomeProduto);
            textQuantidade = itemView.findViewById(R.id.textQuantidade);
            textPrecoTotal = itemView.findViewById(R.id.textPrecoTotal);
        }
    }
}
