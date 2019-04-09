package com.mecodroid.volley_example;

class Models {
    String Pname;
    String Pemail;
    String Pphone;
    String Paddress;
    String Pcompany;

    public Models(String pname, String pemail, String pphone, String paddress, String pcompany) {
        Pname = pname;
        Pemail = pemail;
        Pphone = pphone;
        Paddress = paddress;
        Pcompany = pcompany;
    }

    public String getPname() {
        return Pname;
    }

    public void setPname(String pname) {
        Pname = pname;
    }

    public String getPemail() {
        return Pemail;
    }

    public void setPemail(String pemail) {
        Pemail = pemail;
    }

    public String getPphone() {
        return Pphone;
    }

    public void setPphone(String pphone) {
        Pphone = pphone;
    }

    public String getPaddress() {
        return Paddress;
    }

    public void setPaddress(String paddress) {
        Paddress = paddress;
    }

    public String getPcompany() {
        return Pcompany;
    }

    public void setPcompany(String pcompany) {
        Pcompany = pcompany;
    }
}
