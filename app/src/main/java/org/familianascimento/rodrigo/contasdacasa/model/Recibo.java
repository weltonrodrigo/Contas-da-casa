package org.familianascimento.rodrigo.contasdacasa.model;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.Calendar;
import java.util.Date;

/**
 * {Contas da Casa}
 * Created by weltonnascimento on 21/05/15.
 */

@ParseClassName("Recibo")
public class Recibo extends ParseObject {

    double valor;
    Calendar dataPagamento;
    Fatura fatura;
    Morador credor;

    public double getValor() {
        return getDouble("valor");
    }

    public void setValor(double valor) {
        put("valor", valor);
    }

    public Date getDataPagamento() {
        return getDate("dataPagamento");
    }

    public void setDataPagamento(Date dataPagamento) {
        put("dataPagamento", dataPagamento);
    }

    public Fatura getFatura() {
        return (Fatura) getParseObject("fatura");
    }

    public void setFatura(Fatura fatura) {
        put("fatura ", fatura);
    }

    public Morador getCredor() {
        return (Morador) getParseObject("credor");
    }

    public void setCredor(Morador credor) {
        put("credor", credor);
    }
}
