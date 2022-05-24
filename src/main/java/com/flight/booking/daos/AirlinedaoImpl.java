package com.flight.booking.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flight.booking.entities.Airline;


@Repository
public class AirlinedaoImpl implements AirlineDAO {
	
	@Autowired
	private HibernateTemplate template;
	
	public HibernateTemplate getHibernateTemplate() {
		return template;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.template = hibernateTemplate;
	}

	@Override
	public List<Airline> getAll() {
		return template.loadAll(Airline.class);
	}
	
	@Override
	public Airline getAirline(int id) {
		return template.get(Airline.class, id);
	}
	
	@Override
	@Transactional
	public Boolean updateAirline(Airline airline) {
		template.saveOrUpdate(airline);
		return true;
	}

	@Override
	@Transactional
	public void removeAirline(Airline airline) {
		template.delete(airline);		
	}
	
	
	@Override
	@Transactional
	public void addAirline(Airline airline) {
		template.save(airline);		
	}
}
