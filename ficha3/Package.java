package com.poo.ficha3;

import java.util.Arrays;
import java.util.Objects;

public class Package {
    String clientName, clientAddress;
    int clientNif, packageID;
    PackageLine[] packageLineArray;

    public Package() {
        this.clientAddress = "";
        this.clientName = "";
        this.packageID = 0;
        this.clientNif = 0;
        this.packageLineArray = new PackageLine[]{};
    }

    public Package(Package p) {
        this.clientName = p.getClientName();
        this.clientAddress = p.getClientAddress();
        this.clientNif = p.getClientNif();
        this.packageID = p.getPackageID();
        this.packageLineArray = p.getPackageLineArray();
    }

    public Package(String clientName, String clientAddress, int clientNif, int packageID, PackageLine[] packageLineArray) {
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.clientNif = clientNif;
        this.packageID = packageID;
        this.packageLineArray = packageLineArray;
    }

    @Override
    public Package clone() {
        return new Package(this);
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public int getClientNif() {
        return clientNif;
    }

    public void setClientNif(int clientNif) {
        this.clientNif = clientNif;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public PackageLine[] getPackageLineArray() {
        return packageLineArray;
    }

    public void setPackageLineArray(PackageLine[] packageLineArray) {
        this.packageLineArray = packageLineArray;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return clientNif == aPackage.clientNif &&
                packageID == aPackage.packageID &&
                Objects.equals(clientName, aPackage.clientName) &&
                Objects.equals(clientAddress, aPackage.clientAddress) &&
                Arrays.equals(packageLineArray, aPackage.packageLineArray);
    }

    @Override
    public String toString() {
        return "Package{" +
                "clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientNif=" + clientNif +
                ", packageID=" + packageID +
                ", packageLineArray=" + Arrays.toString(packageLineArray) +
                '}';
    }

    public double calculaValorTotal() {
        double sum = 0;
        for (PackageLine pl : this.packageLineArray) {
            sum += pl.calculaValorLinhaEnc();
        }
        return sum;
    }

    public double calculaValorDesconto() {
        double sum = 0;
        for (PackageLine pl : this.packageLineArray) {
            sum += pl.calculaValorDesconto();
        }
        return sum;
    }

    public int numeroTotalProdutos() {
        int sum = 0;
        for (PackageLine pl : this.packageLineArray) {
            sum += pl.getQuantityOrdered();
        }
        return sum;
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        for (PackageLine pl : this.packageLineArray) {
            if (pl.getReference().equals(refProduto))
                return true;
        }
        return false;
    }

    public void adicionaLinha(PackageLine linha) {
        PackageLine[] nova = new PackageLine[this.packageLineArray.length + 1];
        System.arraycopy(this.packageLineArray, 0 , nova, 0 , this.packageLineArray.length);
        nova[this.packageLineArray.length] = linha;
        this.setPackageLineArray(nova);
    }

    public void removeProduto(String codProd) {
        for (int i = 0; i<this.packageLineArray.length; i++) {
            if (this.packageLineArray[i].getReference().equals(codProd)) {
                System.arraycopy(this.packageLineArray, i+1, this.packageLineArray, i, this.packageLineArray.length-i);
                break;
            }
        }
    }
}
