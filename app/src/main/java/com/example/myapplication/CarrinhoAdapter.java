package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.ItemCarrinho;
import com.example.myapplication.R;
import java.util.List;

public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.CarrinhoViewHolder> {

    private Context mContext;
    private List<ItemCarrinho> mItensCarrinho;

    public CarrinhoAdapter(Context context, List<ItemCarrinho> itensCarrinho) {
        mContext = context;
        mItensCarrinho = itensCarrinho;
    }

    @NonNull
    @Override
    public CarrinhoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_carrinho, parent, false);
        return new CarrinhoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarrinhoViewHolder holder, int position) {
        ItemCarrinho item = mItensCarrinho.get(position);
        holder.textNomeProduto.setText(item.getProduto().getNome());
        holder.textQuantidade.setText("Quantidade: " + item.getQuantidade());
        holder.textPrecoTotal.setText("Total: R$ " + (item.getQuantidade() * item.getProduto().getPreco()));
    }

    @Override
    public int getItemCount() {
        return mItensCarrinho.size();
    }

    public static class CarrinhoViewHolder extends RecyclerView.ViewHolder {

        TextView textNomeProduto, textQuantidade, textPrecoTotal;

        public CarrinhoViewHolder(@NonNull View itemView) {
            super(itemView);
            textNomeProduto = itemView.findViewById(R.id.textNomeProduto);
            textQuantidade = itemView.findViewById(R.id.textQuantidade);
            textPrecoTotal = itemView.findViewById(R.id.textPrecoTotal);
        }
    }
}
