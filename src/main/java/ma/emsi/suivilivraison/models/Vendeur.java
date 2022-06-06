package ma.emsi.suivilivraison.models;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Vendeur implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id_Vendeur ;
	@Column(nullable = false)
	String nom_Magasin ;
	@Column
	String adresse_Vendeur ;
	@Column(nullable = false, unique = true)
	String email_Vendeur ;
	@Column(nullable = false)
	String mdp_Vendeur  ;




}
