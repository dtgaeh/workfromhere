package dev.dtgaeh.workfromhere.spaces.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "spaces")
public class SpaceResource {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "space_type", nullable = false)
    private SpaceTypeResource type;

    @Column(name = "wifi_available", nullable = false)
    private boolean wifiAvailable;

    @Column(name = "wifi_password")
    private String wifiPassword;

    @Column(name = "wifi_speed")
    private float speed;
}
