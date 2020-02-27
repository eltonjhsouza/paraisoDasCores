package br.com.paraisodascores;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MenuPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private  WebView wv;
    ProgressBar superProgressBar;
    String appUrl = "https://play.google.com/store/apps/details?id=br.com.paraisodascores.app.arparaisodascores";
    //ImageView superImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        //Progress Bar

        superProgressBar = findViewById(R.id.myProgressBar);
       // superImageView = findViewById(R.id.myImageView);

        superProgressBar.setMax(100);

        //Progress Bar


        //início do web view

        wv = (WebView) findViewById(R.id.store);
        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);
        wv.loadUrl("http://paraisodascores.com.br/");
        //wv.loadUrl("");
        wv.setWebViewClient(new WebViewClient());
        wv.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                superProgressBar.setProgress(newProgress);
            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                getSupportActionBar().setTitle(title);
            }
        });

           //fim do web view


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (item.getItemId()){

            case R.id.ajustes:
                boolean x = true;
                if(x=false){

                }else{
                    Toast.makeText(this, "Em breve", Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.menu_share2:

                share();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void share() {

        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "Baixe o App de Realidade Aumentada Paraíso das Cores:"+appUrl;
        String shareSub = "Compartilhe com seus amigos";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Escolha onde compartilhar"));

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Intent camAr = new Intent(this, UnityPlayerActivity.class);
            startActivity(camAr);
//Intent frag = new Intent(this, CamAR1.class);
  //          startActivity((frag));


        } else if (id == R.id.instagram) {
            {
                wv.loadUrl("https://www.instagram.com/paraisodascores/");
            }
        }else if (id == R.id.facebook){
            {
                wv.loadUrl("https://www.facebook.com/paraiso.cores");
            }

        } else if (id == R.id.store) {
            {
                wv.loadUrl("http://paraisodascores.com.br/");
            }
        } else if (id == R.id.ajustes) {


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onBackPressed() {
        //  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(wv.canGoBack()){
            wv.goBack();
        }
        else
        {
            finish();
        }

    }


}
