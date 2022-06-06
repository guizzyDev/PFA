package ma.emsi.suivilivraison.controllers;

import ma.emsi.suivilivraison.models.Client;
import ma.emsi.suivilivraison.models.Colis;
import ma.emsi.suivilivraison.models.MdpChanger;
import ma.emsi.suivilivraison.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController

@RequestMapping("api/client")//pre-path -->  il est necessaire de passer par le prefixe api/client pour acceder aux service du client
public class ClientController
{
    @Autowired
    private IClientService clientService;
// AUTHENTIFICATION
    @PostMapping //api/client/
    public ResponseEntity<?> registerClient(@PathVariable Client client)
    {
        if(client == null ){ return new ResponseEntity<>(HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<>(clientService.registerClient(client), HttpStatus.CREATED);
    }
    @PostMapping("signin") //api/client/signin
    public ResponseEntity<Client> signIn(@RequestBody Client client,HttpServletRequest request)
    {
        client = clientService.signInClient(client.getEmail_Client(),client.getMdp_Client());
        if(client == null ){return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;}


        HttpSession sessionClient = request.getSession();
        sessionClient.setAttribute("Client",client);
        return new ResponseEntity<>( client , HttpStatus.OK);
    }
    @PostMapping("disconnect")//api/client/disconnect
    public ResponseEntity<?> disconnect(@RequestBody Client client,HttpServletRequest request)
    {
        request.getSession().invalidate();
                return new ResponseEntity<>(HttpStatus.OK);
    }
    //GESTION COLIS

    @PostMapping("addcolis") //api/client/addcolis   (body -> reference)
    public ResponseEntity<Colis> addColisToClientList(@RequestBody Colis colis , HttpServletRequest request)
            //A PARTIR DU PARAMETRE COLIS NOUS RECUPERONS UNIQUEMENT LA REFERENCE AFIN DE LE TROUVER MAIS NOUS PASSONS PAR L'OBJET COLIS
    {
        Client client = (Client)request.getSession().getAttribute("Client");
        if(colis== null && client== null){return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
              clientService.addColisToClient(colis.getReference(),client.getId_Client());
        return new ResponseEntity<>(   clientService.addColisToClient(colis.getReference(),client.getId_Client()), HttpStatus.OK);
    }


    //  MISE A JOUR CLIENT -- PROFILE CLIENT
    @PostMapping("updatemdp") //api/client/updateMdp
    public ResponseEntity<String> updateMdpClient(@RequestBody MdpChanger mdpChanger, HttpServletRequest request)
    {
        Client client = (Client)request.getSession().getAttribute("Client");
        if(client == null && mdpChanger == null){return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
client.setMdp_Client(mdpChanger.getNvmdp());
clientService.UpdateMdpClient(client,mdpChanger.getAncienmdp(),mdpChanger.getNvmdp());
        return new ResponseEntity<>(
                 HttpStatus.CREATED);
    }

    @GetMapping("id/{id}")  //api/client/{idClient}
    public ResponseEntity<Client> getClientById(@PathVariable Long id)
    { if(id==null){return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
        Optional<Client> client = clientService.findClientById(id) ;
        return new ResponseEntity<>(client.get(), HttpStatus.OK);
    }
    @GetMapping("email/{email}")  //api/client/{email}
    public ResponseEntity<?> getClientByEmail(@PathVariable String email)
    {  if(email.isEmpty()){return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
        return new ResponseEntity<>(clientService.findClientByEmail(email), HttpStatus.OK);
    }
    @GetMapping("colis")  //api/client/{email}
    public ResponseEntity<?> getColisByClient(HttpServletRequest request) {
        Client client = (Client)request.getSession().getAttribute("Client");
   if(client == null ){return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
        return new ResponseEntity<>(clientService.findAllColisByClient(client), HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping  //api/client/
    public ResponseEntity<List<Client>> getAllClient()
    {
        List<Client> ListClient =  clientService.findAllClient() ;
        return new ResponseEntity<>(ListClient, HttpStatus.OK);
    }




    @DeleteMapping("delete/{clientid}")  //api/client/{clientId}
    public ResponseEntity<?> deleteClient(@PathVariable Client client)
    {   if(client == null ){return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
        clientService.deleteClient(client);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
