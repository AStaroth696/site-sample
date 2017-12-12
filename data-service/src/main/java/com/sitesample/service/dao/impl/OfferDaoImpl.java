package com.sitesample.service.dao.impl;

import com.sitesample.service.dao.OfferDao;
import com.sitesample.service.model.Offer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OfferDaoImpl extends AbstractDao<Offer> implements OfferDao{

    @Autowired
    protected OfferDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    protected Class<Offer> getEntityType() {
        return Offer.class;
    }
}
