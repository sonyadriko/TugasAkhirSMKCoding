package com.example.xdreamer.notepadtugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.xdreamer.notepadtugasakhir.MyApp.db;

public class ActionCatatanActivity extends AppCompatActivity {
    @BindView(R.id.edit_value_judul)
    EditText edtjudul;
    @BindView(R.id.edit_value_deskripsi)
    EditText edtDeskripsi;
    @BindView(R.id.btnUpdate)
    Button btnEdit;
    @BindView(R.id.btnDelete)
    Button btnDelete;

    private CatatanModel catatanModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_catatan);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        catatanModel = bundle.getParcelable(MainAdapter.EXTRA_CATATAN);

        edtjudul.setText(catatanModel.getJudul());
        edtDeskripsi.setText(catatanModel.getDeskripsi());

    }


    @OnClick(R.id.btnUpdate)
    public void onBtnEditClicked(){
        catatanModel.setJudul(edtjudul.getText().toString());
        catatanModel.setDeskripsi(edtDeskripsi.getText().toString());

        MyApp.db.catatanModelDao().update(catatanModel);
        Intent i = new Intent(ActionCatatanActivity.this, MainActivity.class);
        i.setFlags(i.FLAG_ACTIVITY_NEW_TASK);
        i.setFlags(i.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
        finish();
    }

    @OnClick(R.id.btnDelete)
    public void onBtnDeleteClicked(){
        MyApp.db.catatanModelDao().deleteUsers(catatanModel);
        Intent del = new Intent(this,MainActivity.class);
        del.addFlags(del.FLAG_ACTIVITY_NEW_TASK);
        del.addFlags(del.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(del);
        finish();
    }

}
