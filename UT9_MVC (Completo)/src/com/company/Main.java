package com.company;

import Controler.com.company.ControllerEntrada;
import model.com.company.ModelAsignaturas;
import model.com.company.ModelPersonas;
import view.com.company.ViewAsignaturas;
import view.com.company.ViewPersonas;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ViewAsignaturas frAsignaturas=null;
        ModelAsignaturas modelAsignaturas = null;
        ViewPersonas frPersonas=null;
        ModelPersonas modelPersonas=null;
        new ControllerEntrada(modelAsignaturas,frAsignaturas, modelPersonas, frPersonas);

    }
}
