package com.eevan.registry.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "PC")
@Entity
@Getter
@Setter
public class PC extends AbstractAppliance{
    private long id;
    private String modelName;
    private String modelSerialNumber;
    private String modelColor;
    private int modelSize;
    private BigDecimal modelPrice;
    private String modelCategory;
    private String modelProcessor;
    private boolean modelAvailability;
}
