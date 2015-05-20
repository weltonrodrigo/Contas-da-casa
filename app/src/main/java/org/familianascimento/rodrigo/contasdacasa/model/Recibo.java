package org.familianascimento.rodrigo.contasdacasa.model;

import com.orm.SugarRecord;

import java.util.Calendar;

/**
 * {Contas-da-casa}
 * Created by weltonnascimento on 19/05/15.
 */
public class Recibo extends SugarRecord<Recibo> {

    // Valor do recibo
    double valor;

    // Data em que ocorreu o pagamento
    Calendar dataDePagamento;

    // Fatura a que se refere
    Fatura fatura;

    // Quem pagou
    Morador credor;

    public Recibo() {

    }

    public Recibo(double valor, Calendar dataDePagamento, Fatura fatura, Morador credor) {
        this.valor = valor;
        this.dataDePagamento = dataDePagamento;
        this.fatura = fatura;
        this.credor = credor;
    }
}
