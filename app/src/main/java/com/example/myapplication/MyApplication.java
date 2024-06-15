package com.example.myapplication;

import android.app.Application;

import java.util.ArrayList;

public class MyApplication extends Application {

    private ProdutoServicoAdapter produtoServicoAdapter;

    @Override
    public void onCreate() {
        super.onCreate();

        // Inicializa o adapter aqui
        produtoServicoAdapter = new ProdutoServicoAdapter(this, new ArrayList<>());
    }

    public ProdutoServicoAdapter getProdutoServicoAdapter() {
        return produtoServicoAdapter;
    }
}
