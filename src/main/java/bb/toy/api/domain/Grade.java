package bb.toy.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Grade {
    @Id
    @Column(name = "grade_id")
    private String id; // B,S,G
    @Column(name = "grade_name")
    private String name;
    private int discount;

    protected Grade() {
    }

    public Grade(String id) {

        this.id = id;

        if (id.equals("B")) {
            this.name = "브론즈";
            this.discount = 10;
        } else if (id.equals("S")) {
            this.name = "실버";
            this.discount = 20;
        } else if (id.equals("G")){
            this.name = "골드";
            this.discount = 30;
        } else {
            this.name = "관리자";
            this.discount = 100;
        }
    }
}
