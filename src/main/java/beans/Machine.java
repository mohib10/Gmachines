package beans;

import java.util.Date;

public class Machine {

    private int id;
    private String reference;
    private Date dateAchat;
    private double prix;
    private int marqueId;

    public Machine(int id, String reference, Date dateAchat, double prix, int marqueId) {
        super();
        this.id = id;
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.marqueId = marqueId;
        this.prix = prix;
    }

    public Machine(String reference, Date dateAchat, double prix,int marqueId) {
        super();
        this.reference = reference;
        this.dateAchat = dateAchat;
        this.marqueId = marqueId;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Date getDateAchat() {
        return this.dateAchat;
    }

    public void setDateAchat(Date dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getPrix() {
        return prix;
    }
    
    public void setPrix(double prix) {
        this.prix = prix;
    }
    
    public int getMarqueId() {
    	return this.marqueId;
    }
    
    public void setMarqueId(int marqueId) {
    	this.marqueId = marqueId;
    }

    @Override
    public String toString() {
        return this.id + " " + this.reference;
    }

}
