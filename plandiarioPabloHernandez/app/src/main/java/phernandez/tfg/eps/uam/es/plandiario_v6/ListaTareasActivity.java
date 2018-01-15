package phernandez.tfg.eps.uam.es.plandiario_v6;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaTareasActivity extends AppCompatActivity {

    TableLayout tbly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas);
        tbly = findViewById(R.id.tbly);
        ArrayList<String> tareas = new ArrayList<>();

        int s = R.drawable.cocinar;



        tareas.add("prueba1");
        tareas.add("prueba2");
        tareas.add("prueba3");
        tareas.add("prueba4");
        tareas.add("prueba5");
        tareas.add("prueba6");
        tareas.add("prueba7");
        tareas.add("prueba8");
        tareas.add("prueba9");
        tareas.add("prueba10");
        tareas.add("prueba11");
        TableRow row=null;
        int i=0;
        for (String nombreTarea : tareas) {
            if(i%2==0) {
                row = new TableRow(this);
                row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            }

            LinearLayout lyIn = new LinearLayout(this);
            android.view.ViewGroup.LayoutParams params = lyIn.getLayoutParams();
            if (params == null) {
                lyIn.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            } else {
                params.width = TableRow.LayoutParams.FILL_PARENT;
                params.height = TableRow.LayoutParams.WRAP_CONTENT;
                lyIn.setLayoutParams(params);
            }
            lyIn.setOrientation(LinearLayout.VERTICAL);

            ImageView img = new ImageView(this);
            img.setAdjustViewBounds(true);
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            if (i%2==0)
                img.setImageResource(R.drawable.cocinar);
            else
                img.setImageResource(R.drawable.hacerlacama);

            img.setMaxWidth(calculoWidht(2));
            img.setMaxHeight(calculoHeight(4));

            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));


            TextView texto = new TextView(this);
            texto.setText(nombreTarea);
            texto.setTextColor(Color.BLACK);
            LinearLayout.LayoutParams paramText = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            texto.setGravity(View.TEXT_ALIGNMENT_GRAVITY);
            texto.setLayoutParams(paramText);


            lyIn.addView(img);
            lyIn.addView(texto);
            row.addView(lyIn);
            View v = new View(this);
            v.setLayoutParams(new TableRow.LayoutParams(5, TableRow.LayoutParams.MATCH_PARENT));
            v.setBackgroundColor(Color.rgb(50, 50, 50));
            row.addView(v);
            if(i%2==1){
                // Added Horizontal line as
                View view = new View(this);
                view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 5));
                view.setBackgroundColor(Color.rgb(50, 50, 50));
                tbly.addView(view);
                tbly.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
            if(i==tareas.size()-1) {
                View view = new View(this);
                view.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 5));
                view.setBackgroundColor(Color.rgb(50, 50, 50));
                tbly.addView(view);
                tbly.addView(row, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            }
            i++;

        }

    }

    //METODO PARA CALCULAR LAS MEDIDAS DE LAS PANTALLAS Y LOS DP
    public int calculoWidht(int div){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        return width/div;

    }
    public int calculoHeight(int div){

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;

        return height/div;

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
            case R.id.preferencias:
                Intent intent = new Intent(getApplicationContext(),AjustesActivity.class);
                startActivity(intent);
                //finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
