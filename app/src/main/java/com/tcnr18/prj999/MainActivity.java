package com.tcnr18.prj999;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {


    static String LOG_TAG = "markchen987";
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;


    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
//        setTitle("XXX");
        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    protected void onResume() {
        super.onResume();
//        setTitle("00000");
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
//                .commit();
        switch (position) {
            case 0:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new MyFragment00())
                        .commit();
                break;
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new MyFragment01())
                        .commit();
                break;
            default:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new MyFragment00())
                        .commit();
                break;


        }


    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
//        setTitle("XXX");
    }

//    public void restoreActionBar() {
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
//        actionBar.setDisplayShowTitleEnabled(true);
//        actionBar.setTitle(mTitle);
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        if (!mNavigationDrawerFragment.isDrawerOpen()) {
//            // Only show items in the action bar relevant to this screen
//            // if the drawer is not showing. Otherwise, let the drawer
//            // decide what to show in the action bar.
//            getMenuInflater().inflate(R.menu.main, menu);
//            restoreActionBar();
//            return true;
//        }
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class MyFragment00 extends Fragment {
        ArrayAdapter<String> mForecastAdapter;

        public MyFragment00() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_00, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.listview);

            String[] dummyArray = {
                    "asdfasdf",
                    "dfghdfhj",
                    "asdfasdf",
                    "dfghdfhj",
                    "asdfasdf",
                    "dfghdfhj",
                    "asdfasdf",
                    "dfghdfhj",
                    "asdfasdf",
                    "dfghdfhj",
                    "asdfasdf",
                    "dfghdfhj",
                    "asdfasdf",
                    "dfghdfhj",
                    "asdfasdf",
                    "dfghdfhj",
                    "某景點"
            };
            List<String> mySelection = new ArrayList<String>(Arrays.asList(dummyArray));
            mForecastAdapter =
                    new ArrayAdapter<String>(
                            getActivity(), // The current context (this activity)
                            R.layout.fragment_00_list_item, // The name of the layout ID.
                            R.id.list_item_forecast_textview, // The ID of the textview to populate.
                            mySelection);

            listView.setAdapter(mForecastAdapter);

            processJson();


            return rootView;
        }

        private void processJson() {


            InputStream is = null;
            String strJson = null;
            JSONArray jsonArray = null;
            JSONObject jsonObject = null;
            ContentValues values = null;
            ContentResolver resolver = getActivity().getContentResolver();


//            Cursor cursor = null;
//
////            Uri uri
//            String[] projection = {StatusProvider.COLUMN_LAST_IMPORT};
//            String selection = null;
//            String[] selectionArgs = null;
//            String sortOrder = null;
//
//
//            cursor = resolver.query(StatusProvider.CONTENT_URL, projection, selection, selectionArgs, sortOrder);


//            if (cursor.moveToFirst()) {
                // not to import again
//                return;
//                do {
//                   // long id = cursor.getLong(0);
//                    String last_import = cursor.getString(0);
//                    Log.d(LOG_TAG,"last_import="+last_import);
//                } while (cursor.moveToNext());
//            }
//            Log.d(LOG_TAG, "...processJson(), NOT YET IMPORT");
//
//
//            values = new ContentValues();
//            Date currentDate = new Date();
//            //toString would print the full date time string
////            System.out.println(currentDate.toString());
//            values.put(StatusProvider.COLUMN_LAST_IMPORT, currentDate.toString());
//            // values.put(AttractionsProvider.COLUMN_TITLE, stitle);
//
//            resolver.insert(StatusProvider.CONTENT_URL, values);


            Log.d(LOG_TAG, "...processJson(), using 3/30 data.json");

            try {
                is = getActivity().getAssets().open("data.json");
                strJson = IOUtils.toString(is, "UTF-8");
                Log.d(LOG_TAG, "...processJson(), strJson=" + strJson.substring(0, 100));


            } catch (IOException exception) {
                Log.d(LOG_TAG, "...processJson(), IOException, " + exception.toString());

            }


            try {
                jsonArray = new JSONArray(strJson);

                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonObject = jsonArray.getJSONObject(i);

                    int rownumber = jsonObject.getInt("rownumber");
                    String stitle = jsonObject.getString("stitle");
                    Log.d(LOG_TAG, "...processJson(), jsonObject " + rownumber + "," + stitle);

                    values = new ContentValues();
                    values.put(AttractionsProvider.COLUMN_ROWNUMBER, rownumber);
                    values.put(AttractionsProvider.COLUMN_TITLE, stitle);

                    resolver.insert(AttractionsProvider.CONTENT_URL, values);


                }

//                ContentValues values = new ContentValues();
//                values.put(Words.WORD, "Beeblebrox");
//                resolver.insert(UserDictionary.Words.CONTENT_URI, values);


            } catch (JSONException exception) {
                Log.d(LOG_TAG, "...processJson(), JSONException, " + exception.toString());

            }
//            values = new ContentValues();
//            Date currentDateEnd = new Date();
//            //toString would print the full date time string
////            System.out.println(currentDate.toString());
//            values.put(StatusProvider.COLUMN_LAST_IMPORT, currentDateEnd.toString());
//            // values.put(AttractionsProvider.COLUMN_TITLE, stitle);
//
//            resolver.insert(StatusProvider.CONTENT_URL, values);


        }


        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
//            ((MainActivity) activity).onSectionAttached(
//                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

    public static class MyFragment01 extends Fragment {


        public MyFragment01() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_01, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
//            ((MainActivity) activity).onSectionAttached(
//                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
//            ((MainActivity) activity).onSectionAttached(
//                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
