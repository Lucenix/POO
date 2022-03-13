package com.poo.ficha3;

import java.util.Arrays;
import java.util.Objects;

public class Telemovel {
    private String marca, modelo;
    private String[] nomeAppInstall;
    private String[] msgGuardadas;
    private int displayX, displayY,
        dimArmText, dimArmFoto, dimArmApp, dimArmFotoApp,
        usedTotal, numFotos, numApp;

    public Telemovel(Telemovel t) {
        this.marca = t.getMarca();
        this.modelo = t.getModelo();
        this.nomeAppInstall = t.getNomeAppInstall();
        this.msgGuardadas = t.getMsgGuardadas();
        this.displayX = t.getDisplayX();
        this.displayY = t.getDisplayY();
        this.dimArmText = t.getDimArmText();
        this.dimArmFoto = t.getDimArmFoto();
        this.dimArmApp = t.getDimArmApp();
        this.dimArmFotoApp = t.getDimArmFotoApp();
        this.usedTotal = t.getUsedTotal();
        this.numFotos = t.getNumFotos();
        this.numApp = t.getNumApp();
    }


    @Override
    public Telemovel clone() {
        return new Telemovel(this);
    }

    public Telemovel(String marca, String modelo, String[] nomeAppInstall, String[] msgGuardadas, int displayX, int displayY, int dimArmText, int dimArmFoto, int dimArmApp, int dimArmFotoApp, int usedTotal, int numFotos, int numApp) {
        this.marca = marca;
        this.modelo = modelo;
        this.nomeAppInstall = nomeAppInstall;
        this.msgGuardadas = msgGuardadas;
        this.displayX = displayX;
        this.displayY = displayY;
        this.dimArmText = dimArmText;
        this.dimArmFoto = dimArmFoto;
        this.dimArmApp = dimArmApp;
        this.dimArmFotoApp = dimArmFotoApp;
        this.usedTotal = usedTotal;
        this.numFotos = numFotos;
        this.numApp = numApp;
    }

    public Telemovel() {
        this.marca = "lmao";
        this.modelo = "nao";
        this.nomeAppInstall = new String[]{"tenho", "tempo", "para", "esta", "porra"};
        this.msgGuardadas = new String[]{};
        this.displayX = 0;
        this.displayY = 0;
        this.dimArmText = 0;
        this.dimArmFoto = 0;
        this.dimArmApp = 0;
        this.dimArmFotoApp = 0;
        this.usedTotal = 0;
        this.numFotos = 0;
        this.numApp = 0;
    }

    public String[] getMsgGuardadas() {
        return msgGuardadas;
    }

    public void setMsgGuardadas(String[] msgGuardadas) {
        this.msgGuardadas = msgGuardadas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String[] getNomeAppInstall() {
        return nomeAppInstall;
    }

    public void setNomeAppInstall(String[] nomeAppInstall) {
        this.nomeAppInstall = nomeAppInstall;
    }

    public int getDisplayX() {
        return displayX;
    }

    public void setDisplayX(int displayX) {
        this.displayX = displayX;
    }

    public int getDisplayY() {
        return displayY;
    }

    public void setDisplayY(int displayY) {
        this.displayY = displayY;
    }

    public int getDimArmText() {
        return dimArmText;
    }

    public void setDimArmText(int dimArmText) {
        this.dimArmText = dimArmText;
    }

    public int getDimArmFoto() {
        return dimArmFoto;
    }

    public void setDimArmFoto(int dimArmFoto) {
        this.dimArmFoto = dimArmFoto;
    }

    public int getDimArmApp() {
        return dimArmApp;
    }

    public void setDimArmApp(int dimArmApp) {
        this.dimArmApp = dimArmApp;
    }

    public int getDimArmFotoApp() {
        return dimArmFotoApp;
    }

    public void setDimArmFotoApp(int dimArmFotoApp) {
        this.dimArmFotoApp = dimArmFotoApp;
    }

    public int getUsedTotal() {
        return usedTotal;
    }

    public void setUsedTotal(int usedTotal) {
        this.usedTotal = usedTotal;
    }

    public int getNumFotos() {
        return numFotos;
    }

    public void setNumFotos(int numFotos) {
        this.numFotos = numFotos;
    }

    public int getNumApp() {
        return numApp;
    }

    public void setNumApp(int numApp) {
        this.numApp = numApp;
    }

    @Override
    public String toString() {
        return "Telemovel{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", nomeAppInstall=" + Arrays.toString(nomeAppInstall) +
                ", displayX=" + displayX +
                ", displayY=" + displayY +
                ", dimArmText=" + dimArmText +
                ", dimArmFoto=" + dimArmFoto +
                ", dimArmApp=" + dimArmApp +
                ", dimArmFotoApp=" + dimArmFotoApp +
                ", usedTotal=" + usedTotal +
                ", numFotos=" + numFotos +
                ", numApp=" + numApp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Telemovel telemovel = (Telemovel) o;
        return displayX == telemovel.displayX &&
                displayY == telemovel.displayY &&
                dimArmText == telemovel.dimArmText &&
                dimArmFoto == telemovel.dimArmFoto &&
                dimArmApp == telemovel.dimArmApp &&
                dimArmFotoApp == telemovel.dimArmFotoApp &&
                usedTotal == telemovel.usedTotal &&
                numFotos == telemovel.numFotos &&
                numApp == telemovel.numApp &&
                marca.equals(telemovel.marca) &&
                modelo.equals(telemovel.modelo) &&
                Arrays.equals(nomeAppInstall, telemovel.nomeAppInstall);
    }

    public boolean existeEspaco(int numeroBytes) {
        return this.getUsedTotal() + numeroBytes < getDimArmFotoApp() + getDimArmText();
    }

    public void instalaApp(String nome, int tamanho) {
        if (existeEspaco(tamanho)) {
            String[] array = this.getNomeAppInstall();
            String[] novo = new String[array.length + 1];
            System.arraycopy(array, 0, novo, 0, array.length);
            novo[novo.length-1] = nome;
            this.setNomeAppInstall(novo);
            this.setUsedTotal(this.getUsedTotal() + tamanho);
        }
    }

    public void recebeMsg(String msg) {
        if (existeEspaco(msg.length())) {
            String[] array = this.getMsgGuardadas();
            String[] novo = new String[array.length + 1];
            System.arraycopy(array, 0, novo, 0, array.length);
            novo[novo.length-1] = msg;
            this.setNomeAppInstall(novo);
            this.setUsedTotal(this.getUsedTotal() + msg.length());
        }
    }

}
