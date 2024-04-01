package Model.Artists;

public class Celebrities {
    String F_name;
    String L_name;
    String Email;
    int NetWorth;

    public Celebrities() {
        System.out.println("Creating a celebrity... ");
    }

    public Celebrities(String fname, String lname, String email, int networth) {
        setF_name(fname);
        setL_name(lname);
        setEmail(email);
        setNetWorth(networth);
    }

    public void setF_name(String f_name) {
        this.F_name = f_name;
    }

    public void setL_name(String l_name) {
        this.L_name = l_name;
    }

    public void setEmail(String email) {
        try {
            if (email.contains("@")) {
                this.Email = email;
            } else {
                throw new EmailException("Email ID must contain '@'");
            }
        } catch (EmailException e) {
            System.out.println("Caught custom exception " + e.getMessage());
        }
    }


    public void setNetWorth(int netWorth) {
        this.NetWorth = netWorth;
    }

    public String getF_name() {
        return this.F_name;
    }

    public String getL_name() {
        return this.L_name;
    }

    public String getEmail() {
        return this.Email;
    }

    public int getNetWorth() {
        return this.NetWorth;
    }

    public void display() {
        System.out.println("Artist's First Name: " + getF_name());
        System.out.println("Artist's Last Name: " + getL_name());
        System.out.println("Artist's Email: " + getEmail());
        System.out.println("Artist's Net Worth: " + getNetWorth());
    }
}
