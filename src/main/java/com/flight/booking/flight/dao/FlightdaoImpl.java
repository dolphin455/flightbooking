package com.flight.booking.flight.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flight.booking.airport.entity.Airport;
import com.flight.booking.flight.BookUserDetail;
import com.flight.booking.flight.FlightRowMapper;
import com.flight.booking.flight.SearchFlightParams;
import com.flight.booking.flight.entity.userbooking.UserBooking;
import com.flight.booking.schedule.entity.FlightSchedule;
import com.flight.booking.seats.entity.Seat;


@Repository
public class FlightdaoImpl implements FlightDAO {

	@Autowired
	private HibernateTemplate template;
	
//	@Autowired
//	private JdbcTemplate jdbc;

	@Override
	public List<Airport> getAllAirports() {
		List<Airport> airports = template.loadAll(Airport.class);
		return airports;
	}

	@Override
	public List<Object[]> searchFlights(SearchFlightParams params) {
		String sql = "select fs.id, fs.departure_date, fs.arrival_date, a1.name as departFrom, "
				+ "a2.name as goingTo, air.name as airline, fs.departure_time, fs.arrival_time, fs.fare from flight_schedules fs left join airports a1 on "
				+ "fs.`from` = a1.id left join airports a2 on fs.`to` = a2.id left join airlines air on "
				+ "fs.airline_id = air.id"
				+ " where fs.`from` = '" + params.getFrom() + "' and fs.`to` = '"+params.getTo()+"' "
				+ "and departure_date = '"+params.getDate()+"'";
		Session session = template.getSessionFactory().openSession();
		List <Object[]> list = session.createNativeQuery(sql).getResultList();

		 for (Object[] objects : list) {
            System.out.println("Employee["+objects[0]+","+objects[1]+","+objects[2]+"]");
         }
		return list;
	}

	@Override
	@Transactional
	public String bookTicket(BookUserDetail detail) {
		String sql = "select * from seats where schedule_id =" + detail.getScheduleId()+ " and remaining_seats >= " + detail.getPassenger();
		Session session = template.getSessionFactory().openSession();
		List<Object[]> list = session.createNativeQuery(sql).getResultList();
		if(list.size() != 0) {
			String PNR = Long.toString((new Date()).getTime());
			//template.save(book);
			Session session2 = template.getSessionFactory().getCurrentSession();
			UserBooking book = new UserBooking();
			book.setPassengers(detail.getPassenger());
			book.setPNR(PNR);
			book.setScheduleId(detail.getScheduleId());
			book.setEmail(detail.getEmail());
			int userId = (Integer) session2.save(book);
			System.out.println(list.get(0)[0]);
			int seatId = (int) list.get(0)[0];
			Seat seat = template.get(Seat.class, seatId);
			seat.setRemainingSeats(seat.getRemainingSeats() - detail.getPassenger());
			
			template.update(seat);
			return PNR;
		}
		return null;
	}

	@Override
	public List<Object[]> getBookingDetails(String pnr) {
		String sql = "select ub.id, ub.passengers, ub.schedule_id,"
				+ " ub.PNR, ub.booked_at, ub.user_email, ub.is_active, fs.airline_id, "
				+ "fs.fare, fs.flight_number, fs.departure_date, fs.departure_time,"
				+ " fs.arrival_date , fs.arrival_time, a1.name as airline, "
				+ "a2.name as Depart_From, a3.name as Arrival_At from user_bookings ub"
				+ " left join flight_schedules fs on ub.schedule_id = fs.id"
				+ " left join airlines a1 on fs.airline_id = a1.id"
				+ " left join airports a2 on fs.from = a2.id left join"
				+ " airports a3 on fs.to = a3.id where ub.PNR = " + pnr;
		Session session = template.getSessionFactory().openSession();
		List<Object[]> list = session.createNativeQuery(sql).getResultList();
		
		if (list.size() != 0) {
			return list;
		}
		return null;
	}
	
	

}
