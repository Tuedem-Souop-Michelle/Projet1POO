/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author MICHELLE
 */

import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.model.VLAN;

import java.util.ArrayList;
import java.util.List;

public class MoteurVLSM {

    public List<ResultatVLSM> genererPlan(List<String> besoins) {

        List<ResultatVLSM> resultats = new ArrayList<>();

        int baseMasque = 24;

        for (String b : besoins) {

            VLAN vlan = new VLAN(10, b);

            ResultatVLSM res = new ResultatVLSM(
                    b,
                    baseMasque,
                    vlan
            );

            resultats.add(res);

            baseMasque++;
        }

        return resultats;
    }
}