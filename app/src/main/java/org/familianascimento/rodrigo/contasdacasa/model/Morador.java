package org.familianascimento.rodrigo.contasdacasa.model;

import com.orm.SugarRecord;

import java.util.Calendar;

/**
 * Created by weltonnascimento on 19/05/15.
 */
public class Morador extends SugarRecord<Morador> {

    // Morador name;
    public String nome;

    // His photo. Must be an URI for now.
    public String photoUri;

    // When he joined the house
    public Calendar dataDeIngresso;

    //Whe he left the house
    public Calendar dataDeSaida;

    //His facebook id
    public int facebookId;

    public Morador() {
    }

    public Morador(String nome, String photoUri, Calendar dataDeIngresso, Calendar dataDeSaida, int facebookId) {
        this.nome = nome;
        this.photoUri = photoUri;
        this.dataDeIngresso = dataDeIngresso;
        this.dataDeSaida = dataDeSaida;
        this.facebookId = facebookId;
    }
}
