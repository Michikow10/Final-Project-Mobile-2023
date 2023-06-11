package com.example.h071211013_finalmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.h071211013_finalmobile.fragment.FavoriteFragment;
import com.example.h071211013_finalmobile.fragment.MovieFragment;
import com.example.h071211013_finalmobile.fragment.ShowFragment;

public class MainActivity extends AppCompatActivity {
    TextView header;
    private MovieFragment movieFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView btnFilm = findViewById(R.id.btn_film);
        ImageView btnShow = findViewById(R.id.btn_show);
        ImageView btnFav = findViewById(R.id.btn_fav);
        header = findViewById(R.id.header_text_view);

        FragmentManager fragmentManager = getSupportFragmentManager();

        movieFragment = new MovieFragment();

        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, movieFragment, MovieFragment.class.getSimpleName())
                .commit();

        btnFilm.setOnClickListener(view -> showFragment(new MovieFragment(), "Movies"));

        btnShow.setOnClickListener(view -> showFragment(new ShowFragment(), "TV Shows"));

        btnFav.setOnClickListener(view -> showFragment(new FavoriteFragment(), "Favorites"));
    }

    public void showFragment(Fragment fragment, String title) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);
        if (currentFragment == null ||
                !currentFragment.getClass().getSimpleName().equals(fragment.getClass().getSimpleName())) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            header.setText(title);
        }
    }
}