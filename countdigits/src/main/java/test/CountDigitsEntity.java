package test;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name="digit_count")
public class CountDigitsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "string")
    private String string;

    @Column(name = "digit_count")
    private int count;

    public CountDigitsEntity(String string){
        this.string = string;
        this.count = countDigits(string);
    }

    private CountDigitsEntity(){}

    private int countDigits(String string){
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(string);
        int i = 0;
        while (matcher.find())
            i++;

        return i;
    }

    public int getCount() {
        return count;
    }

    @JsonIgnore
    public String getString() {
        return string;
    }
}
