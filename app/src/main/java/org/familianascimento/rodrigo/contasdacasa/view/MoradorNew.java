package org.familianascimento.rodrigo.contasdacasa.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import org.familianascimento.rodrigo.contasdacasa.R;
import org.familianascimento.rodrigo.contasdacasa.model.Morador;

import java.util.Calendar;

public class MoradorNew extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morador_new);

        getActionBar().setDisplayHomeAsUpEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_morador_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_done) {

            EditText moradorNome = (EditText) findViewById(R.id.morador_nome);

            Calendar a = Calendar.getInstance();
            Calendar b = Calendar.getInstance();

            a.set(2008, 1, 15);
            b.set(2014, 10, 12);


            Morador novoMorador = new Morador(
                    moradorNome.getText().toString(),
                    "http://semphoto.com.br",
                    a,
                    b,
                    20021323);

            novoMorador.save();

            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
