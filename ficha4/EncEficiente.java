package com.poo.ficha4;

import com.poo.ficha3.Package;
import com.poo.ficha3.PackageLine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Collectors;

public class EncEficiente {
    String clientName, clientAddress;
    int clientNif, packageID;
    ArrayList<PackageLine> packageLines;

    public EncEficiente(String clientName, String clientAddress, int clientNif, int packageID, ArrayList<PackageLine> packageLines) {
        this.setClientName(clientName);
        this.setClientAddress(clientAddress);
        this.setClientNif(clientNif);
        this.setPackageID(packageID);
        this.setPackageLines(packageLines);
    }

    public EncEficiente(EncEficiente e) {
        this.packageLines = (e.getPackageLines());
        this.packageID = (e.getPackageID());
        this.clientNif = (e.getClientNif());
        this.clientAddress = (e.getClientAddress());
        this.clientName = (e.getClientName());
    }

    @Override
    public EncEficiente clone() {
        return new EncEficiente(this);
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

    public ArrayList<PackageLine> getPackageLines() {
        return new ArrayList<PackageLine>(packageLines);
    }

    public void setPackageLines(ArrayList<PackageLine> packageLines) {
        this.packageLines = new ArrayList<>(packageLines);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EncEficiente that = (EncEficiente) o;
        return clientNif == that.clientNif &&
                packageID == that.packageID &&
                Objects.equals(clientName, that.clientName) &&
                Objects.equals(clientAddress, that.clientAddress) &&
                Objects.equals(packageLines, that.packageLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientName, clientAddress, clientNif, packageID, packageLines);
    }

    @Override
    public String toString() {
        return "EncEficiente{" +
                "clientName='" + clientName + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientNif=" + clientNif +
                ", packageID=" + packageID +
                ", packageLines=" + packageLines +
                '}';
    }

    public double calculaValorTotal() {
        return packageLines.stream().mapToDouble(PackageLine::calculaValorLinhaEnc)
                                    .sum();
    }

    public double calculaValorDesconto() {
        return packageLines.stream().mapToDouble(PackageLine::calculaValorDesconto).sum();
    }

    public int numeroTotalProdutos() {
        return packageLines.stream().mapToInt(PackageLine::getQuantityOrdered).sum();
    }

    public boolean existeProdutoEncomenda(String refProduto) {
        return packageLines.stream().anyMatch(l -> l.getReference().equals(refProduto));
    }

    public void adicionaLinha(PackageLine line) {
        this.packageLines.add(line);
    }

    public void removeLine(PackageLine line) {
        Iterator<PackageLine> i = packageLines.iterator();
        boolean found = false;
        PackageLine l;
        while (i.hasNext() && !found) {
            l = i.next();
            if (found = l.getReference().equals(line.getReference()))
                i.remove();
        }
    }


}
