package java8.bo;

import java.time.LocalDate;
import java.util.Objects;

public class Utilisateur {
    private String firstName;
    private String lastName;
    private LocalDate dateAdhesion;

    public Utilisateur(String firstName, String lastName, LocalDate dateAdhesion) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateAdhesion = dateAdhesion;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(LocalDate dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(dateAdhesion, that.dateAdhesion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateAdhesion);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilisateur{");
        sb.append("firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", dateAdhesion=").append(dateAdhesion);
        sb.append('}');
        return sb.toString();
    }
}
