/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.main;

import ipplanmanager.service.ApplicationIPPlanManager;

import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {

        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            System.out.println("UTF-8 non supporté");
        }

        new ApplicationIPPlanManager().demarrer();
    }
}