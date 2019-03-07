package dad.icmit.jpatest.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Merchandise {

    @Id
    private Long id;

    private String name;

    private String article;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }
}
