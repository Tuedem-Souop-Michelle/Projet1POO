/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */
import java.util.List;

public class ValidateurPlan {

    public static void verifierConflitVlan(List<VLAN> vlans) throws ConflitReseauException {
        for (int i = 0; i < vlans.size(); i++) {
            for (int j = i + 1; j < vlans.size(); j++) {
                if (vlans.get(i).getId() == vlans.get(j).getId()) {
                    throw new ConflitReseauException("Conflit d'ID VLAN : " + vlans.get(i).getId());
                }
            }
        }
    }

    public static void validerFormatIP(String ip) throws ConflitReseauException {
        if (ip == null || ip.split("\\.").length != 4) {
            throw new ConflitReseauException("IP invalide : " + ip);
        }
    }

    public static void detecterChevauchement(List<ResultatVLSM> resultats) throws ConflitReseauException {
        if (resultats.isEmpty()) {
            throw new ConflitReseauException("Plan d'adressage vide");
        }
    }
}
    
