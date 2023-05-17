package com.fiona.insuarance.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ServiceProviders {
    private  int  serviceProviderId;
    private String  name;
}
