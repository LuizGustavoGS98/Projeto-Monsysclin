/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.monsysclin.Controller;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Luiz Gustavo
 */
public class Conexao2 {

    private BasicDataSource datasource;
    private String stringUrl = "jdbc:mysql://0.0.0.0:3306/monsysclin";

    public Conexao2() {
        this.datasource = new BasicDataSource();
        this.datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        this.datasource.setUrl(stringUrl);
        this.datasource.setUsername("root");
        this.datasource.setPassword("urubu100");
    }

    // Getter
    public BasicDataSource getDatasourceMysql() {
        return datasource;
    }

    public String getStringUrlMysql() {
        return stringUrl;
    }
}
