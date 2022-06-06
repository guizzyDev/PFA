package ma.emsi.suivilivraison.service;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Livreur;
import ma.emsi.suivilivraison.models.Vendeur;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IColisService {

    Colis addColis(Colis colis);

    Colis updateColis(Colis colis);

    List<Colis> findAllColis();

    Optional<Colis> findColisById(Long id);

    Colis findColisByReference(String reference);

    List<Colis> findAllByClient(Client client);

    List<Colis> findAllByVendeur(Vendeur vendeur);

    List<Colis> findAllByLivreur(Livreur livreur);

    List<Colis> findAllByDateAjout(LocalDate dateAjout);

    void deleteColis(Colis colis);

    void removeLivreurFromColis(Colis colis);

    void removeClientFromColis(Colis colis);
}
