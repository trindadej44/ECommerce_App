package com.example.myapplication;

import android.app.Application;

import com.example.myapplication.ProdutoServicoAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private ProdutoServicoAdapter produtoServicoAdapter;

    @Override
    public void onCreate() {
        super.onCreate();

        // Inicializa o adapter aqui
        produtoServicoAdapter = new ProdutoServicoAdapter(this, new ArrayList<>(), null); // Passa null como OnItemClickListener
    }

    public ProdutoServicoAdapter getProdutoServicoAdapter() {
        return produtoServicoAdapter;
    }
}
