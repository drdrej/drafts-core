package com.touchableheroes.drafts.core.tools;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.touchableheroes.drafts.blackbox.R;
import com.touchableheroes.drafts.navidrawer.SimpleNavigationDrawerListItemClickListener;
import com.touchableheroes.rxspace.IHasScope;
import com.touchableheroes.rxspace.Scope;

/**
 * Created by asiebert on 05.03.16.
 */
public class AppTool {

    public static final AppWrapper withActivity( final Activity activity ) {
        return new AppWrapper(activity);
    }


    public static class AppWrapper  {

        private final Activity src;

        private Scope appScope;

        private AppWrapper(Activity src) {
            this.src = src;
        }

        public <R extends Application> R getApp(final Class<R> type) {
            return (R) src.getApplication();
        }

        public Scope getAppScope() {
            Application app = src.getApplication();

            if( app instanceof IHasScope ) {
                return ((IHasScope) app).getScope();
            }

            throw new IllegalStateException( "Couldn't get scope. app-class should implement IHasScope.class interface" );
        }

        public LocationManager getLocationManager(final LocationListener callback ) {
            final LocationManager lm = (LocationManager) this.src.getSystemService(Context.LOCATION_SERVICE);

            lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 30, 10, callback);
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 30, 10, callback);

            return lm;
        }

        public LocationManager requestLocation(final LocationListener callback ) {
            final LocationManager lm = (LocationManager) this.src.getSystemService(Context.LOCATION_SERVICE);

            final Looper myLooper = Looper.myLooper();

            lm.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, callback, myLooper);
            lm.requestSingleUpdate(LocationManager.GPS_PROVIDER, callback, myLooper);

            return lm;
        }

        public <T extends Activity> T as(final Class<T> type) {
            if( type.isAssignableFrom(this.src.getClass()) ) {
                return (T) this.src;
            } else {
                throw new UnsupportedOperationException( " activity: " + this.src + " / passed type = " + type );
            }
        }

        public DrawerLayoutWrapper bindDrawerLayout() {
            final DrawerLayoutWrapper rval = useDrawerLayout();

            final String[] titles = this.src.getResources().getStringArray(R.array.navi_drawer_main);
            final ListView drawerList = (ListView) this.src.findViewById(R.id.left_drawer);

            drawerList.setAdapter(new ArrayAdapter<String>(this.src,
                    R.layout.list_item_navi_drawer, titles));

            drawerList.setOnItemClickListener(
                    new SimpleNavigationDrawerListItemClickListener(
                         as(FragmentActivity.class).getSupportFragmentManager()){

                        @Override
                        protected void doAfterSelectItem(final int position) {
                            super.doAfterSelectItem(position);
                            drawerList.setItemChecked(position, true);
                            rval.src.closeDrawer(drawerList);


                            /*
                            setTitle(mPlanetTitles[position]);
                            mDrawerLayout.closeDrawer(mDrawerList);
*/
                        }
                    });

            return rval;

            // mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        }




        public DrawerLayoutWrapper useDrawerLayout() {
            final DrawerLayout drawerLayout = (DrawerLayout) this.src.findViewById(R.id.navi_drawer_layout);

            if( this.src instanceof AppCompatActivity ) {
                return new DrawerLayoutWrapper((AppCompatActivity) this.src, drawerLayout);
            } else {
                throw new IllegalStateException( "Do not support this type of activity: " + this.src.getClass() );
            }
        }

    }


    public static class DrawerLayoutWrapper {

        private final DrawerLayout src;

        private final AppCompatActivity owner;

        private ActionBarDrawerToggle toggle;

        public DrawerLayoutWrapper(final AppCompatActivity owner, final DrawerLayout drawerLayout) {
            this.owner = owner;
            this.src = drawerLayout;
        }

        public DrawerLayoutWrapper appendToggle(final @StringRes int title,
                                                final @StringRes int iconDrawerOpen,
                                                final @StringRes int iconDrawerClose) {

            this.toggle = new ActionBarDrawerToggle (
                    this.owner,
                    this.src,
                    iconDrawerOpen,
                    iconDrawerClose
            ) {

                public void onDrawerClosed(View view) {
                    super.onDrawerClosed(view);
                    getActionBar().setTitle(title);
                }

                public void onDrawerOpened(final View drawerView) {
                    super.onDrawerOpened(drawerView);
                    getActionBar().setTitle( title );
                }

            };

            this.src.setDrawerListener(toggle);

            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setHomeButtonEnabled(true);

            return this;
        }


        public ActionBarDrawerToggle getToggle() {
            return toggle;
        }

        public ActionBar getActionBar() {
            return owner.getSupportActionBar();
        }
    }

}
