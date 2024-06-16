package com.example.myapplication;

import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoManager {

    // Lista de itens no carrinho
    private static List<ItemCarrinho> itensCarrinho = new ArrayList<>();
    // Indica se a compra foi finalizada
    private static boolean compraFinalizada = false;

    // Adiciona um item ao carrinho
    public static void adicionarItem(ProdutoServico produto, int quantidade) {
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        itensCarrinho.add(item);
    }

    // Remove um item do carrinho
    public static void removerItem(ProdutoServico produto) {
        for (ItemCarrinho item : itensCarrinho) {
            if (item.getProduto().equals(produto)) {
                itensCarrinho.remove(item);
                break;
            }
        }
    }

    // Retorna a lista de itens no carrinho
    public static List<ItemCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }

    // Limpa todos os itens do carrinho
    public static void limparCarrinho() {
        itensCarrinho.clear();
    }

    // Marca a compra como finalizada
    public static void finalizarCompra() {
        compraFinalizada = true;
    }

    // Verifica se a compra foi finalizada
    public static boolean isCompraFinalizada() {
        return compraFinalizada;
    }
}
