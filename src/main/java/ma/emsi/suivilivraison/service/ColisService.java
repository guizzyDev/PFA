package ma.emsi.suivilivraison.service;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Livreur;
import ma.emsi.suivilivraison.models.Vendeur;
import ma.emsi.suivilivraison.repositories.ColisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
@Service
public class ColisService implements IColisService {
@Autowired
    private ColisRepository colisRepository ;

    @Override
    public Colis addColis(Colis colis){

        colis.setDate_Ajout(LocalDate.now());

        return colisRepository.save(colis);
    }
    @Override
    public Colis updateColis(Colis colis){
      return colisRepository.save(colis);
    }
    @Override
    public List<Colis> findAllColis() {

        return colisRepository.findAll();
    }
    @Override
    public Optional<Colis> findColisById(Long id) {

        return colisRepository.findById(id);
    }
    @Override
    public Colis findColisByReference(String reference){
        return colisRepository.getColisByReference(reference) ;}
    @Override
    public List<Colis> findAllByClient(Client client){
        return colisRepository.getAllByClient(client);}
    @Override
    public List<Colis> findAllByVendeur(Vendeur vendeur){
        return colisRepository.getAllByVendeur(vendeur);}
    @Override
    public List<Colis> findAllByLivreur(Livreur livreur){
        return colisRepository.getAllByLivreur(livreur) ;
    }
    @Override
    public List<Colis> findAllByDateAjout(LocalDate dateAjout){return colisRepository.getAllByDate_Ajout(dateAjout);}
     @Override
    public void deleteColis(Colis colis){
        colisRepository.delete(colis);
    }


    @Override
    public void removeLivreurFromColis(Colis colis) {
        colis.setLivreur(null);
        colisRepository.save(colis);
    }
    @Override
    public void removeClientFromColis(Colis colis) {
        colis.setClient(null);
        colisRepository.save(colis);
    }
}