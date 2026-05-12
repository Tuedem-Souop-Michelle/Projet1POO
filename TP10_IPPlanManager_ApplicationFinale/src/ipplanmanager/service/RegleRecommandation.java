/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author MICHELLE
 */
import java.util.List;
import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.model.Recommandation;

public interface RegleRecommandation {

    List<Recommandation> analyser(List<ResultatVLSM> plan);
}

