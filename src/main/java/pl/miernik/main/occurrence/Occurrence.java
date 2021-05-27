package pl.miernik.main.occurrence;

import javax.persistence.*;

@Entity
@Table(name = "occurrences")
public class Occurrence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String keyword;

    private String sentence;

    private int totalLength;

    public Occurrence(){};

    public Occurrence(int id, String keyword, String sentence, int totalLength) {
        this.id = id;
        this.keyword = keyword;
        this.sentence = sentence;
        this.totalLength = totalLength;
    }

    public int getTotalLength() {
        return totalLength;
    }

    public Occurrence setTotalLength(int totalLength) {
        this.totalLength = totalLength;
        return this;
    }

    public int getId() {
        return id;
    }

    public Occurrence setId(int id) {
        this.id = id;
        return this;
    }

    public String getKeyword() {
        return keyword;
    }

    public Occurrence setKeyword(String keyword) {
        this.keyword = keyword;
        return this;
    }

    public String getSentence() {
        return sentence;
    }

    public Occurrence setSentence(String sentence) {
        this.sentence = sentence;
        return this;
    }

    @Override
    public String toString() {
        return "Occurrence{" +
                "id=" + id +
                ", keyword='" + keyword + '\'' +
                ", sentence='" + sentence + '\'' +
                ", totalLength=" + totalLength +
                '}';
    }

}
