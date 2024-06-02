package com.eevan.registry.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApplianceErrorResponse {
    private String message;
    private long timestamp;
}
