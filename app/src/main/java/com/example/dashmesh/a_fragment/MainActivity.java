package com.example.dashmesh.a_fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ExamDetails.OnButtonClick,MainActivityFragment.OnItemClick ,
        MainDisplayFragment.OnButton2Click,MainDisplayFragment.OnButton3Click {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.root_layout, MainDisplayFragment.newInstance(), "rageComicList")
                    .commit();
        }
    }
    @Override
    public void onButtonClick() {
        MainActivityFragment2 collegelistfrag =
                MainActivityFragment2.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, collegelistfrag, "Details2")
                .addToBackStack(null)
                .commit();
    }
        @Override
        public void onItemClick(String Exams) {
            final ExamDetails examfrag =
                    ExamDetails.newInstance();
            Bundle bundle = new Bundle();
            bundle.putString("key", Exams);
            examfrag.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.root_layout, examfrag, "Details")
                    .addToBackStack(null)
                    .commit();
        }
    @Override
    public void onButton2Click() {
        final MainActivityFragment listfrag =
                MainActivityFragment.newInstance();
                getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, listfrag, "exam")
                .addToBackStack(null)
                .commit();
    }
    @Override
    public void onButton3Click() {
         MainActivityFragment2 fragment2 =
                MainActivityFragment2.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.root_layout, fragment2, "Details2")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
