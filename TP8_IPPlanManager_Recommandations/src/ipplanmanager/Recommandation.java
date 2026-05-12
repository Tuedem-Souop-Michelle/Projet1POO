/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */

public class Recommandation {
    private String titre;
    private String message;
    private String niveau;

    public Recommandation(String titre, String message, String niveau) {
        this.titre = titre;
        this.message = message;
        this.niveau = niveau;
    }

    public void afficher() {
        System.out.println("[" + niveau + "] " + titre + " : " + message);
    }
}
    

