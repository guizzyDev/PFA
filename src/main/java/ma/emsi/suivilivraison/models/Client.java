package ma.emsi.suivilivraison.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity

public class Client implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id_Client ;
	@Column(nullable = false)
	String nom_Client ;
	@Column(nullable = false)
	String telephone_Client ;
	@Column(nullable = false, unique = true)
	String email_Client;
	@Column(nullable = false)
	String mdp_Client;


}
