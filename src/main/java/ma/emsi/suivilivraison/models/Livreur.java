package ma.emsi.suivilivraison.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Livreur implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id_Livreur ;
	@Column(nullable = false)
	String nom_Livreur ;
	@Column(nullable = false)
	String telephone_Livreur ;
	@Column(nullable = false, unique = true)
	String email_Livreur;
	@Column(nullable = false)
	String mdp_Livreur;


}
