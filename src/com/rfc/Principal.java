package com.rfc;

import javax.swing.*;
import java.io.File;
import java.nio.file.FileSystems;

public class Principal {

    public static void main(String[] args) {
        System.out.println(new File(FileSystems.getDefault().getPath("").toAbsolutePath().toFile(), "rfc.dat"));
        Operaciones.mostrarTodo();
        Operaciones on = new Operaciones();
        int opcion = 0;
        do {
            try {
                opcion = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO \n¿Qué operacion desea realizar? "
                        + " \n1.-Obtener el RFC de una persona \n2.-Eliminar \n3.-Buscar \n4.-Mostrar Todo"));
                if (opcion == 1) {
                    on.rfc();
                    on.GuardarDisco();
                    on.mostrarTodo(true);
                } else if (opcion == 2) {
                    on.eliminar();
                    Operaciones.mostrarTodo(true);
                } else if (opcion == 3) {
                    on.Imprimir();
                } else if (opcion == 4) {
                    System.out.println("------------------");
                    on.mostrarTodo(true);
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Parece que usted ha ingresado un numero que no est� en el men�");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Parece que usted no ha ingresado un numero \nDigite un n�mero por favor");
            }
            opcion = Integer
                    .parseInt(JOptionPane.showInputDialog("�Desea volver al men� principal? \n1.-SI  \n2.-SALIR"));
        } while (opcion == 1);

    }
}
