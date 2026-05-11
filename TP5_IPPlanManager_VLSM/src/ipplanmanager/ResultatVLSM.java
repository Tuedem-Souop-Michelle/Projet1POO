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

    public ResultatVLSM(String nom, String adresseReseau, int masqueCidr, int hotesReels) {
        this.nom = nom;
        this.adresseReseau = adresseReseau;
        this.masqueCidr = masqueCidr;
        this.hotesReels = hotesReels;
    }

    public void afficher() {
        System.out.println("Sous-réseau : " + nom);
        System.out.println("  > Adresse : " + adresseReseau + "/" + masqueCidr);
        System.out.println("  > Capacité réelle : " + hotesReels + " hôtes");
    }
}
    

