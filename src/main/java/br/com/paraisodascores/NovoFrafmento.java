package br.com.paraisodascores;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class NovoFrafmento extends Fragment {


    public NovoFrafmento() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_novo_frafmento, container, false);

        FragmentActivity act = getActivity();
        startActivity(new Intent (act, UnityPlayerActivity.class));

        return view;
    }

}
