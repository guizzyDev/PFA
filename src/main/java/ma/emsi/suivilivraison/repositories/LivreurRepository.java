package ma.emsi.suivilivraison.repositories;

import ma.emsi.suivilivraison.models.Livreur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LivreurRepository extends JpaRepository<Livreur,Long> {

    @Query("select l from Livreur l where l.email_Livreur = :email_Livreur and l.mdp_Livreur = :mdp_Livreur")
    Livreur findLivreurByEmail_LivreurAndMdp_Livreur(@Param("email_Livreur")String email_Livreur , @Param("mdp_Livreur") String mdp_Livreur);

    @Query("select l from Livreur l where l.email_Livreur = :email_Livreur")
    Livreur findLivreurByEmail_Livreur(@Param("email_Livreur")String email_Livreur);
}
