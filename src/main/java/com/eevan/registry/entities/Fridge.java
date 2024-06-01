package com.eevan.registry.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "Fridge")
@Entity
@Getter
@Setter
public class Fridge extends AbstractAppliance{
    private long id;
    private String modelName;
    private String modelSerialNumber;
    private String modelColor;
    private int modelSize;
    private BigDecimal modelPrice;
    private int modelDoors;
    private String modelCompressor;
    private boolean modelAvailability;
}
