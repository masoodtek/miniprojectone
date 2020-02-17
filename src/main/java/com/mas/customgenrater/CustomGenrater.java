package com.mas.customgenrater;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomGenrater implements IdentifierGenerator{

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		Connection connection = null;
		Statement createStatement = null;
		ResultSet executeQuery =null;
		String idIn="mas";
		Integer seffix =0;
		String sql="SELECT mas_seq.NEXTVAL FROM dual";
		
		try {
			connection = session.connection();
			createStatement = connection.createStatement();
			executeQuery = createStatement.executeQuery(sql);
			if(executeQuery.next()) {
				 seffix =executeQuery.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idIn+String.valueOf(seffix);
	}

}
