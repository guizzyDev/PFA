package ma.emsi.suivilivraison.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class MdpChanger implements Serializable {

    String nvmdp ;
    String ancienmdp ;

}
