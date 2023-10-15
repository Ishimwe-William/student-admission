package rw.ac.auca.model;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class AcademicUnitInitializer {
    public static void initializeAcademicUnits() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Create the root academic unit (Programme)
        AcademicUnit programme = new AcademicUnit();
        programme.setCode("PROG");
        programme.setName("PROGRAMME");
        programme.setUnit(EAcademicUnit.PROGRAMME);
        session.save(programme);

        // Create Programmes
        AcademicUnit undergraduateFaculty = new AcademicUnit();
        undergraduateFaculty.setCode("UG");
        undergraduateFaculty.setName("Undergraduate Degree");
        undergraduateFaculty.setUnit(EAcademicUnit.UNDERGRADUATE);
        undergraduateFaculty.setParent(programme);
        session.save(undergraduateFaculty);

        AcademicUnit mastersDegree = new AcademicUnit();
        mastersDegree.setCode("MAST");
        mastersDegree.setName("Masters Degree");
        mastersDegree.setUnit(EAcademicUnit.MASTERS);
        mastersDegree.setParent(programme);
        session.save(mastersDegree);

        // Create Faculties
        AcademicUnit informationTechnology = new AcademicUnit();
        informationTechnology.setCode("IT");
        informationTechnology.setName("Information Technology Faculty");
        informationTechnology.setUnit(EAcademicUnit.INFORMATION_TECHNOLOGY);
        informationTechnology.setParent(undergraduateFaculty);
        session.save(informationTechnology);

        AcademicUnit businessAdministration = new AcademicUnit();
        businessAdministration.setCode("BA");
        businessAdministration.setName("Business Administration Faculty");
        businessAdministration.setUnit(EAcademicUnit.BUSINESS);
        businessAdministration.setParent(undergraduateFaculty);
        session.save(businessAdministration);

        AcademicUnit informationTechnologyMs = new AcademicUnit();
        informationTechnologyMs.setCode("MIT");
        informationTechnologyMs.setName("Information Technology Faculty");
        informationTechnologyMs.setUnit(EAcademicUnit.INFORMATION_TECHNOLOGY);
        informationTechnologyMs.setParent(mastersDegree);
        session.save(informationTechnologyMs);

        AcademicUnit businessAdministrationMs = new AcademicUnit();
        businessAdministrationMs.setCode("BA");
        businessAdministrationMs.setName("Business Administration Faculty");
        businessAdministrationMs.setUnit(EAcademicUnit.BUSINESS);
        businessAdministrationMs.setParent(mastersDegree);
        session.save(businessAdministrationMs);

        // Create Departments
        AcademicUnit softwareEngineering = new AcademicUnit();
        softwareEngineering.setCode("SE");
        softwareEngineering.setName("Software Engineering");
        softwareEngineering.setUnit(EAcademicUnit.SOFTWARE_ENGINEERING);
        softwareEngineering.setParent(informationTechnology);
        session.save(softwareEngineering);

        AcademicUnit informationManagement = new AcademicUnit();
        informationManagement.setCode("INF");
        informationManagement.setName("Information Management");
        informationManagement.setUnit(EAcademicUnit.INFORMATION_MANAGEMENT);
        informationManagement.setParent(informationTechnology);
        session.save(informationManagement);

        AcademicUnit bigDataAnalytics = new AcademicUnit();
        bigDataAnalytics.setCode("MBD");
        bigDataAnalytics.setName("Master of Science in Big Data Analytics");
        bigDataAnalytics.setUnit(EAcademicUnit.BIG_DATA_ANALYTICS);
        bigDataAnalytics.setParent(informationTechnologyMs);
        session.save(bigDataAnalytics);

        AcademicUnit accounting = new AcademicUnit();
        accounting.setCode("AC");
        accounting.setName("BD in Accounting");
        accounting.setUnit(EAcademicUnit.ACCOUNTING);
        accounting.setParent(businessAdministration);
        session.save(accounting);

        AcademicUnit management = new AcademicUnit();
        management.setCode("MT");
        management.setName("BD in Management");
        management.setUnit(EAcademicUnit.MANAGEMENT);
        management.setParent(businessAdministration);
        session.save(management);

        AcademicUnit accountingMs = new AcademicUnit();
        accountingMs.setCode("MAC");
        accountingMs.setName("MBA in Accounting");
        accountingMs.setUnit(EAcademicUnit.ACCOUNTING);
        accountingMs.setParent(businessAdministrationMs);
        session.save(accountingMs);

        AcademicUnit managementMs = new AcademicUnit();
        managementMs.setCode("MMT");
        managementMs.setName("MBA in Management");
        managementMs.setUnit(EAcademicUnit.MANAGEMENT);
        managementMs.setParent(businessAdministrationMs);
        session.save(managementMs);

        transaction.commit();

        // Close the session and session factory
        session.close();
        sessionFactory.close();
    }
}