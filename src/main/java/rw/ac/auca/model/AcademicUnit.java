package rw.ac.auca.model;

import jakarta.persistence.*;
import rw.ac.auca.model.EAcademicUnit;

import java.util.UUID;
import java.util.List;

@Entity
public class AcademicUnit {
    @Id
    private UUID id;
    @Column(unique = true)
    private String code;
    private String name;

    @Enumerated(EnumType.STRING)
    private EAcademicUnit unit;

    @ManyToOne
    @JoinColumn
    private AcademicUnit parent;

    @OneToMany(mappedBy = "parent")
    private List<AcademicUnit> children;

    public AcademicUnit() {
        this.id=UUID.randomUUID();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EAcademicUnit getUnit() {
        return unit;
    }

    public void setUnit(EAcademicUnit unit) {
        this.unit = unit;
    }

    public AcademicUnit getParent() {
        return parent;
    }

    public void setParent(AcademicUnit parent) {
        this.parent = parent;
    }

    public List<AcademicUnit> getChildren() {
        return children;
    }

    public void setChildren(List<AcademicUnit> children) {
        this.children = children;
    }
}
