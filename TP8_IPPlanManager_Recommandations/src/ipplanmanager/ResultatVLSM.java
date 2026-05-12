/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */

public class ResultatVLSM {

    private String nom;
    private String adresseReseau;
    private int masqueCidr;
    private int hotesReels;
    private VLAN vlanAssocie;

    public ResultatVLSM(String nom, String adresseReseau, int masqueCidr, int hotesReels, VLAN vlanAssocie) {
        this.nom = nom;
        this.adresseReseau = adresseReseau;
        this.masqueCidr = masqueCidr;
        this.hotesReels = hotesReels;
        this.vlanAssocie = vlanAssocie;
    }

    // ✅ GETTERS OBLIGATOIRES POUR TP8
    public String getNom() {
        return nom;
    }

    public String getAdresseReseau() {
        return adresseReseau;
    }

    public int getMasqueCidr() {
        return masqueCidr;
    }

    public int getHotesReels() {
        return hotesReels;
    }

    public VLAN getVlanAssocie() {
        return vlanAssocie;
    }

    public void afficher() {
        System.out.println("Sous-réseau : " + nom);
        System.out.println("Adresse : " + adresseReseau + "/" + masqueCidr);
        System.out.println("Hôtes : " + hotesReels);

        if (vlanAssocie != null) {
            vlanAssocie.afficher();
        }
    }
}