package com.example.xdreamer.notepadtugasakhir;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddCatatanActivity extends AppCompatActivity {

    @BindView(R.id.edit_judul)
    EditText inputJudul;
    @BindView(R.id.edit_deskripsi)
    EditText inputDeskripsi;
    @BindView(R.id.button_add)
    Button btnAdd;

    private CatatanModel catatanModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_catatan);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_add)
    public void onBtnAddClicked() {
        if (!inputJudul.getText().toString().isEmpty()
                && !inputDeskripsi.getText().toString().isEmpty()) {
            catatanModel = new CatatanModel();

            catatanModel.setJudul(inputJudul.getText().toString());
            catatanModel.setDeskripsi(inputDeskripsi.getText().toString());

            MyApp.db.catatanModelDao().insertAll(catatanModel);
            Intent i = new Intent(AddCatatanActivity.this, MainActivity.class);
            i.addFlags(i.FLAG_ACTIVITY_NEW_TASK);
            i.addFlags(i.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
        }
    }
}
