package org.familianascimento.rodrigo.contasdacasa;

import android.app.Application;

import com.parse.Parse;

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

        Parse.initialize(
                this,
                "gTsUhcAq4nQ9m6Dyj4FzDCPL9sJpNVDVwd7CzK8n",
                "skzHZR9QfdvwD87xi85yOPavyUBQVCA2Kq2mBKQf");
    }
}
