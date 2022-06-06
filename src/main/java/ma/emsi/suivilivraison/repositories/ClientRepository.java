package ma.emsi.suivilivraison.repositories;

import ma.emsi.suivilivraison.models.Client;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepository extends JpaRepository<Client,Long>{

    @Query("select c from Client c where c.email_Client = :email_Client and c.mdp_Client = :mdp_Client")
    Client findClientByEmail_ClientAndMdp_Client(@Param("email_Client") String email_Client , @Param("mdp_Client") String mdp_Client);

    @Query("select c from Client c where c.email_Client = :email_Client")
    Client findClientByEmail_Client(@Param("email_Client")String email_Client) ;

}
