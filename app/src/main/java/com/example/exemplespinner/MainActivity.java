package com.example.exemplespinner;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**Aplicacio desenvolupada per L. Lopez
 * Activitat que mostra com a resultat la seleccio d'un deplegable (Spinner) */


public class MainActivity extends AppCompatActivity {

    private Spinner spn;
    private TextView textResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Capturem les referencies als dos elements del layout a modificar

        //Resultat
        textResultat =(TextView)findViewById(R.id.textResultat);

        //Spinner
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.dies_setmana, android.R.layout.simple_spinner_item);
        spn = (Spinner) findViewById(R.id.spinner);
        spn.setAdapter(adapter);
        spn.setPrompt(getResources().getString(R.string.info_spinner));
        textResultat.setText(getResources().getString(R.string.textResultat) + ": " );   //Amb opcio per defecte no mostrem cap resultat

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Decidir que fer amb l'opcio seleccionada

                textResultat.setText(getResources().getString(R.string.textResultat) + ": " + spn.getItemAtPosition(position).toString());   //En qualsevol cas imprimim l'opcio escollida

            }

            @Override
            public void onNothingSelected(AdapterView position) {   //No fer res si no s'ha seleccionat cap opco de l'spinner

            }
        });
    }


}
