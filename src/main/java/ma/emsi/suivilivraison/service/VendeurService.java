package ma.emsi.suivilivraison.service;

import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Vendeur;
import ma.emsi.suivilivraison.repositories.VendeurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class VendeurService implements IVendeurService {
    @Autowired
    private VendeurRepository vendeurRepository ;
    @Autowired
    private IColisService colisService ;
// AUTHENTIFICATION / INSCRIPTION / MISE A JOUR D'INFORMATION


    //AUTHENTIFICATION
    @Override
    public Vendeur signInVendeur(String email_Vendeur, String mdp_Vendeur) {
        return vendeurRepository.findVendeurByEmail_VendeurAndMdp_Vendeur(email_Vendeur,mdp_Vendeur);
    }
    @Override
    public Vendeur registerVendeur(Vendeur vendeur){
        return vendeurRepository.save(vendeur);
    }
    //MISE A JOUR PROFIL
    @Override
    public Vendeur updateVendeur(Vendeur vendeur) {
      return   vendeurRepository.save(vendeur);
    }

    @Override
    public Vendeur updateMdpVendeur(Vendeur vendeur, String ancienMdp, String mdp) {
        Optional<Vendeur> vendeurHelp = vendeurRepository.findById(vendeur.getId_Vendeur());
        if (vendeurHelp.get().getMdp_Vendeur().equals(ancienMdp)) {
            vendeur.setMdp_Vendeur(mdp);
            return vendeurRepository.save(vendeur);
        }return null ;
    }
    //GESTION DE COLIS
    @Override
    public Colis addColis(Colis colis, Vendeur vendeur ){
        colis.setVendeur(vendeur);
        return  colisService.addColis(colis) ;
    }
    @Override
    public void deleteColis(Colis colis , Vendeur vendeur ){
        if(colis.getVendeur().equals(vendeur)){
            colisService.deleteColis(colis);
        }
    }
    @Override
    public Colis updateColis(Colis colis , Vendeur vendeur ){
        if(colis.getVendeur().equals(vendeur)){
            return colisService.addColis(colis);
        }return null ;
    }
    @Override
    public List<Colis> findAllColisByVendeur(Vendeur vendeur) {
        return colisService.findAllByVendeur(vendeur);
    }
    // RECHERCHE D'INFORMATION
    @Override
    public List<Vendeur> findAllVendeur() {
        return vendeurRepository.findAll();
    }
    @Override
    public Optional<Vendeur> findVendeurById(Long id) {
        return vendeurRepository.findById(id);}
    @Override
    public Vendeur findVendeurByEmail(String email) {
       return vendeurRepository.findVendeurByEmail_Vendeur(email) ;
    }

    // METHODE DE SUPRESSION
    @Override
    public void deleteVendeur(Vendeur vendeur){
        vendeurRepository.delete(vendeur);
    }




}
