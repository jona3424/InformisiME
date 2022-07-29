package com.example.informisime;

import com.example.informisime.Entities.Centri;
import com.example.informisime.Entities.CiljeviObrazovnih;
import com.example.informisime.Entities.InfoSkola;
import com.example.informisime.Entities.KorisniLinkovi;
import com.example.informisime.Entities.LinkoviSkola;
import com.example.informisime.Entities.Meni;
import com.example.informisime.Entities.Menikonkurs;
import com.example.informisime.Entities.Meniobrazovni;
import com.example.informisime.Entities.Oblasti;
import com.example.informisime.Entities.OblastiMod;
import com.example.informisime.Entities.OblastiNemod;
import com.example.informisime.Entities.ObrazovniSkola;
import com.example.informisime.Entities.Ustanove;
import com.example.informisime.Entities.UčeničkiDomovi;
import com.example.informisime.Entities.ŠkoleUstanova;

import java.util.List;

public class SingleTon {
    private List<Meni> meni;
    private List<Ustanove> ustanove;
    private List<UčeničkiDomovi> ucdom;
    private  List<Centri> centri;
    private List<KorisniLinkovi> korlink;
    private  List<Menikonkurs> menikonkurs;
    private List<Meniobrazovni> meniobrazovni;
    private List<Oblasti> oblasti;
    private Integer pamtiodabraniop;
    private Integer pamtiodabranuoblast;
    private List<OblastiMod> oblastiMod;
    private List<OblastiNemod> oblastiNemod;
    private List<ŠkoleUstanova> skoleustanova;
    private  String nazivskole;
    private Integer idskole;
    private List<ObrazovniSkola> obrazovniSkola;
    private  Float koordinate1;
    private  Float koordinate2;
  private  List<CiljeviObrazovnih> ciljz;

    public List<CiljeviObrazovnih> getCiljz() {
        return ciljz;
    }

    public void setCiljz(List<CiljeviObrazovnih> ciljz) {
        this.ciljz = ciljz;
    }

    public Float getKoordinate1() {
        return koordinate1;
    }

    public void setKoordinate1(Float koordinate1) {
        this.koordinate1 = koordinate1;
    }

    public Float getKoordinate2() {
        return koordinate2;
    }

    public void setKoordinate2(Float koordinate2) {
        this.koordinate2 = koordinate2;
    }

    private List<LinkoviSkola> linkoviSkola;
    private List<InfoSkola>  infoSkola;



    public List<ObrazovniSkola> getObrazovniSkola() {
        return obrazovniSkola;
    }

    public void setObrazovniSkola(List<ObrazovniSkola> obrazovniSkola) {
        this.obrazovniSkola = obrazovniSkola;
    }




    public Integer getIdskole() {
        return idskole;
    }

    public void setIdskole(Integer idskole) {
        this.idskole = idskole;
    }

    public List<InfoSkola> getInfoSkola() {
        return infoSkola;
    }

    public void setInfoSkola(List<InfoSkola> infoSkola) {
        this.infoSkola = infoSkola;
    }

    public List<LinkoviSkola> getLinkoviSkola() {
        return linkoviSkola;
    }

    public void setLinkoviSkola(List<LinkoviSkola> linkoviSkola) {
        this.linkoviSkola = linkoviSkola;
    }



    public String getNazivskole() {
        return nazivskole;
    }

    public void setNazivskole(String nazivskole) {
        this.nazivskole = nazivskole;
    }

    public List<ŠkoleUstanova> getSkoleustanova() {
        return skoleustanova;
    }

    public void setSkoleustanova(List<ŠkoleUstanova> skoleustanova) {
        this.skoleustanova = skoleustanova;
    }

    public List<OblastiMod> getOblastiMod() {
        return oblastiMod;
    }

    public void setOblastiMod(List<OblastiMod> oblastiMod) {
        this.oblastiMod = oblastiMod;
    }



    public List<OblastiNemod> getOblastiNemod() {
        return oblastiNemod;
    }

    public void setOblastiNemod(List<OblastiNemod> oblastiNemod) {
        this.oblastiNemod = oblastiNemod;
    }




    public int getPamtiodabraniop() {
        return pamtiodabraniop;
    }

    public void setPamtiodabraniop(Integer pamtiodabraniop) {
        this.pamtiodabraniop = pamtiodabraniop;
    }

    public int getPamtiodabranuoblast() {
        return pamtiodabranuoblast;
    }

    public void setPamtiodabranuoblast(Integer pamtiodabranuoblast) {
        this.pamtiodabranuoblast = pamtiodabranuoblast;
    }

    public List<Oblasti> getOblasti() {
        return oblasti;
    }

    public void setOblasti(List<Oblasti> oblasti) {
        this.oblasti = oblasti;
    }

    public List<Menikonkurs> getMenikonkurs() {
        return menikonkurs;
    }

    public void setMenikonkurs(List<Menikonkurs> menikonkurs) {
        this.menikonkurs = menikonkurs;
    }

    public List<Meniobrazovni> getMeniobrazovni() {
        return meniobrazovni;
    }

    public void setMeniobrazovni(List<Meniobrazovni> meniobrazovni) {
        this.meniobrazovni = meniobrazovni;
    }

    public List<KorisniLinkovi> getKorlink() {
        return korlink;
    }

    public void setKorlink(List<KorisniLinkovi> korlink) {
        this.korlink = korlink;
    }

    public List<Centri> getCentri() {
        return centri;
    }

    public void setCentri(List<Centri> centri) {
        this.centri = centri;
    }

    public List<UčeničkiDomovi> getUcdom() {
        return ucdom;
    }

    public void setUcdom(List<UčeničkiDomovi> ucdom) {
        this.ucdom = ucdom;
    }

    public List<Ustanove> getUstanove() {
        return ustanove;
    }

    public void setUstanove(List<Ustanove> ustanove) {
        this.ustanove = ustanove;
    }

    public List<Meni> getMeni() {
        return meni;
    }

    public void setMeni(List<Meni> meni) {
        this.meni = meni;
    }



    private static final SingleTon ourInstance = new SingleTon();
    public static SingleTon getInstance() {
        return ourInstance;
    }

    private SingleTon(){

    }

}
