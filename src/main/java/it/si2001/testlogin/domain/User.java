package it.si2001.testlogin.domain;




import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "utente", schema = "rentalcar")
public class User implements Serializable {
    private Long idUtente;
    private String nome;
    private String cognome;
    private String password;
    private Date dataNascita;
    private Short privilegi;
    private String email;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "idUtente")
    public Long getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(Long idUtente) {
        this.idUtente = idUtente;
    }

    @Basic
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Basic
    @Column(name = "cognome")
    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "data_nascita")
    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Basic
    @Column(name = "privilegi")
    public Short getPrivilegi() {
        return privilegi;
    }

    public void setPrivilegi(Short privilegi) {
        this.privilegi = privilegi;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User that = (User) o;
        return idUtente == that.idUtente &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(cognome, that.cognome) &&
                Objects.equals(password, that.password) &&
                Objects.equals(dataNascita, that.dataNascita) &&
                Objects.equals(privilegi, that.privilegi) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUtente, nome, cognome, password, dataNascita, privilegi, email);
    }
}