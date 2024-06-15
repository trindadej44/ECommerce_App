package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoManager {

    private static List<ItemCarrinho> itensCarrinho = new ArrayList<>();
    private static boolean compraFinalizada = false;

    public static void adicionarItem(ProdutoServico produto, int quantidade) {
        // Implemente a lógica para adicionar o item ao carrinho
        // Aqui você pode adicionar verificação para itens duplicados, etc.
        ItemCarrinho item = new ItemCarrinho(produto, quantidade);
        itensCarrinho.add(item);
    }

    public static void removerItem(ProdutoServico produto) {
        // Implemente a lógica para remover o item do carrinho
        for (ItemCarrinho item : itensCarrinho) {
            if (item.getProduto().equals(produto)) {
                itensCarrinho.remove(item);
                break;
            }
        }
    }

    public static List<ItemCarrinho> getItensCarrinho() {
        return itensCarrinho;
    }

    public static void limparCarrinho() {
        // Limpa todos os itens do carrinho
        itensCarrinho.clear();
    }

    public static void finalizarCompra() {
        compraFinalizada = true;
    }

    public static boolean isCompraFinalizada() {
        return compraFinalizada;
    }

    // Outros métodos conforme necessário
}
