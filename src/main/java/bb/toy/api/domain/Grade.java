package bb.toy.api.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Grade {
    @Id
    @Column(name = "grade_id")
    private String id; // B,S,G,A
    @Column(name = "grade_name")
    private String name;
    private int discount;

    public static Grade addGrade(String id) {
        Grade grade = new Grade();
        String name = "";
        int discount = 0;

        grade.setId(id);

        if (id.equals("B")) {
            name = "브론즈";
            discount = 10;
        } else if (id.equals("S")) {
            name = "실버";
            discount = 20;
        } else if (id.equals("G")){
            name = "골드";
            discount = 30;
        } else {
            name = "관리자";
            discount = 100;
        }

        grade.setName(name);
        grade.setDiscount(discount);

        return grade;
    }
}
