package ma.emsi.suivilivraison.service;

import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Livreur;
import ma.emsi.suivilivraison.models.Vendeur;

import java.util.List;
import java.util.Optional;

public interface IVendeurService {
    //AUTHENTIFICATION
    Vendeur signInVendeur(String email_Vendeur, String mdp_Vendeur);

    Vendeur registerVendeur(Vendeur vendeur);

    //MISE A JOUR PROFIL
    Vendeur updateVendeur(Vendeur vendeur);

    Vendeur updateMdpVendeur(Vendeur vendeur, String ancienMdp, String mdp);

    // AUTHENTIFICATION / INSCRIPTION / MISE A JOUR D'INFORMATION
        //GESTION DE COLIS
    Colis addColis(Colis colis, Vendeur vendeur);

    void deleteColis(Colis colis, Vendeur vendeur);

    Colis updateColis(Colis colis, Vendeur vendeur);

    List<Colis> findAllColisByVendeur(Vendeur vendeur);

    // RECHERCHE D'INFORMATION
    List<Vendeur> findAllVendeur();

    Optional<Vendeur> findVendeurById(Long id);

    Vendeur findVendeurByEmail(String email);

    // METHODE DE SUPRESSION
    void deleteVendeur(Vendeur vendeur);
}
