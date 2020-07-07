package com.example.libreriaultimatum2019_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class casita extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casita);
    }























    //CREADOR MENU 3 PUNTOS
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    //OPCIONES MENU 3PUNTOS
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i;
        int opcion = item.getItemId();
        //case R.id.menuAcercaDe:
        if (opcion == R.id.menuAcercaDe) {
            i = new Intent(this, Acerca_de.class);
            startActivity(i);
                /*String aboutTxt = "(c) 2020 Master-A";
                Toast.makeText(MainActivity.this, aboutTxt,
                        Toast.LENGTH_LONG).show();*/
            //break;
        }

        //case R.id.salir:
        if (opcion == R.id.salir) {
            AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
            dialogo.setTitle("Estas apunto de salir");
            dialogo.setMessage("Estas seguro de que quieres salir de esta maravillosa APP?");
            //Hacemos un boton positivo
            dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast t = Toast.makeText(getApplicationContext(), "Gracias por darme otra oportunidad", Toast.LENGTH_SHORT);
                    t.show();
                }
            });
            dialogo.show();
        }
        return super.onOptionsItemSelected(item);
    }

}
