/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== TP7 : VALIDATION ET CONFLITS =====");

        try {
            ValidateurPlan.validerFormatIP("192.168.1");
        } catch (ConflitReseauException e) {
            System.err.println(e.getMessage());
        }

        List<VLAN> vlans = new ArrayList<>();
        vlans.add(new VLAN(10, "Admin"));
        vlans.add(new VLAN(10, "Tech"));

        try {
            ValidateurPlan.verifierConflitVlan(vlans);
        } catch (ConflitReseauException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Fin TP7");
    }
}