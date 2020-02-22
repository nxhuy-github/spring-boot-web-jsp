package com.beans;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.NONE)
public class Employee
{
    @XmlAttribute
    private Integer id;

    @XmlElement
    private String firstName;

    @XmlElement
    private String lastName;

    @XmlElement
    private String email;

    public Employee(Integer id, String firstName, String lastName, String email) {
        super();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
