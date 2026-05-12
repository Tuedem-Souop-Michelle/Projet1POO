/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author MICHELLE
 */
public class CalculateurReseau {

    public static int convertirIpEnEntier(String ip) {
        String[] p = ip.split("\\.");
        return (Integer.parseInt(p[0]) << 24)
                + (Integer.parseInt(p[1]) << 16)
                + (Integer.parseInt(p[2]) << 8)
                + Integer.parseInt(p[3]);
    }

    public static String convertirEntierEnIp(int ip) {
        return ((ip >> 24) & 255) + "."
                + ((ip >> 16) & 255) + "."
                + ((ip >> 8) & 255) + "."
                + (ip & 255);
    }

    public static int calculerCidrPourHotes(int h) {
        int bits = 0;
        while ((Math.pow(2, bits) - 2) < h) bits++;
        return 32 - bits;
    }

    public static int calculerNombreHotes(int cidr) {
        return (int) Math.pow(2, 32 - cidr) - 2;
    }

    public static String obtenirMasqueDecimal(int cidr) {
        int mask = 0xffffffff << (32 - cidr);
        return ((mask >> 24) & 255) + "."
                + ((mask >> 16) & 255) + "."
                + ((mask >> 8) & 255) + "."
                + (mask & 255);
    }

    public static int calculerTailleBloc(int cidr) {
        return (int) Math.pow(2, 32 - cidr);
    }
}
    

