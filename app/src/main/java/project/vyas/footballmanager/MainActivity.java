package project.vyas.footballmanager;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import project.vyas.footballmanager.adpater.FixtureViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    Drawer drawer;
    Toolbar myToolbar;
    ActionBar bar;
    ViewPager viewPager;
    PrimaryDrawerItem item1;
    PrimaryDrawerItem item2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new FixtureViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setCurrentItem(1);

        myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        bar = getSupportActionBar();
        if(bar != null){
            bar.setTitle("Football");
        }

        item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Select League");
        item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Select Team");

        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(myToolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new DividerDrawerItem()
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener(){
                    @Override
                    public boolean onItemClick(View view,int position,IDrawerItem drawerItem){
                        Intent intent = new Intent(getApplicationContext(), TeamViewActivity.class);
                        intent.putExtra("Team Name","F C Barcelona");
                        startActivity(intent);
                        return true;
                    }
                })
                . withTranslucentStatusBar(false)
                .withActionBarDrawerToggle(true)
                .build();

    }

}