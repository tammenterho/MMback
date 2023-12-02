package com.mikko.mmback.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="campaigns")
public class Campaigns {
    @Id
    private int id;
    private int owner;

    private String company;
    private String name;
    private String adtitle;
    private String adtext;
    private String adtarget;
    private String adarea;
    private int adbudget;
    private Date adstart;
    private Date adend;
    private String mediainfo;
    private String adurl;
    private String adother;
    private String adstatus;

    private String creator;
    private String adcontact;

    public void setAdcontact(String adcontact) {
        this.adcontact = adcontact;
    }

    public String getAdcontact() {
        return adcontact;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Campaigns() {}

    public String getCompany() {
        return company;
    }

    public String getCreator() {
        return creator;
    }

    public Campaigns(int id, int owner, String name, String adtitle, String creator, String adtext, String adtarget, String adarea, int adbudget, Date adstart, Date adend, String mediainfo, String adurl, String adother, String adstatus) {
        this.id = id;
        this.owner = owner;
        this.name = name;
        this.adtitle = adtitle;
        this.adtext = adtext;
        this.adtarget = adtarget;
        this.adarea = adarea;
        this.adbudget = adbudget;
        this.adstart = adstart;
        this.adend = adend;
        this.mediainfo = mediainfo;
        this.adurl = adurl;
        this.adother = adother;
        this.adstatus = adstatus;
        this.creator = creator;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdtitle(String adtitle) {
        this.adtitle = adtitle;
    }

    public void setAdtext(String adtext) {
        this.adtext = adtext;
    }

    public void setAdtarget(String adtarget) {
        this.adtarget = adtarget;
    }

    public String getAdtarget () {
        return adtarget;
    }

    public void setAdarea(String adarea) {
        this.adarea = adarea;
    }

    public void setAdbudget(int adbudget) {
        this.adbudget = adbudget;
    }

    public void setAdstart(Date adstart) {
        this.adstart = adstart;
    }

    public void setAdend(Date adend) {
        this.adend = adend;
    }

    public void setMediainfo(String mediainfo) {
        this.mediainfo = mediainfo;
    }

    public void setAdurl(String adurl) {
        this.adurl = adurl;
    }

    public void setAdother(String adother) {
        this.adother = adother;
    }

    public void setAdstatus(String adstatus) {
        this.adstatus = adstatus;
    }

    public int getId() {
        return id;
    }

    public int getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public String getAdtitle() {
        return adtitle;
    }

    public String getAdtext() {
        return adtext;
    }

    public String getAdarea() {
        return adarea;
    }

    public int getAdbudget() {
        return adbudget;
    }

    public Date getAdstart() {
        return adstart;
    }

    public Date getAdend() {
        return adend;
    }

    public String getMediainfo() {
        return mediainfo;
    }

    public String getAdurl() {
        return adurl;
    }

    public String getAdother() {
        return adother;
    }

    public String getAdstatus() {
        return adstatus;
    }
}
