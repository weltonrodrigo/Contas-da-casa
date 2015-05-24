package org.familianascimento.rodrigo.contasdacasa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseRelation;

import java.util.Date;

/**
 * {Contas da Casa}
 * Created by weltonnascimento on 24/05/15.
 */

@ParseClassName("Fatura")
public class Fatura extends ParseObject {

    public double getValor() {
        return getDouble("valor");
    }

    public void setValor(double valor) {
        put("valor", valor);
    }

    public Date getVencimento() {
        return getDate("vencimento");
    }

    public void setVencimento(Date vencimento) {
        put("vencimento", vencimento);
    }

    public double getSaldoDevedor() {
        return getDouble("saldoDevedor");
    }

    public void setSaldoDevedor(double saldoDevedor) {
        put("saldoDevedor", saldoDevedor);
    }

    public String getDescricao() {
        return getString("descricao");
    }

    public void setDescricao(String descricao) {
        put("descricao", descricao);
    }

    public String getCodBarras() {
        return getString("codBarras");
    }

    public void setCodBarras(String codBarras) {
        put("codBarras", codBarras);
    }

    public Date getMesBase() {
        return getDate("mesBase");
    }

    public void setMesBase(Date mesBase) {
        put("mesBase", mesBase);
    }

    public ParseRelation<Recibo> getRelationRecibos() {
        return getRelation("recibos");
    }

    public ParseRelation<Morador> getRelationMoradores() {
        return getRelation("recibos");
    }
}
