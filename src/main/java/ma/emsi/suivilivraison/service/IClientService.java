package ma.emsi.suivilivraison.service;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;

import java.util.List;
import java.util.Optional;

public interface IClientService {

    // AUTHENTIFICATION
    Client registerClient(Client client);

    Client signInClient(String email_Client, String mdp_Client);

    //GESTION DE COLIS
    Colis addColisToClient(String reference, Long id_Client);

    List<Colis> findAllColisByClient(Client client);

    void removeColis(Colis colis, Client client);

    // MISE A JOUR D'INFORMATIONS (PROFILE CLIENT)
    Client UpdateMdpClient(Client client, String ancienMdp, String mdp);

    Client UpdateClient(Client client);

    // RECHERCHE D'INFORMATION
    List<Client> findAllClient();

    Optional<Client> findClientById(Long id);

    Client findClientByEmail(String email);

    void deleteClient(Client client);
}