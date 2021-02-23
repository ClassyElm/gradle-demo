package com.pjcraig.entity;

import java.time.*;
import java.time.format.DateTimeParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user.
 *
 * @author pwaite
 * @author pjcraig
 */
@Entity(name="User")
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="user_name")
    private String userName;

    @Column(name="date_of_birth")
    private LocalDate dateOfBirth;

    @Transient
    private final Logger logger = LogManager.getLogger();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     * @param id the integer id
     * @param firstName the first name
     * @param lastName the last name
     * @param userName the user name
     * @param date the String representation of the user's date of birth
     */
    public User(int id, String firstName, String lastName, String userName, String date) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        parseBirthday(date);
    }

    /**
     * Attempts to load the provided String date as a LocalDate birthday of the user.
     * @param birthDate The String birth date of the user
     */
    private void parseBirthday(String birthDate) {
        try {
            dateOfBirth = LocalDate.parse(birthDate);
        } catch (DateTimeParseException exception) {
            logger.error("Date parsing exception occurred while parsing birthday parameter.", exception);
        } catch (Exception exception) {
            logger.error("Unknown exception while parsing birthday parameter.", exception);
        }
    }

    /**
     * Calculates the age of the given user in years.
     * @return The integer age of the user.
     */
    public int getAge() {
        LocalDate today = LocalDate.now();
        Period timePeriod = Period.between(dateOfBirth, today);
        return timePeriod.getYears();
    }

    /**
     * Gets the user id.
     * @return the integer id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user id.
     * @param id the integer id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the user's first name.
     * @return the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     * @param firstName the user's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the user's last name.
     * @return the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     * @param lastName the user's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user name.
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the user's date of birth.
     * @return the date of birth.
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the user's date of birth.
     * @param dateOfBirth the user's date of birth.
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return String.format("User{firstName='%s', lastName='%s', userName='%s', dateOfBirth: '%s'}",
                firstName, lastName, userName, dateOfBirth);
    }


}