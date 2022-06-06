package ma.emsi.suivilivraison.controllers;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Livreur;
import ma.emsi.suivilivraison.models.Vendeur;
import ma.emsi.suivilivraison.service.ColisService;
import ma.emsi.suivilivraison.service.IColisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/colis")//pre-path
public class ColisController
{
    @Autowired
    private IColisService colisService;

    // METHODE DE MODIFICATION/AJOUT DE DONNEES
    @PostMapping("addcolis") //api/colis/addColis
    public ResponseEntity<?> addColis(@RequestBody Colis colis)
    {
        return new ResponseEntity<>(colisService.addColis(colis), HttpStatus.CREATED);
    }
    @DeleteMapping("{colisid}") //colis/{colisId}
    public ResponseEntity<?> deleteColis(@PathVariable Colis colis)
    {
        colisService.deleteColis(colis);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("updatecolis")
    public ResponseEntity<?> updateColis(@RequestBody Colis colis ){
        colisService.addColis(colis);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    // METHODE DE RECUPERATION DE DONNEES


    @GetMapping //api/colis/
    public ResponseEntity<?> findAllColis()
    {
        return new ResponseEntity<>(colisService.findAllColis(), HttpStatus.OK);
    }

    @GetMapping({"idColis"}) //colis/{idColis}
    public ResponseEntity<?> findColisById(@PathVariable(name = "idColis") Long idColis)
    {
        return new ResponseEntity<>(colisService.findColisById(idColis), HttpStatus.OK);
    }
    @GetMapping({"{reference}"}) //colis/{reference}
    public ResponseEntity<?> findColisByReference(@PathVariable String reference)
    {
        return new ResponseEntity<>(colisService.findColisByReference(reference), HttpStatus.OK);
    }
    @PostMapping("bylivreur") //api/colis/bylivreur/   (body -> reference)
    public ResponseEntity<List<Colis>> findAllByLivreur(@RequestBody Livreur livreur)
    {

        return new ResponseEntity<>(colisService.findAllByLivreur(livreur), HttpStatus.CREATED);
    }
    @PostMapping("byclient") //api/colis/byclient   (body -> reference)
    public ResponseEntity<List<Colis>> findAllByClient(@RequestBody Client client)
    {

        return new ResponseEntity<>(colisService.findAllByClient(client), HttpStatus.CREATED);
    }
    @PostMapping("vendeur") //api/colis/byvendeur   (body -> reference)
    public ResponseEntity<List<Colis>> findAllByLivreur(@RequestBody Vendeur vendeur)
    {

        return new ResponseEntity<>(colisService.findAllByVendeur(vendeur), HttpStatus.CREATED);
    }
    @GetMapping("date/{dateajout}")
    public ResponseEntity<List<Colis>> findAllByDateAjout(@PathVariable(name = "dateajout") LocalDate date ){
        return new ResponseEntity<>(colisService.findAllByDateAjout(date),HttpStatus.OK);

    }



}
