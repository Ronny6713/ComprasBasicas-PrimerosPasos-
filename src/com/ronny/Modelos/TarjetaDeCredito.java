package com.ronny.Modelos;

import java.util.ArrayList;
import java.util.List;

public class TarjetaDeCredito {
    private double limite;
    private double saldo;
    private List<Compra> listaDeCompra;

    public TarjetaDeCredito(double limite) {
        this.limite = limite;
        this.listaDeCompra = new ArrayList<>();
        this.saldo = limite;
    }



    public boolean lanzarCompra(Compra compra) {
        if (this.saldo >= compra.getValor()) {
            this.saldo -= compra.getValor();
            this.listaDeCompra.add(compra);
            return true;
        }
        return false;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Compra> getListaDeCompra() {
        return listaDeCompra;
    }
}
