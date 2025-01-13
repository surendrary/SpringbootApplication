package com.springboot_basic.SpringbootApplication.SpringbootJdbc.Dao;

import com.springboot_basic.SpringbootApplication.SpringbootJdbc.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PlayerDao {

    private static final class PlayerMapper implements RowMapper<Player> {
        /*Custome Row Mapper In Case Bean definition is different than Table description*/
        @Override
        public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
            Player player = new Player();
            player.setId(rs.getInt("id"));
            player.setName(rs.getString("name"));
            player.setNationality(rs.getString("nationality"));
            player.setBirthDate(rs.getDate("birth_date"));
            player.setTitles(rs.getInt("titles"));
            return player;
        }

    }
    @Autowired
    JdbcTemplate jdbcTemplate;

    /* BeanPropertyRowMapper is default Query result mapper to Java Object in Spring */

    public List<Player> getAllPlayers() {
        return jdbcTemplate.query("select * from player", new PlayerMapper());
    }

    public Player getPlayerById(int id) {
        String sql = "SELECT * FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<Player>(Player.class),
                new Object[] {id});
    }

    public int insertPlayer(Player player) {
        String sql =  "INSERT INTO PLAYER(id, name, nationality,Birth_date,titles)" + "VALUES(?,?,?,?,?)";
        return jdbcTemplate.update(sql, new Object []{player.getId(),player.getName(),player.getNationality(),
                player.getBirthDate(),player.getTitles()});

    }

    public int updatePlayer(Player player) {
        String sql = "UPDATE PLAYER SET name = ?,nationality = ?,Birth_date = ?,titles = ? WHERE ID = ?";

        return jdbcTemplate.update(sql, new Object []{player.getName(),player.getNationality(),player.getBirthDate(),player.getTitles(),player.getId()});
    }

    public int deletePlayer(int id) {
        String sql = "DELETE FROM PLAYER WHERE ID = ?";
        return jdbcTemplate.update(sql, new Object []{id});
    }

    public void createTournamentTable() {
        String sql = "CREATE TABLE TOURNAMENT (ID INTEGER, NAME VARCHAR(50), LOCATION VARCHAR(50), PRIMARY KEY (ID))";
        jdbcTemplate.execute(sql);
        System.out.println("Table created");
    }

}
