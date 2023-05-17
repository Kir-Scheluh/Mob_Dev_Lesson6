package com.mirea.schelukhinka.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.mirea.schelukhinka.lesson6.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding	= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        SharedPreferences preferences	= getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
        String group = preferences.getString("Group", "");
        int numberInList = preferences.getInt("NumberInList", 0);
        String favoriteFilm = preferences.getString("Film", "");

        binding.editTextTextGroup.setText(group);
        binding.editTextNumberList.setText(String.valueOf(numberInList));
        binding.editTextTextFilm.setText(favoriteFilm);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences_bt = getSharedPreferences("mirea_settings",	Context.MODE_PRIVATE);
                SharedPreferences.Editor editor_bt	= preferences_bt.edit();
                editor_bt.putString("Group", binding.editTextTextGroup.getText().toString());
                editor_bt.putInt("NumberInList", Integer.parseInt(binding.editTextNumberList.getText().toString()));
                editor_bt.putString("Film",binding.editTextTextFilm.getText().toString());
                editor_bt.apply();
            }
        });
    }
}