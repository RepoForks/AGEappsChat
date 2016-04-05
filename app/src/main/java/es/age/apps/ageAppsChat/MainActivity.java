package es.age.apps.ageAppsChat;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import es.age.apps.ageAppsChat.Fragments.CallsFragment;
import es.age.apps.ageAppsChat.Fragments.ChatFragment;
import es.age.apps.ageAppsChat.Fragments.ContactsFragment;

/**
 * Created by Adrián García Espinosa on 3/4/16.
 */
public class MainActivity extends AppCompatActivity {




    private ViewPager mPager;
    private MyPagerAdapter mAdapter;
    private TabLayout mTabLayout;
    private Toolbar toolbar;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.main_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);

        collapsingToolbar.setTitle(getResources().getString(R.string.app_name));


        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPager.setAdapter(mAdapter);
        mTabLayout.setTabsFromPagerAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mPager);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
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

    class MyPagerAdapter extends FragmentStatePagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment fragment = null;
            switch (position) {
                case 0: {
                    fragment = new CallsFragment();
                    break;
                }
                case 1: {
                    fragment = new ChatFragment();
                    break;
                }
                case 2: {
                    fragment = new ContactsFragment();
                    break;
                }
                default: {
                    fragment = new CallsFragment();
                    break;
                }
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String title = "";
            switch (position) {
                case 0: {
                    title = "Calls";
                    break;
                }
                case 1: {
                    title = "Chats";
                    break;
                }
                case 2: {
                    title = "Contacts";
                    break;
                }
                default: {
                    title = "Calls";
                    break;
                }
            }
            return title;
        }
    }

}
