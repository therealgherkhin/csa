package uebung3.DTO;

public class Beinhaltet {
    private long aID;
    private long bID;

    public long getaID() {
        return aID;
    }

    public void setaID(long aID) {
        this.aID = aID;
    }

    public long getbID() {
        return bID;
    }

    public void setbID(long bID) {
        this.bID = bID;
    }

    public Beinhaltet(long aID, long bID) {
        this.aID = aID;
        this.bID = bID;
    }

}