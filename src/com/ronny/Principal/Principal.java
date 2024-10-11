package com.ronny.Principal;

import com.ronny.Modelos.Compra;
import com.ronny.Modelos.TarjetaDeCredito;

import java.util.Collections;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Escriba el limite de su tarjeta: ");
        double limite = teclado.nextDouble();
        TarjetaDeCredito tarjeta = new TarjetaDeCredito(limite);

        int salir = 1;

        while (salir != 0) {
            System.out.println("Escriba que producto quiere comprar: ");
            String descripcion = teclado.next();

            System.out.println("Escriba el valor de la compra: ");
            double valor = Double.valueOf(teclado.next());

            Compra compra = new Compra(valor, descripcion);
            boolean compraRealizada = tarjeta.lanzarCompra(compra);

            if (compraRealizada) {
                System.out.println("Compra Realizada Con Exito!");
                System.out.println("Escriba 0 para salir o 1 para continuar...");
                salir = teclado.nextInt();
            } else {
                System.out.println("El Saldo es insuficiente! ");
                salir =  0;
            }
        }
        System.out.println("*****************************************");
        System.out.println("Compras Realizadas");
        Collections.sort(tarjeta.getListaDeCompra());
        for (Compra compra : tarjeta.getListaDeCompra()) {
            System.out.println(compra.getDescripcion() + "-" + compra.getValor());
        }
        System.out.println("\n*****************");
        System.out.println("\nSaldo de la tarjeta: " + tarjeta.getSaldo());
    }
}
