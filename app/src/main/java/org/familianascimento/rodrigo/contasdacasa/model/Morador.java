package org.familianascimento.rodrigo.contasdacasa.model;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;

import java.util.Date;

/**
 * {Contas da Casa}
 * Created by weltonnascimento on 21/05/15.
 */
@ParseClassName("Morador")
public class Morador extends ParseObject {

    public String getNome() {
        return getString("nome");
    }

    public void setNome(String nome) {
        put("nome", nome);
    }

    public Date getIngresso() {
        return getDate("dataIngresso");
    }

    public void setIngresso(Date ingresso) {
        put("ingresso", ingresso);
    }

    public Date getSaida() {
        return getDate("dataSaida");
    }

    public void setSaida(Date saida) {
        put("saida", saida);
    }

    public ParseFile getFoto() {
        return getParseFile("foto");
    }

    public void setFoto(ParseFile foto) {
        put("foto", foto);
    }

    public long getFacebookId() {
        return getLong("facebookId");
    }

    public void setFacebookId(long facebookId) {
        put("facebookId", facebookId);
    }
}
