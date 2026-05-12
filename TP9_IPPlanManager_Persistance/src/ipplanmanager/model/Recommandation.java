/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.model;

/**
 *
 * @author MICHELLE
 */
public class Recommandation {

    private String titre;
    private String description;
    private String type;

    public Recommandation(String titre, String description, String type) {
        this.titre = titre;
        this.description = description;
        this.type = type;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + titre + " : " + description;
    }
}