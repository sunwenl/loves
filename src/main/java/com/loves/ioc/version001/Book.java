package com.loves.ioc.version001;

import lombok.Data;

import java.io.Serializable;

@Data
public class Book implements Serializable {

    private int id;

    private String name;
}
