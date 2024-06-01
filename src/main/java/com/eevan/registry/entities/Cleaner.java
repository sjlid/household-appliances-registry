package com.eevan.registry.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Table(name = "Cleaner")
@Entity
@Getter
@Setter
public class Cleaner extends AbstractAppliance{
    private long id;
    private String modelName;
    private String modelSerialNumber;
    private String modelColor;
    private int modelSize;
    private BigDecimal modelPrice;
    private int modelVolume;
    private int modelWorkModes;
    private boolean modelAvailability;
}
