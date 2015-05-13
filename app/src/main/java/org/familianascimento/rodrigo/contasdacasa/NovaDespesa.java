package org.familianascimento.rodrigo.contasdacasa;

import android.app.DatePickerDialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.parse.ParseObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class NovaDespesa extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, View.OnFocusChangeListener {

    private EditText mNomeField;
    private EditText mValorField;
    private EditText mVencimentoField;

    private DatePickerDialog mDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nova_despesa);

        mNomeField = (EditText) findViewById(R.id.nomeEditText);
        mValorField = (EditText) findViewById(R.id.valorEditText);
        mVencimentoField = (EditText) findViewById(R.id.vencimentoEditText);

        mVencimentoField.setOnFocusChangeListener(this);

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
    public void onFocusChange (View v, boolean hasFocus) {
        // Just to be sure
        if (hasFocus) {

            Calendar mCalendar = Calendar.getInstance();

            mDatePickerDialog = new DatePickerDialog(
                    getBaseContext(),
                    this,
                    mCalendar.get(Calendar.YEAR),
                    mCalendar.get(Calendar.MONTH),
                    mCalendar.get(Calendar.DAY_OF_MONTH)
            );
            mDatePickerDialog.show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        Calendar mCalendar = Calendar.getInstance();

        mCalendar.set(Calendar.YEAR, year);
        mCalendar.set(Calendar.MONTH, monthOfYear);
        mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String myformat = "dd/MM/yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myformat, Locale.US);

        mVencimentoField.setText(simpleDateFormat.format(mCalendar.getTime()));

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

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mDatePickerDialog = null;
    }
}
