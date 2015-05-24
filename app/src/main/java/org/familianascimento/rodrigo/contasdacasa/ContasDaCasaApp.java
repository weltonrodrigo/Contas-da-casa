package org.familianascimento.rodrigo.contasdacasa;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

import org.familianascimento.rodrigo.contasdacasa.model.Fatura;
import org.familianascimento.rodrigo.contasdacasa.model.Morador;
import org.familianascimento.rodrigo.contasdacasa.model.Recibo;
import org.familianascimento.rodrigo.contasdacasa.model.Transferencia;

/**
 *
 * Created by weltonnascimento <rodrigo@familianascimento.org> on 12/05/15.
 */
public class ContasDaCasaApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        ParseObject.registerSubclass(Morador.class);
        ParseObject.registerSubclass(Fatura.class);
        ParseObject.registerSubclass(Transferencia.class);
        ParseObject.registerSubclass(Recibo.class);

        Parse.initialize(
                this,
                "gTsUhcAq4nQ9m6Dyj4FzDCPL9sJpNVDVwd7CzK8n",
                "skzHZR9QfdvwD87xi85yOPavyUBQVCA2Kq2mBKQf");
    }
}