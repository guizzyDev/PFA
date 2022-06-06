package ma.emsi.suivilivraison.controllers;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Vendeur;
import ma.emsi.suivilivraison.service.IColisService;
import ma.emsi.suivilivraison.service.IVendeurService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("Vendeur")//pre-path
public class VendeurController
{

    @Autowired
    private IVendeurService vendeurService;

    @PostMapping("register") //api/vendeur
    public ResponseEntity<?> register(@RequestBody Vendeur vendeur)
    {
        List<String> nomVendeur= new ArrayList<>();
        List<String> emailVendeur = new ArrayList<>();
        List<String> mdpVendeur = new ArrayList<>();
        nomVendeur.addAll(List.of(new String[]{"Vendeur1", "Vendeur2", "Vendeur3", "Vendeur4", "Vendeu5r", "Vendeur6", "Vendeur7"}));
        emailVendeur.addAll(List.of(new String[]{"Vendeur1@gmail.com", "Vendeur2@gmail.com", "Vendeur4@gmail.com", "Vendeu5r@gmail.com", "Vendeur6@gmail.com", "Vendeur7@gmail.com", "Vendeur3@gmail.com"}));
        mdpVendeur.addAll(List.of(new String[]{"password", "password", "password", "password", "password", "password", "password"}));
        for(int i =0 ; i<nomVendeur.size() ; i++ ){
                vendeur = new Vendeur(0L,"MagasinVendeur","Adresse Magasin"+ i+"" ,emailVendeur.get(i),mdpVendeur.get(i));

            vendeurService.registerVendeur(vendeur);
        }
        return new ResponseEntity<>(vendeurService.registerVendeur(vendeur), HttpStatus.CREATED);
    }
    @PostMapping("/addcolis") //api/vendeur/addcolis
    public ResponseEntity<?> addColis(@RequestBody Colis colis )
    {
        Colis colis2 = new Colis((Long) null,"","", LocalDate.now(),LocalDate.now(),"","",null,null,null);
//vendeurService.addColis(colis2);
  return null;
        //      return new ResponseEntity<>(vendeurService.addColis(colis), HttpStatus.CREATED);
    }

    @DeleteMapping("{vendeur}") //vendeur/{vendeurId}
    public ResponseEntity<?> deleteVendeur(@PathVariable Vendeur vendeur)
    {vendeurService.deleteVendeur(vendeur);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping //vendeur
    public ResponseEntity<?> getAllVendeur()
    {return new ResponseEntity<>(vendeurService.findAllVendeur(), HttpStatus.OK);}
}
