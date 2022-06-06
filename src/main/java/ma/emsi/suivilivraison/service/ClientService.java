package ma.emsi.suivilivraison.service;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private IColisService colisService;

    //AUTHENTIFICATION / INSCRIPTION / MISE A JOUR D'INFORMATION

    // AUTHENTIFICATION
    @Override
    public Client registerClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client signInClient(String email_Client, String mdp_Client) {
        return clientRepository.findClientByEmail_ClientAndMdp_Client(email_Client, mdp_Client);
    }
    //GESTION DE COLIS
    @Override
    public Colis addColisToClient(String reference, Long id_Client) {
        Colis colis ;
      colis =  colisService.findColisByReference(reference);
        Client client = clientRepository.getReferenceById(id_Client);
        colis.setClient(client);
        return colisService.addColis(colis);
    }

    @Override
    public List<Colis> findAllColisByClient(Client client) {
        return colisService.findAllByClient(client);
    }
    @Override
    public void removeColis(Colis colis , Client client ){
        if(colis.getClient().equals(client)){
            colisService.removeClientFromColis(colis);
        }
    }
    // MISE A JOUR D'INFORMATIONS (PROFILE CLIENT)
    @Override
    public Client UpdateMdpClient(Client client, String ancienMdp, String mdp) {
        //    if(client.getMdp_Client().equals(ancienMdp)){
            client.setMdp_Client(mdp);
            return clientRepository.save(client);
   //     }else return null;
        }
    @Override
    public Client UpdateClient(Client client) {
        return clientRepository.save(client);
    }

    // RECHERCHE D'INFORMATION
    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> findClientById(Long id) {
      return clientRepository.findById(id);
    }

    @Override
    public Client findClientByEmail(String email) {
        return clientRepository.findClientByEmail_Client(email);
    }

// METHODE DE SUPRESSION

    @Override
    public void deleteClient(Client client) {
        clientRepository.delete(client);
    }


}
