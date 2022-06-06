package ma.emsi.suivilivraison.service;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Livreur;

import java.util.List;
import java.util.Optional;

public interface ILivreurService {

    // AUTHENTIFICATION /INSCRIPTION / MISE A JOUR D'INFORMATION
        //AUTHENTIFICATION
    Livreur registerLivreur(Livreur livreur);

    Livreur signInLivreur(String email_Livreur, String mdp_Livreur);

    //GESTION COLIS
    Colis addColistoLivreur(String reference, Long id_Livreur);

    void removeColis(Colis colis, Livreur livreur);

    //MISE A JOUR D'INFORMATIONS
    Livreur updateLivreur(Livreur livreur);

    Livreur UpdateMdpLivreur(Livreur livreur, String ancienMdp, String mdp);

    //RECHERCHE D'INFORMATIONS
    List<Livreur> findAllLivreur();

    Optional<Livreur> findLivreurById(Long id);

    Livreur findLivreurByEmail(String email);

    // METHODE DE SUPRESSION
    void deleteLivreur(Livreur livreur);
}
