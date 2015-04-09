package pl.spring.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "AUTHOR")
@PrimaryKeyJoinColumn(name = "author_id", referencedColumnName = "id")
public class AuthorEntity extends PersonEntity implements Serializable {
    @Column(name = "publications")
    private int publicationsNumber;

    public int getPublicationsNumber() {
        return publicationsNumber;
    }

    public void setPublicationsNumber(int publicationsNumber) {
        this.publicationsNumber = publicationsNumber;
    }
}
