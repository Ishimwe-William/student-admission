package rw.ac.auca.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import rw.ac.auca.model.AcademicUnit;
import rw.ac.auca.model.AcademicUnitInitializer;
import rw.ac.auca.model.EAcademicUnit;

import java.io.IOException;

@WebServlet("/admin/academicUnit")
public class AcademicUnitServlet extends HttpServlet {

    public void init() throws ServletException {
        super.init();
        AcademicUnitInitializer.initializeAcademicUnits();
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
    private AcademicUnit academicRequest(HttpServletRequest request) {
        AcademicUnit academicUnit = new AcademicUnit();

        // Get the values from the request parameters
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String unitType = request.getParameter("unitType"); // Assuming a parameter for the unit type, e.g., "PROGRAMME"

        // Set the values in the AcademicUnit object
        academicUnit.setCode(code);
        academicUnit.setName(name);

        // Parse the unit type from a String to the corresponding EAcademicUnit enum
        if (unitType != null) {
            try {
                EAcademicUnit academicUnitType = EAcademicUnit.valueOf(unitType);
                academicUnit.setUnit(academicUnitType);
            } catch (IllegalArgumentException e) {
                // Handle invalid unit type value here
                // You can log an error or take appropriate action
            }
        }

        // You may also want to set the parent and children relationships if applicable

        return academicUnit;
    }

}
