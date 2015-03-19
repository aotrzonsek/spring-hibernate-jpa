package pl.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "AUTHOR")
@PrimaryKeyJoinColumn(name = "author_id", referencedColumnName = "id")
public class AuthorEntity extends PersonEntity {
    @Column(name = "publications")
    private int publicationsNumber;

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public void setPublicationsNumber(int publicationsNumber) {
        this.publicationsNumber = publicationsNumber;
    }
}
