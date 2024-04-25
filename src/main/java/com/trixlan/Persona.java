package com.trixlan;

import javax.persistence.*;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name="persona")
public class Persona extends PanacheEntity {
 
    public String nombre;
    public String apellido;

}