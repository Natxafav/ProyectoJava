package com.company;

import Controler.com.company.ControllerEntrada;
import model.com.company.ModelAsignaturas;
import view.com.company.ViewAsignaturas;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ViewAsignaturas frAsignaturas=null;
        ModelAsignaturas modelAsignaturas = null;
        new ControllerEntrada(modelAsignaturas,frAsignaturas);

    }
}
