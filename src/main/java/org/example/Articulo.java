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

public class Articulo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int Cantidad;

    private String Denominacion;

    private int Precio;

//Relacion bidireccional con DetalleFactura
    @OneToMany(mappedBy = "articulo")
    @Builder.Default
    private List<DetalleFactura> detalle = new ArrayList<>();
//Relacion con Categoria
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "Articulo_categoria",
            joinColumns = @JoinColumn(name = "Articulo_id"),
            inverseJoinColumns = @JoinColumn(name = "Categotia_id"))
    @Builder.Default
    private List<Categoria> categorias = new ArrayList<>();



}
