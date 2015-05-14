package org.familianascimento.rodrigo.contasdacasa;

import android.app.DatePickerDialog;
import android.support.v4.app.NavUtils;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class NovaDespesa extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, View.OnFocusChangeListener {

    private EditText mNomeField;
    private EditText mValorField;
    private EditText mVencimentoField;
    private long mVencimentoMillis;
    private MenuItem mActionProgressMenuItem;
    private MenuItem mAcceptMenuItem;

    private ParseObject mDespesa;

    private DatePickerDialog mDatePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_nova_despesa);

        mNomeField = (EditText) findViewById(R.id.nomeEditText);
        mValorField = (EditText) findViewById(R.id.valorEditText);
        mVencimentoField = (EditText) findViewById(R.id.vencimentoEditText);

        mVencimentoField.setOnFocusChangeListener(this);

        // Check if we must initialize na new one or editing.
        if (savedInstanceState.containsKey("item_id")){

            freezeFields();
            showProgressBar();

            ParseQuery parseQuery = new ParseQuery("Despesa");
            parseQuery.getInBackground(savedInstanceState.getString("item_id"), new GetCallback() {
                @Override
                public void done(ParseObject parseObject, ParseException e) {
                    if (e == null) {
                        mDespesa = parseObject;
                        hideProgressBar();
                        setFields();
                        unFreezeFields();
                    }
                }
            });
        }

    }

    private void setFields() {
        mNomeField.setText( mDespesa.getString("nome") );
        mValorField.setText( mDespesa.getString("valor") );
        mVencimentoMillis = (mDespesa.getDate("vencimento")).getTime();


        String myformat = "dd/MM/yy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(myformat, Locale.US);

        mVencimentoField.setText(simpleDateFormat.format(mVencimentoMillis));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nova_despesa, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if(mActionProgressMenuItem == null) {
            mActionProgressMenuItem = menu.findItem(R.id.action_new_progress);
        }
        if (mAcceptMenuItem == null) {
            mAcceptMenuItem = menu.findItem(R.id.action_add);
        }

        //ProgressBar progressBar = (ProgressBar) MenuItemCompat.getActionView(mActionProgressMenuItem);

        return super.onPrepareOptionsMenu(menu);
    }

    public void saveNovaDespesa() {

        freezeFields();

        showProgressBar();

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
        parseObject.put("valor", mValorField.getText().toString());
        parseObject.put("vencimento", new Date(mVencimentoMillis));

        parseObject.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    NavUtils.navigateUpFromSameTask(NovaDespesa.this);
                }
            }
        });
    }

    private void freezeFields() {
        mNomeField.setFocusable(false);
        mValorField.setFocusable(false);
        mVencimentoField.setFocusable(false);
    }

    private void unFreezeFields() {
        mNomeField.setFocusable(true);
        mValorField.setFocusable(true);
        mVencimentoField.setFocusable(true);
    }

    @Override
    public void onFocusChange (View v, boolean hasFocus) {
        // Just to be sure
        if (hasFocus) {

            Calendar mCalendar = Calendar.getInstance();

            mDatePickerDialog = new DatePickerDialog(
                    this,
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
        mVencimentoMillis = mCalendar.getTimeInMillis();

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

    private void showProgressBar(){
        mAcceptMenuItem.setVisible(false);
        mActionProgressMenuItem.setVisible(true);
    }
    private void hideProgressBar(){
        mActionProgressMenuItem.setVisible(false);
        mAcceptMenuItem.setVisible(true);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mDatePickerDialog = null;
    }
}
