package com.flight.booking.flight;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.flight.booking.airline.entity.Airline;
import com.flight.booking.airport.entity.Airport;
import com.flight.booking.schedule.entity.FlightSchedule;

public class FlightRowMapper implements RowMapper<FlightSchedule> {
	
	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public FlightSchedule mapRow(ResultSet rs, int rowNum) throws SQLException {
		FlightSchedule schedule = new FlightSchedule();
		HibernateTemplate template = new HibernateTemplate();
		Airport from = template.get(Airport.class, rs.getInt("from"));
		Airport to = template.get(Airport.class, rs.getInt("to"));
		Airline air = template.get(Airline.class, rs.getInt("airline_id"));
		
		schedule.setDepartFrom(from.getName());
		schedule.setGoingTo(to.getName());
		schedule.setAirline(air.getName());
		schedule.setId(rs.getInt("id"));
		schedule.setDepartDate(rs.getString("departure_date"));
		schedule.setArvlDate(rs.getString("arrival_time"));
		schedule.setDepartTime(rs.getString("depart_time"));
		schedule.setArvlTime(rs.getString("arrival_time"));
		schedule.setStatus(rs.getInt("status"));
		return schedule;
	}

}
