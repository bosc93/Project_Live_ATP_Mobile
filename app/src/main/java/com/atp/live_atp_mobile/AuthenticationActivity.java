package com.atp.live_atp_mobile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by cesar on 27/02/2018.
 */

public class AuthenticationActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tvTournament;
    private TextView tvDate;
    private EditText editLogin;
    private EditText editPassword;
    private View vue;
    private ImageButton submit;
    private DatabaseReference mDatabase;

    public static final String RECUPBDD = "RecupBdd";
    public static final String Tournament = "Open Australia";
    public static SharedPreferences sharedpreferencesAuthentication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        //Instance BDD
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Initialisation des éléments
        this.tvTournament = (TextView) findViewById(R.id.textViewTournament);
        this.tvDate = (TextView) findViewById(R.id.textViewDate);
        this.editLogin = (EditText) findViewById(R.id.editTextLogin);
        this.editPassword = (EditText) findViewById(R.id.editTextPassword);
        this.vue = findViewById(android.R.id.content);
        this.submit = (ImageButton) findViewById(R.id.imageButtonSubmit);

        //Activation de l'intéraction
        vue.setOnClickListener(this);
        submit.setOnClickListener(this);

        sharedpreferencesAuthentication = getSharedPreferences(RECUPBDD, Context.MODE_PRIVATE);

        //Méthodes
        displayTournament();
        displayDate();
    }

    @Override
    public void onClick(View v) {
        if (v == vue){
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(vue.getWindowToken(), 0);
        }
        if (v == submit){
            verifIdent();
        }
    }

    public void verifIdent(){
        String login = editLogin.getText().toString();
        String password = editPassword.getText().toString();
        //Comparaison à la bdd de l'autentification renseigné
        //boolean loginRenseigné = résultat de la requete à la bdd
        //Comparaison à la bdd du password renseigné
        //boolean passwordRenseigné = résultat de la requete à la bdd
        if (login.equals("admin")){ //Remplacer par loginRenseigné == true
            if (password.equals("admin")){ //Remplacer par loginRenseigné == true
                Intent intent = new Intent(AuthenticationActivity.this, ServiceActivity.class);
                startActivity(intent);
            }else {
                editPassword.setText("");
            }
        }else {
            editLogin.setText("");
        }
    }

    public void displayTournament(){
        //Appel get du tournoi en fonction du jour et de l'horaire de la rencontre
        //String resultTournoiBdd = mDatabase.child("tournoi/0/nom").getKey();
        //GetString du résultat de la bdd
        SharedPreferences.Editor editor = sharedpreferencesAuthentication.edit();
        String resultTournoiBdd = "Roland Garros";
        editor.putString(Tournament, resultTournoiBdd); //Insertion du resultat de la requete dans la sauvegarde
        editor.commit();
        tvTournament.setText(resultTournoiBdd);
    }

    public void displayDate(){
        //Appel get de la date en fonction du tournoi
        //GetString du résultat de la bdd
        //Exemple
        String resultBdd = "22 - 30 janvier 2018";
        tvDate.setText(resultBdd);
    }
}
