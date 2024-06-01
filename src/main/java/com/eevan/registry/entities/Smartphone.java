package com.eevan.registry.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "Smartphone")
@Entity
@Getter
@Setter
public class Smartphone extends AbstractAppliance{
    private long id;
    private String modelName;
    private String modelSerialNumber;
    private String modelColor;
    private int modelSize;
    private BigDecimal modelPrice;
    private int modelMemory;
    private int modelCamera;
    private boolean modelAvailability;
}
