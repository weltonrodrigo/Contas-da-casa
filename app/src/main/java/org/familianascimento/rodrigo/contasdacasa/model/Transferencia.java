package org.familianascimento.rodrigo.contasdacasa.model;

import com.orm.SugarRecord;

import java.util.Calendar;

/**
 * {Contas-da-casa}
 * Created by weltonnascimento on 19/05/15.
 */
public class Transferencia extends SugarRecord<Transferencia> {

    // Data em que ocorreu
    Calendar data;

    // Valor da transferência
    double valor;

    // Quem transferiu
    Morador concedente;

    // Quem recebeu
    Morador receptor;

    // Mês do ano a que se refere. Janeiro é 0
    int mesBase;

    public Transferencia() {

    }

    public Transferencia(Calendar data, double valor, Morador concedente, Morador receptor, int mesBase) {
        this.data = data;
        this.valor = valor;
        this.concedente = concedente;
        this.receptor = receptor;
        this.mesBase = mesBase;
    }
}