package com.atp.live_atp_mobile;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class StatPlayerBDD {
    public int abandon;
    public int ace;
    public int avantage;
    public int breack; //Avec un "c" car "break" est un mot-clé de java android
    public int debreak;
    public int defaite;
    public int exclusion;
    public int faute;
    public int idJoueur;
    public int sanctionJeu;
    public int sanctionOrdre;
    public int secondService;
    public int service;
    public int victoire;

    public StatPlayerBDD() {

    }

    public StatPlayerBDD(int abandon, int ace, int avantage, int breack, int debreak, int defaite, int exclusion, int faute, int idJoueur, int sanctionJeu, int sanctionOrdre, int secondService, int service, int victoire) {
        this.abandon = abandon;
        this.ace = ace;
        this.avantage = avantage;
        this.breack = breack;
        this.debreak = debreak;
        this.defaite = defaite;
        this.exclusion = exclusion;
        this.faute = faute;
        this.idJoueur = idJoueur;
        this.sanctionJeu = sanctionJeu;
        this.sanctionOrdre = sanctionOrdre;
        this.secondService = secondService;
        this.service = service;
        this.victoire = victoire;
    }

    @Exclude
    public Map<String, Object> toMapInteger() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("victoire", victoire);
        result.put("defaite", defaite);
        result.put("abandon", abandon);
        result.put("exclusion", exclusion);
        result.put("sanctionOrdre", sanctionOrdre);
        result.put("service", service);
        result.put("secondService", secondService);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapIntegerAdvantageOrAce() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("ace", ace);
        result.put("avantage", avantage);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapIntegerFault() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("faute", faute);

        return result;
    }

    @Exclude
    public Map<String, Object> toMapIntegerBreakDebreak() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("breack", breack);
        result.put("debreak", debreak);

        return result;
    }
}
