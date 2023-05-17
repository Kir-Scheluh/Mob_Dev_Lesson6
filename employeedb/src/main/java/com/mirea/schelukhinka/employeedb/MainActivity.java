package com.mirea.schelukhinka.employeedb;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = App.getInstance().getDatabase();
        SuperheroDao superheroDao = db.employeeDao();
        Superhero superhero = new Superhero();
        superhero.id = 1;
        superhero.name = "Saitama";
        superhero.powerScore = 999;
        superheroDao.insert(superhero);
        List<Superhero> superheroes = superheroDao.getAll();
        superhero = superheroDao.getById(1);
        superhero.powerScore = 1000;
        superheroDao.update(superhero);
        Log.d(TAG, superhero.name + " " + superhero.powerScore);
    }
}