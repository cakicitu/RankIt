package com.example.rankit;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    private Button btnMOVIES,btnTVSHOWS,btnANIME,btnGAMES,btnBOOKS,btnMANGA;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(ContextCompat.getColor(MainMenu.this,R.color.black));

        btnMOVIES = findViewById(R.id.btnMOVIES);
        btnTVSHOWS = findViewById(R.id.btnTVSHOWS);
        btnANIME = findViewById(R.id.btnANIME);
        btnGAMES = findViewById(R.id.btnGAMES);
        btnBOOKS = findViewById(R.id.btnBOOKS);
        btnMANGA = findViewById(R.id.btnMANGA);

        btnMOVIES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMoviesMenu();
            }
        });
        btnTVSHOWS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTVShowsMenu();
            }
        });
        btnANIME.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnimeMenu();
            }
        });
        btnGAMES.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGamesMenu();
            }
        });
        btnMANGA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMangaMenu();
            }
        });
        btnBOOKS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBooksMenu();
            }
        });
    }

    private void openBooksMenu() {
        Intent intent = new Intent(this, BooksMenu.class);
        startActivity(intent);
    }

    private void openMangaMenu() {
        Intent intent = new Intent(this, MangaMenu.class);
        startActivity(intent);
    }

    private void openGamesMenu() {
        Intent intent = new Intent(this, GamesMenu.class);
        startActivity(intent);
    }

    private void openAnimeMenu() {
        Intent intent = new Intent(this, AnimeMenu.class);
        startActivity(intent);
    }

    private void openTVShowsMenu() {
        Intent intent = new Intent(this, TVShowsMenu.class);
        startActivity(intent);
    }

    private void openMoviesMenu() {
        Intent intent = new Intent(this, MoviesMenu.class);
        startActivity(intent);
    }
}