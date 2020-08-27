package it.si2001.testlogin.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


import it.si2001.testlogin.domain.User;
import org.springframework.jdbc.core.RowMapper;


public class UserMapper implements RowMapper<User>
{
    public User mapRow(ResultSet row, int rowNum) throws SQLException
    {
        User utente = new User();

        try
        {
            utente.setIdUtente(row.getLong("idUtente"));
            utente.setNome(row.getString("nome").trim());
            utente.setCognome(row.getString("cognome").trim());
            utente.setPassword(row.getString("password").trim());
            utente.setDataNascita(row.getDate("data_nascita"));
            utente.setPrivilegi(row.getShort("privilegi"));
            utente.setEmail(row.getString("email").trim());

        }
        catch (Exception ex)
        {
            System.out.println("Errore in ArticoliMapper.mapRow: " + ex);
        }


        return utente;
    }
}