package com.example.lr3_lamaev;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ArrayList<Game> games = new ArrayList<Game>();
    ListView counriesList;
    private ProgressBar loadingProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инцилизация списка

        // получаем элемент ListView
        counriesList = findViewById(R.id.gameList);
        loadingProgressBar = findViewById(R.id.loadingProgressbar);

        // Создаем и запускаем поток с анимацией загрузки
        new Thread(new LoadingThread(this)).start();
    }

    // Метод для инициализации списка
    public void setInitialData()
    {
        games.add(new Game("The legend of zelda:BOTW", "Nintendo", R.drawable.botw));
        games.add(new Game("Elden Ring", "FromSoftware", R.drawable.elden_ring));
        games.add(new Game("Skyrim", "Bethesda Softworks", R.drawable.skyrim));
    }

    // Метод для управления ProgressBar
    public void hideLoadingProgressBar()
    {
        loadingProgressBar.setVisibility(View.GONE);
    }

    // Метод для управления ListView
    public void showCountriesList()
    {
        counriesList.setVisibility(View.VISIBLE);
    }

    public void setCountriesListAdapter(GameAdapter adapter)
    {
        counriesList.setAdapter(adapter);
    }

    // Метод для получения данных
    public ArrayList<Game> getGames()
    {
        return games;
    }


}
