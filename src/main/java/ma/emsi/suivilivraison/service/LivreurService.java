package ma.emsi.suivilivraison.service;

import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Livreur;
import ma.emsi.suivilivraison.repositories.LivreurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LivreurService implements ILivreurService {
    @Autowired
    private LivreurRepository livreurRepository ;
    @Autowired
    private ColisService colisService;
    // AUTHENTIFICATION /INSCRIPTION / MISE A JOUR D'INFORMATION
        //AUTHENTIFICATION
    @Override
    public Livreur registerLivreur(Livreur livreur){
        return livreurRepository.save(livreur);
    }
    @Override
    public Livreur signInLivreur(String email_Livreur, String mdp_Livreur){
        return livreurRepository.findLivreurByEmail_LivreurAndMdp_Livreur(email_Livreur,mdp_Livreur);
    }
  //GESTION COLIS
    @Override
    public Colis addColistoLivreur(String reference, Long id_Livreur){
        Colis colis = colisService.findColisByReference(reference);
        Livreur livreur = livreurRepository.getReferenceById(id_Livreur);
        colis.setLivreur(livreur);
        return colisService.addColis(colis);
    }
    @Override
    public void removeColis(Colis colis, Livreur livreur){
        if(colis.getLivreur().equals(livreur)){
            colisService.removeLivreurFromColis(colis);
        }
    }
        //MISE A JOUR D'INFORMATIONS
    @Override
    public Livreur updateLivreur (Livreur livreur ){
        return livreurRepository.save(livreur) ;
    }

    @Override
    public Livreur UpdateMdpLivreur(Livreur livreur, String ancienMdp, String mdp) {
        Optional<Livreur> clientHelp =  livreurRepository.findById(livreur.getId_Livreur()) ;
        if(clientHelp.get().getMdp_Livreur().equals(ancienMdp)){
            livreur.setMdp_Livreur(mdp);
            return livreurRepository.save(livreur);
        }
        return null;
    }

    //RECHERCHE D'INFORMATIONS
    @Override
    public List<Livreur> findAllLivreur() {
        return livreurRepository.findAll();
    }
    @Override
    public Optional<Livreur> findLivreurById(Long id) {
        return livreurRepository.findById(id);
    }
    @Override
    public Livreur findLivreurByEmail(String email ) {
        return livreurRepository.findLivreurByEmail_Livreur(email);
    }

    public List<Colis> findAllColisByLivreur(Livreur livreur  ){
        return colisService.findAllByLivreur(livreur);
    }
    // METHODE DE SUPRESSION
    @Override
    public void deleteLivreur(Livreur livreur){
        livreurRepository.delete(livreur);
    }



}
