/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author MICHELLE
 */

public class ConflitReseauException extends Exception {
    public ConflitReseauException(String message) {
        super("ERREUR RÉSEAU : " + message);
    }
}
    

