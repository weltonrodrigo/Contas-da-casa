package org.familianascimento.rodrigo.contasdacasa;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.parse.ParseObject;

import java.util.Date;


public class NovaDespesa extends AppCompatActivity{

    private EditText mNomeField;
    private EditText mValorField;
    private EditText mVencimentoField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_despesa);

        mNomeField = (EditText) findViewById(R.id.nomeEditText);
        mValorField = (EditText) findViewById(R.id.valorEditText);
        mVencimentoField = (EditText) findViewById(R.id.vencimentoEditText);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nova_despesa, menu);
        return true;
    }

    public void saveNovaDespesa() {

        if(TextUtils.isEmpty(mNomeField.getText().toString())){
            mNomeField.setError("Não pode ser vazio");
        }
        if(TextUtils.isEmpty(mValorField.getText().toString())){
            mValorField.setError("Não pode ser vazio");
        }
        if(TextUtils.isEmpty(mVencimentoField.getText().toString())){
            mVencimentoField.setError("Não pode ser vazio");
        }

        ParseObject parseObject = new ParseObject("Despesa");
        parseObject.put("nome", mNomeField.getText().toString());
        parseObject.put("valor", mNomeField.getText().toString());
        parseObject.put("vencimento", new Date( mNomeField.getText().toString() ) );

        parseObject.saveInBackground();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {
            case R.id.action_add:
                saveNovaDespesa();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
