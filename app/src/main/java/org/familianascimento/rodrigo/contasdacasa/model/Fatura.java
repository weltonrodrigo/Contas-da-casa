package org.familianascimento.rodrigo.contasdacasa.model;

import com.orm.SugarRecord;

import java.util.Calendar;
import java.util.List;

/**
 * {Contas-da-casa}
 * Created by weltonnascimento on 19/05/15.
 */
public class Fatura extends SugarRecord<Fatura> {

    // Valor inicial da fatura
    double valor;

    // Dia em que se deve pagar a fatura
    Calendar vencimento;

    // Many-to-many relationship with Morador class
    // This is a comma-separated list of Morador ID
    // TODO: helper methods to add and remove from this list.
    String devedores;

    // Valor em aberto da fatura depois dos pagamentos
    double saldoDevedor;

    // Tipo, modelo desta fatura.
    String tipo;

    // Breve descrição
    String descricao;

    // Código de barras
    String codigoDeBarras;

    // URI da photo
    String photoURI;

    // Mês do ano a que se refere. Janeiro é 0;
    int mesBase;

    public Fatura() {

    }

    public Fatura(double valor, Calendar vencimento, String devedores, double saldoDevedor, String tipo, String descricao, String codigoDeBarras, String photoURI, int mesBase) {
        this.valor = valor;
        this.vencimento = vencimento;
        this.devedores = devedores;
        this.saldoDevedor = saldoDevedor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.codigoDeBarras = codigoDeBarras;
        this.photoURI = photoURI;
        this.mesBase = mesBase;
    }

    // One-to-many relationship with Recibo class
    public List<Recibo> getRecibos() {
        return Recibo.find(Recibo.class, "fatura = ?", this.getId().toString());
    }
}
