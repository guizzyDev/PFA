package ma.emsi.suivilivraison.repositories;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.Livreur;
import ma.emsi.suivilivraison.models.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ColisRepository extends JpaRepository<Colis,Long> {


    @Query("select c from Colis c where c.reference = :reference")
    Colis getColisByReference(@Param("reference") String reference) ;
    @Query("select c from Colis c where c.client = :client")
    List<Colis> getAllByClient(@Param("client") Client client );


    @Query("select c from Colis c where c.livreur = :livreur")
    List<Colis> getAllByLivreur(@Param("livreur") Livreur livreur ) ;


    @Query("select c from Colis c where c.vendeur = :vendeur")
    List<Colis> getAllByVendeur(@Param("vendeur") Vendeur vendeur ) ;

    @Query("select c from Colis c where c.date_Ajout = :date")
    List<Colis> getAllByDate_Ajout(@Param("date") LocalDate date );



	
	
	
	
}
