package org.example;
import lombok.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
@Builder
@ToString

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
/*Creo Clientes
            Cliente c1 = Cliente.builder().Nombre("Pepe").Apellido("Rana").DNI(23481045).build();
            Cliente c2 = Cliente.builder().Nombre("Fabricio").Apellido("Puerreydon").DNI(67301835).build();
            Cliente c3 = Cliente.builder().Nombre("Maria").Apellido("Rodriguez").DNI(12435678).build();
            Cliente c4 = Cliente.builder().Nombre("Luisa").Apellido("Rodriguez").DNI(12273982).build();
            Cliente c5 = Cliente.builder().Nombre("Pepe").Apellido("Armadin").DNI(12479534).build();
//Creo Domicilios
            Domicilio dom1 = Domicilio.builder().NombreCalle("San Juan").numero(1268).build();
            Domicilio dom2 = Domicilio.builder().NombreCalle("Av Las Heras").numero(1678).build();
            Domicilio dom3 = Domicilio.builder().NombreCalle("Av Cipolletti").numero(61).build();
            Domicilio dom4 = Domicilio.builder().NombreCalle("Moron").numero(901).build();
            Domicilio dom5 = Domicilio.builder().NombreCalle("San Martin").numero(148).build();
//Creo Facturas
            Factura f1 = Factura.builder().Fecha("12/08/2021").Numero(123).build();
            Factura f2 = Factura.builder().Fecha("23/12/2024").Numero(474).build();
            Factura f3 = Factura.builder().Fecha("17/08/2023").Numero(894).build();
            Factura f4 = Factura.builder().Fecha("30/08/2020").Numero(109).build();
            Factura f5 = Factura.builder().Fecha("11/08/2021").Numero(921).build();
//Creo DetallesFactura
            DetalleFactura det1 = DetalleFactura.builder().Cantidad(2).Subtotal(1000).build(); // 2 Leches
            DetalleFactura det2 = DetalleFactura.builder().Cantidad(2).Subtotal(3000).build();// 2 quesos
            DetalleFactura det3 = DetalleFactura.builder().Cantidad(1).Subtotal(1500).build();// 1 queso
            DetalleFactura det4 = DetalleFactura.builder().Cantidad(1).Subtotal(2500).build(); //1 coca
            DetalleFactura det5 = DetalleFactura.builder().Cantidad(2).Subtotal(5000).build();// 2 cocas
            DetalleFactura det6 = DetalleFactura.builder().Cantidad(2).Subtotal(1400).build(); // 2 jabones
            DetalleFactura det7 = DetalleFactura.builder().Cantidad(8).Subtotal(3200).build();// 8 manzanas
            DetalleFactura det8 = DetalleFactura.builder().Cantidad(6).Subtotal(2400).build();// 6 manzanas
//Creo Articulos
            Articulo a1 = Articulo.builder().Cantidad(50).Precio(500).Denominacion("Leche").build();
            Articulo a2 = Articulo.builder().Cantidad(50).Precio(1500).Denominacion("Queso Ricota").build();
            Articulo a3 = Articulo.builder().Cantidad(50).Precio(2500).Denominacion("Coca Cola").build();
            Articulo a4 = Articulo.builder().Cantidad(50).Precio(700).Denominacion("Jabon").build();
            Articulo a5 = Articulo.builder().Cantidad(50).Precio(400).Denominacion("Manzanas").build();
//Relacion entre DetallesFactura y Articulos
            det1.setArticulo(a1);
            a1.getDetalle().add(det1);

            det2.setArticulo(a2);
            a2.getDetalle().add(det2);

            det3.setArticulo(a2);
            a2.getDetalle().add(det3);

            det4.setArticulo(a3);
            a3.getDetalle().add(det4);

            det5.setArticulo(a3);
            a3.getDetalle().add(det5);

            det6.setArticulo(a4);
            a4.getDetalle().add(det6);

            det7.setArticulo(a5);
            a5.getDetalle().add(det7);

            det8.setArticulo(a5);
            a5.getDetalle().add(det8);
//Creo Categorias
            Categoria cat1 = Categoria.builder().Denominacion("Lacteos").build();
            Categoria cat2 = Categoria.builder().Denominacion("Bebidas").build();
            Categoria cat3 = Categoria.builder().Denominacion("Limpieza").build();
            Categoria cat4 = Categoria.builder().Denominacion("Frutas y Verduras").build();
//Relaciono Articulo y Categorias y viceversa
            cat1.getArticulos().add(a1);
            a1.getCategorias().add(cat1);

            cat2.getArticulos().add(a3);
            a3.getCategorias().add(cat2);

            cat3.getArticulos().add(a4);
            a4.getCategorias().add(cat3);

            cat1.getArticulos().add(a2);
            a2.getCategorias().add(cat1);

            cat4.getArticulos().add(a5);
            a5.getCategorias().add(cat4);
//Relacion con Cliente 1
            c1.setDomicilio(dom1); //Cliente domicilio
            dom1.setCliente(c1); //Domicilio cliente
            c1.getFacturas().add(f1);//Cliente factura
            f1.setC(c1);// factura cliente
            f1.getDetalle().add(det1);// factura detalle1
            f1.getDetalle().add(det2);//Factura detalle2
            det1.setFactura(f1);//detalle1 factura
            det2.setFactura(f1);//Detalle2 factura

//Relacion con Cliente 2
            c2.setDomicilio(dom2); //Cliente domicilio
            dom2.setCliente(c2); //Domicilio cliente
            c2.getFacturas().add(f2);//Cliente factura
            f2.setC(c2);// factura cliente
            f2.getDetalle().add(det3);// factura detalle1
            f2.getDetalle().add(det4);//Factura detalle2
            det3.setFactura(f2);//detalle1 factura
            det4.setFactura(f2);//Detalle2 factura
//Relacion con Cliente 3
            c3.setDomicilio(dom3); //Cliente domicilio
            dom3.setCliente(c3); //Domicilio cliente
            c3.getFacturas().add(f3);//Cliente factura
            f3.setC(c3);// factura cliente
            f3.getDetalle().add(det5);// factura detalle
            f3.getDetalle().add(det6);//Factura detalle
            det5.setFactura(f3);//detalle factura
            det6.setFactura(f3);//Detalle factura
//Relacion con Cliente 4
            c4.setDomicilio(dom4);
            dom4.setCliente(c4);
            c4.getFacturas().add(f4);
            f4.setC(c4);
            det7.setFactura(f4);
            f4.getDetalle().add(det7);
//Relacion con Cliente 5
            c5.setDomicilio(dom5);
            dom5.setCliente(c5);
            c5.getFacturas().add(f5);
            f5.setC(c5);
            det8.setFactura(f5);
            f5.getDetalle().add(det8);
//Persistencia en Cliente
            entityManager.persist(c1);
            entityManager.persist(c2);
            entityManager.persist(c3);
            entityManager.persist(c4);
            entityManager.persist(c5);
//Persistencia en Domicilio
            entityManager.persist(dom1);
            entityManager.persist(dom2);
            entityManager.persist(dom3);
            entityManager.persist(dom4);
            entityManager.persist(dom5);
//Persistencia en Facturas
            entityManager.persist(f1);
            entityManager.persist(f2);
            entityManager.persist(f3);
            entityManager.persist(f4);
            entityManager.persist(f5);
//Persistencia en DetalleFactura
            entityManager.persist(det1);
            entityManager.persist(det2);
            entityManager.persist(det3);
            entityManager.persist(det4);
            entityManager.persist(det5);
            entityManager.persist(det6);
            entityManager.persist(det7);
            entityManager.persist(det8);
//Persistencia en Articulos
            entityManager.persist(a1);
            entityManager.persist(a2);
            entityManager.persist(a3);
            entityManager.persist(a4);
            entityManager.persist(a5);
//Persistencia en Categorias
            entityManager.persist(cat1);
            entityManager.persist(cat2);
            entityManager.persist(cat3);
            entityManager.persist(cat4);
//Busca el domicilio cuya id sea 1
            Domicilio domicilio = entityManager.find(Domicilio.class, 1L);
//Busca al cliente cuya id sea 1
            Cliente cliente = entityManager.find(Cliente.class, 1L);
//Muestra el DNI del cliente asociado al domicilio con id 1
            System.out.println("Cliente de domicilio: " + domicilio.getCliente().getDNI());
//Muestra el Nombre de la calle asociado al cliente cuyo id es 1
            System.out.println("Domicilio de Cliente: " + cliente.getDomicilio().getNombreCalle());
*/
            Factura f1 = entityManager.find(Factura.class, 1L);
            f1.setNumero(1928);
            entityManager.merge(f1);

//EntityManager flush y commit
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
        entityManagerFactory.close();

    }
}
