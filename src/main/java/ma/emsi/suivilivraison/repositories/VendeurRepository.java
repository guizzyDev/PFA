package ma.emsi.suivilivraison.repositories;

import ma.emsi.suivilivraison.models.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VendeurRepository extends JpaRepository<Vendeur,Long> {

    @Query("select v from Vendeur v where v.email_Vendeur = :email and v.mdp_Vendeur = :mdp")
    Vendeur findVendeurByEmail_VendeurAndMdp_Vendeur(@Param("email") String email , @Param("mdp") String mdp  );
	
	
	@Query("select v from Vendeur v where v.email_Vendeur = :email")
    Vendeur findVendeurByEmail_Vendeur(@Param("email") String email );


}
