package pl.spring.demo.to;

public class AuthorTo extends PersonTo {
    private int publicationsNumber;

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public void setPublicationsNumber(int publicationsNumber) {
        this.publicationsNumber = publicationsNumber;
    }
}
