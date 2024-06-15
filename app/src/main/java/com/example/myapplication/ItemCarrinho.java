package com.example.myapplication;

public class ItemCarrinho {
    private ProdutoServico produto;
    private int quantidade;

    public ItemCarrinho(ProdutoServico produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ProdutoServico getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
