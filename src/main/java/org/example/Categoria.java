package org.example;
import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Audited

public class Categoria implements Serializable{
        @Serial
        private static final long serialVersionUID = 1L;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String Denominacion;

//Relacion bidireccional con Articulo
        @ManyToMany(mappedBy = "categorias")
        @Builder.Default
        private List<Articulo> articulos = new ArrayList<>();

}
