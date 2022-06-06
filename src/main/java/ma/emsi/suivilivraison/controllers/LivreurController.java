package ma.emsi.suivilivraison.controllers;

import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Livreur;
import ma.emsi.suivilivraison.service.ILivreurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/livreur")//pre-path
public class LivreurController {
    //TO FIX
    @Autowired
    private ILivreurService livreurService;


    //METHODE D AJOUT ET DE MODIFICATION DE DONNNES

    @PostMapping("register")
    public ResponseEntity<?> registerLivreur(@RequestBody Livreur livreur) {
        return new ResponseEntity<>(livreurService.registerLivreur(livreur), HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<?> updateLivreur(@RequestBody Livreur livreur) {
        return new ResponseEntity<>(livreurService.updateLivreur(livreur), HttpStatus.CREATED);
    }

    // TO FIX

    @PostMapping("addcolis")
    public ResponseEntity<?> addColistoLivreur(@RequestBody String reference, Long id_Livreur) {
        return null;
    }
    @DeleteMapping("{livreurId}")
    public ResponseEntity<?> deleteLivreur(@PathVariable Livreur livreur) {
        livreurService.deleteLivreur(livreur);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //METHODE DE RECUPERATION DE DONNEES


     @GetMapping
    public ResponseEntity<?> findAllLivreur() {
        return new ResponseEntity<>(livreurService.findAllLivreur(), HttpStatus.OK);
    }

     @GetMapping("{id}")
    public ResponseEntity<?> findLivreurById(Long id) {
        return new ResponseEntity<>(livreurService.findLivreurById(id), HttpStatus.OK);
    }

    @PostMapping("signin")
    public ResponseEntity<?> signIn(String email_Livreur, String mdp_Livreur) {
        return null;
    }

     @GetMapping("email/{email}/")
    public Livreur findLivreurByEmail(@PathVariable String email) {
        return null;
    }
}
