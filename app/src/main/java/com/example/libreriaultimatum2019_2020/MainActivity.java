package com.example.libreriaultimatum2019_2020;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

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

        public boolean onNavigationItemSelected(MenuItem menuItem) {


            int id = menuItem.getItemId();

            if (id == R.id.nav_home) {
                Intent i=new Intent(this,casita.class);
                startActivity(i);
                /*libros2 librosf = new libros2();
                librosf.setEnterTransition(new Slide(Gravity.RIGHT));
                librosf.setExitTransition(new Slide(Gravity.LEFT));
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragments,librosf);
                ft.commit();*/
            } else if (id == R.id.nav_gallery) {
                LibrosFragment librosFragment = LibrosFragment.newInstance(2);
                librosFragment.setEnterTransition(new Slide(Gravity.RIGHT));
                librosFragment.setExitTransition(new Slide(Gravity.LEFT));
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragments, librosFragment);
                ft.commit();

            } else if (id == R.id.nav_slideshow) {
                AutoresFragment librosFragment = AutoresFragment.newInstance();
                librosFragment.setEnterTransition(new Slide(Gravity.RIGHT));
                librosFragment.setExitTransition(new Slide(Gravity.LEFT));
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragments,librosFragment);
                ft.commit();

            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;


    }
}






