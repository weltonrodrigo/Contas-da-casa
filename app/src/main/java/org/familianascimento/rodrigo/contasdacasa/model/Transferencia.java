package org.familianascimento.rodrigo.contasdacasa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Date;

/**
 * {Contas da Casa}
 * Created by weltonnascimento on 24/05/15.
 */
@ParseClassName("Transparencia")
public class Transferencia extends ParseObject {

    public Date getData() {
        return getDate("data");
    }

    public void setData(Date data) {
        put("data", data);
    }

    public double getValor() {
        return getDouble("valor");
    }

    public void setValor(double valor) {
        put("valor", valor);
    }

    public Morador getOrigem() {
        return (Morador) getParseObject("origem");
    }

    public void setOrigem(Morador origem) {
        put("origem", origem);
    }

    public Morador getDestino() {
        return (Morador) getParseObject("destino");
    }

    public void setDestino(Morador destino) {
        put("destino", destino);
    }

    public Date getMesBase() {
        return getDate("mesBase");
    }

    public void setMesBase(Date mesBase) {
        put("mesBase", mesBase);
    }
}
