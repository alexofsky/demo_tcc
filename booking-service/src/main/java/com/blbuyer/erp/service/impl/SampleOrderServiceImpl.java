package com.blbuyer.erp.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.blbuyer.core.logging.Logger;
import com.blbuyer.core.logging.LoggerUtils;
import com.blbuyer.erp.domain.QSampleOrder;
import com.blbuyer.erp.domain.QSampleRoom;
import com.blbuyer.erp.domain.SampleOrder;
import com.blbuyer.erp.domain.SampleRoom;
import com.blbuyer.erp.service.SampleOrderService;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class SampleOrderServiceImpl implements SampleOrderService {
	
	private static final Logger LOGGER = LoggerUtils.getLogger(SampleOrderServiceImpl.class);

	@PersistenceContext(unitName = "baseEntityManagerFactory")
	private EntityManager em;

	private QSampleOrder qOrderInfo = QSampleOrder.sampleOrder;
	private QSampleRoom qSampleRoom = QSampleRoom.sampleRoom;





	@Override
	@Transactional
	public String createOrder(Integer orderamount) {
		// TODO Auto-generated method stub
		if (orderamount > 100) {
			throw new RuntimeException("orderamount is bigger than 100");
		}
		SampleOrder sampleOrder = new SampleOrder();
		sampleOrder.setStatus("0");
		em.persist(sampleOrder);		
		return sampleOrder.getId();
	}

	@Override
	@Transactional
	public void cancelCreateOrder(String orderId) {
		// TODO Auto-generated method stub

		JPAQuery<SampleOrder> query = new JPAQuery<SampleOrder>(em).from(qOrderInfo).where(qOrderInfo.id.eq(orderId));
		SampleOrder sampleOrder = query.fetchOne();
		if (sampleOrder != null) {
			sampleOrder.setStatus("1");
			em.merge(sampleOrder);
		}
	}

	@Override
	@Transactional
	public String createRoom(Integer rooms) {
		// TODO Auto-generated method stub
		String id = "";
		if (rooms > 500) {
			throw new RuntimeException("rooms amount is bigger than 500");
		}
		SampleRoom sampleRoom = new SampleRoom();
		sampleRoom.setStatus("0");
		em.persist(sampleRoom);
		id = sampleRoom.getId();
		return id;
		
	}

	@Override
	@Transactional
	public void cancelCreateRoom(String roomId) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		JPAQuery<SampleRoom> query = new JPAQuery<SampleRoom>(em).from(qSampleRoom).where(qSampleRoom.id.eq(roomId));
		SampleRoom sampleRoom = query.fetchOne();
		if (sampleRoom != null) {
			sampleRoom.setStatus("1");
			em.merge(sampleRoom);
		}
	
	}
	
	

}
