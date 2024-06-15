package com.example.myapplication;

public class ProdutoServico {
    private String nome;
    private String descricao;
    private double preco;
    private int imagem;

    public ProdutoServico(String nome, String descricao, double preco, int imagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public int getImagem() {
        return imagem;
    }
}
