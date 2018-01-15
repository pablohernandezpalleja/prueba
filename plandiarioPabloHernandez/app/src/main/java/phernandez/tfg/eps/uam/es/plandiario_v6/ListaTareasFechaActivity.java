package phernandez.tfg.eps.uam.es.plandiario_v6;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Pablo on 7/1/18.
 */

public class ListaTareasFechaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tareas_fecha);
        LinearLayout ly = findViewById(R.id.lyfecha);
        Map<Integer,ArrayList<String>> listatareasfecha= new TreeMap<>();
        ArrayList<String> tareasLunes = new ArrayList<>();
        ArrayList<String> tareasMartes = new ArrayList<>();
        ArrayList<String> tareasMiercoles = new ArrayList<>();
        ArrayList<String> tareasJueves = new ArrayList<>();




        tareasLunes.add("prueba1");
        tareasLunes.add("prueba2");
        tareasLunes.add("prueba3");
        tareasLunes.add("prueba4");
        tareasLunes.add("prueba5");
        tareasMartes.add("prueba6");
        tareasMartes.add("prueba7");
        tareasMartes.add("prueba8");
        tareasMartes.add("prueba9");
        tareasMiercoles.add("prueba10");
        tareasMiercoles.add("prueba11");
        tareasMiercoles.add("prueba11");
        tareasJueves.add("prueba11");
        tareasJueves.add("prueba11");

        listatareasfecha.put(0,tareasLunes);
        listatareasfecha.put(1,tareasMartes);
        listatareasfecha.put(2,tareasMiercoles);
        listatareasfecha.put(3,tareasJueves);

        int i=0;
        for(int diaTareas : listatareasfecha.keySet()) {
            i=0;
            LinearLayout lyFecha = new LinearLayout(getApplicationContext());
            lyFecha.setBackgroundColor(getResources().getColor(R.color.fondodias));
            android.view.ViewGroup.LayoutParams params = lyFecha.getLayoutParams();
            if (params == null) {
                lyFecha.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            } else {
                params.width = LinearLayout.LayoutParams.MATCH_PARENT;
                params.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                lyFecha.setLayoutParams(params);
            }

            TextView diatext = new TextView(getApplicationContext());

            //texto.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));


            diatext.setTextColor(Color.BLACK);
            LinearLayout.LayoutParams paramstext = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            paramstext.gravity= Gravity.CENTER_HORIZONTAL;
            // paramstext.leftMargin=300;
            diatext.setLayoutParams(paramstext);


            ImageView img = new ImageView(getApplicationContext());
            img.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            img.setAdjustViewBounds(true);
            img.setScaleType(ImageView.ScaleType.FIT_CENTER);
            img.setMaxWidth(calculoWidht(4));
            img.setMaxHeight(calculoHeight(14));
            switch (diaTareas){
                case 0:
                    img.setImageResource(R.drawable.lunes);
                    diatext.setText("LUNES");
                    break;
                case 1:
                    img.setImageResource(R.drawable.martes);
                    diatext.setText("MARTES");
                    break;
                case 2:
                    img.setImageResource(R.drawable.miercoles);
                    diatext.setText("MIERCOLES");
                    break;
                case 3:
                    img.setImageResource(R.drawable.jueves);
                    diatext.setText("JUEVES");
                    break;
            }
            lyFecha.addView(img);
            lyFecha.addView(diatext);
            ly.addView(lyFecha);


            for (String nombreTarea : listatareasfecha.get(diaTareas)) {

                LinearLayout lyIn = new LinearLayout(getApplicationContext());
                if (i % 2 == 0)
                    lyIn.setBackgroundColor(getResources().getColor(R.color.fondodiaspar));
                else
                    lyIn.setBackgroundColor(getResources().getColor(R.color.fondodiasimpar));

                android.view.ViewGroup.LayoutParams paramsDay = lyIn.getLayoutParams();
                if (paramsDay == null) {
                    lyIn.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                } else {
                    paramsDay.width = LinearLayout.LayoutParams.MATCH_PARENT;
                    paramsDay.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    lyIn.setLayoutParams(paramsDay);
                }

                ImageView imgTarea = new ImageView(getApplicationContext());
                imgTarea.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                imgTarea.setAdjustViewBounds(true);
                imgTarea.setScaleType(ImageView.ScaleType.FIT_CENTER);
                if (i % 2 == 0)
                    imgTarea.setImageResource(R.drawable.hacerlacama);
                else
                    imgTarea.setImageResource(R.drawable.cocinar);

                imgTarea.setMaxWidth(calculoWidht(4));
                imgTarea.setMaxHeight(calculoHeight(7));

                TextView texto = new TextView(getApplicationContext());

                //texto.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));

                texto.setText(nombreTarea);
                texto.setTextColor(Color.BLACK);

                lyIn.addView(imgTarea);
                lyIn.addView(texto);
                ly.addView(lyIn);
                i++;
            }
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
            /*case R.id.action_nuevo:
                Log.i("ActionBar", "Nuevo!");
                return true;
            case R.id.action_buscar:
                Log.i("ActionBar", "Buscar!");;
                return true;
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");;
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
