package phernandez.tfg.eps.uam.es.plandiario_v6;

import android.app.Dialog;
import android.content.Intent;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AjustesActivity extends PreferenceActivity {
    private boolean contracorrec=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);

        showDialogPassword();
    }


    public void showDialogPassword(){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_password);

        TextView titulo = dialog.findViewById(R.id.titulopwd);

        final EditText pwnm1 = dialog.findViewById(R.id.pwdnmb1);
        //pwnm1.setBackgroundResource(R.drawable.edittext_border);
        final EditText pwnm2 = dialog.findViewById(R.id.pwdnmb2);


        final EditText pwnm3 = dialog.findViewById(R.id.pwdnmb3);

        final EditText pwnm4 = dialog.findViewById(R.id.pwdnmb4);



        View.OnKeyListener keylist = new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(pwnm1.isFocused()) {
                        pwnm2.requestFocus();
                }else if(pwnm2.isFocused() && pwnm2.getText().length()==1) {
                        pwnm3.requestFocus();
                }else if(pwnm3.isFocused() && pwnm3.getText().length()==1) {
                    pwnm4.requestFocus();
                }
                if(pwnm4.isFocused() && keyCode == KeyEvent.KEYCODE_DEL) {
                    pwnm3.requestFocus();
                }else if(pwnm3.isFocused() && keyCode == KeyEvent.KEYCODE_DEL) {
                    pwnm2.requestFocus();
                }else if(pwnm2.isFocused() && keyCode == KeyEvent.KEYCODE_DEL) {
                    pwnm1.requestFocus();
                }
                return false;
            }
        };


        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        pwnm1.setOnKeyListener(keylist);
        //pwnm1.setBackground(getResources().getDrawable(R.drawable.edittext_border));
        pwnm2.setOnKeyListener(keylist);
        pwnm3.setOnKeyListener(keylist);
        pwnm4.setOnKeyListener(keylist);

        Button btacp = dialog.findViewById(R.id.btacep);

        btacp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pwnm1.getText().toString().isEmpty() || pwnm2.getText().toString().isEmpty() || pwnm3.getText().toString().isEmpty() || pwnm4.getText().toString().isEmpty()){
                    Toast.makeText(AjustesActivity.this, R.string.fallo_password_empty, Toast.LENGTH_SHORT).show();

                }else{
                    if (Integer.parseInt(pwnm1.getText().toString()) == 1 && Integer.parseInt(pwnm2.getText().toString()) == 2
                            && Integer.parseInt(pwnm3.getText().toString()) == 3 && Integer.parseInt(pwnm4.getText().toString()) == 4){
                        dialog.dismiss();
                    }else{
                        Toast.makeText(AjustesActivity.this, R.string.fallo_password, Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.information:
                Intent intent = new Intent(getApplicationContext(),InformacionActivity.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
