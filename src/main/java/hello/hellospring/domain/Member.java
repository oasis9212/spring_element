package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {
    // IDENTITY  DB 알아서 생성해주게 만드는 것 시퀀스 생성이라고 생각해라
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

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
}
