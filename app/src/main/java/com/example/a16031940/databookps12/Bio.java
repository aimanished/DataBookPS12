package com.example.a16031940.databookps12;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Bio extends Fragment {

TextView tv;
    public Bio() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bio, container, false);
        Button et;
        et = view.findViewById(R.id.btnEdit);
        FloatingActionButton fab = view.findViewById(R.id.fab);
        tv = view.findViewById(R.id.tv);
        final String AllContents = tv.getText().toString();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout passPhrase =
                        (LinearLayout) inflater.inflate(R.layout.add, null);
                final EditText etPassphrase = (EditText) passPhrase
                        .findViewById(R.id.etBio);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Please Enter")
                        .setView(passPhrase)
                        .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getActivity(), "You had entered " +
                                        etPassphrase.getText().toString(), Toast.LENGTH_LONG).show();

                                tv.setText(AllContents + etPassphrase.getText().toString());

                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }
        });

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        return view;
    }

}
