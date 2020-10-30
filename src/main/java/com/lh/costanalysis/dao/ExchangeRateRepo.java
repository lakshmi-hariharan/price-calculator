package com.lh.costanalysis.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangeRateRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    class ExchangeRateRowMapper implements RowMapper<ExchangeRate> {
		@Override
		public ExchangeRate mapRow(ResultSet rs, int rowNum) throws SQLException {
			ExchangeRate exRate = new ExchangeRate();
			exRate.setCurrencyAlpha(rs.getString("currencyAlpha"));
			exRate.setCurrencyValue(rs.getDouble("currencyValue"));
			return exRate;
		}
    }

	public List<ExchangeRate> findAll() {
		return jdbcTemplate.query("select * from exRate", new ExchangeRateRowMapper());
	}

	public ExchangeRate findById(String curAlpha) {
		return jdbcTemplate.queryForObject("select * from exRate where currencyAlpha=?", new Object[] { curAlpha },
				new BeanPropertyRowMapper<ExchangeRate>(ExchangeRate.class));
    }
}
    
    
    