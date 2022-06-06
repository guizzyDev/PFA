package ma.emsi.suivilivraison.models;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor 
@Entity
public class Colis implements Serializable {
    // STATUTs DE LIVRAISON
    final static String STATUT0 = "ECP" ; // Pas encore expedié ( En cours de preparation "ECP" )
    final static String STATUT1 = "EXP" ; //  "EXP" : Expedié
    final static String STATUT2 = "RPL" ; // "RPL"  : Recu par le livreur
    final static String STATUT3 = "LIV" ; // "LIV" : Livré

    @Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id_Colis ;
    @Column(nullable = false, unique = true)
private String reference ;
    @Column(nullable = false)
private String adresse ;
    @Column(nullable = false)
private LocalDate date_Ajout ;
    @Column(nullable = false)
private LocalDate date_Livraison  ;
    @Column(nullable = false)
private String description ;
    @Column(nullable = false)
private String statut  ; 

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id_Vendeur")
private Vendeur vendeur  ; 
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id_Livreur")
private Livreur livreur ;  
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name="id_Client")
private Client client ; 


}
