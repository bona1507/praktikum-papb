package com.example.catatkelompok;

import android.os.Parcel;
import android.os.Parcelable;

public class Mahasiswa implements Parcelable {
    private String nama;
    private String prodi;
    private int angkatan;

    public Mahasiswa(String nama, String prodi, int angkatan) {
        this.nama = nama;
        this.prodi = prodi;
        this.angkatan = angkatan;
    }

    protected Mahasiswa(Parcel in) {
        nama = in.readString();
        prodi = in.readString();
        angkatan = in.readInt();
    }

    public static final Creator<Mahasiswa> CREATOR = new Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel in) {
            return new Mahasiswa(in);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };

    public String getNama() {
        return nama;
    }

    public String getProdi() {
        return prodi;
    }

    public int getAngkatan() {
        return angkatan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(prodi);
        dest.writeInt(angkatan);
    }
}
