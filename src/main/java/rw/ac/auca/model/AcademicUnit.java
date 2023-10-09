package rw.ac.auca.model;

import jakarta.persistence.*;

import java.util.UUID;

public class AcademicUnit {
    @Id
    private UUID id;
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    @Column(name="UNIT")
    private EAcademicUnit unit;
    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    private AcademicUnit parent;

    public AcademicUnit() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
}
