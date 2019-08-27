package com.example.katalogmovie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int photo;
    private String nama, genre, durasi, produser, sutradara, penulis, produksi, sinopsis;

    protected Movie(Parcel in) {
        photo = in.readInt();
        nama = in.readString();
        genre = in.readString();
        durasi = in.readString();
        produser = in.readString();
        sutradara = in.readString();
        penulis = in.readString();
        produksi = in.readString();
        sinopsis = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie() {

    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getProduser() {
        return produser;
    }

    public void setProduser(String produser) {
        this.produser = produser;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getProduksi() {
        return produksi;
    }

    public void setProduksi(String produksi) {
        this.produksi = produksi;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(nama);
        dest.writeString(genre);
        dest.writeString(durasi);
        dest.writeString(produser);
        dest.writeString(sutradara);
        dest.writeString(penulis);
        dest.writeString(produksi);
        dest.writeString(sinopsis);
    }
}
