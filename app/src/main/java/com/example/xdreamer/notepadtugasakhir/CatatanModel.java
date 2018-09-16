package com.example.xdreamer.notepadtugasakhir;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class CatatanModel implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "judul")
    String judul;

    @ColumnInfo(name = "deskripsi")
    String deskripsi;


    public CatatanModel() {
    }

    protected CatatanModel(Parcel in) {
        id = in.readInt();
        judul = in.readString();
        deskripsi = in.readString();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public static final Creator<CatatanModel> CREATOR = new Creator<CatatanModel>() {
        @Override
        public CatatanModel createFromParcel(Parcel source) {
            return new CatatanModel(source);
        }

        @Override
        public CatatanModel[] newArray(int size) {
            return new CatatanModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(judul);
        dest.writeString(deskripsi);
    }
}
