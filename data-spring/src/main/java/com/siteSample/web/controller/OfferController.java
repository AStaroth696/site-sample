package com.siteSample.web.controller;

import com.sitesample.service.dao.OfferDao;
import com.sitesample.service.model.Offer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OfferController {

    @Autowired
    OfferDao offerDao;

    @RequestMapping(value = "offers", method = RequestMethod.GET)
    public String viewOffers(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication());
        model.addAttribute("offers", offerDao.getAll());
        return "offers";
    }

    @RequestMapping(value = "createoffer", method = RequestMethod.GET)
    public String newOfferPage(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication());
        return "createoffer";
    }

    @RequestMapping(value = "createoffer", method = RequestMethod.POST)
    public String createOffer(Model model,
                              @RequestParam(value = "header") String header,
                              @RequestParam(value = "description") String description,
                              @RequestParam(value = "price") String price){

        List<String> errors = new ArrayList<>();

        if (StringUtils.isEmpty(header)) {
            errors.add("Заполните заголовок.");
        }
        if (StringUtils.isEmpty(description)){
            errors.add("Заполните описание");
        }
        if (StringUtils.isEmpty(price)){
            errors.add("Установите цену");
        }
        if (errors.size()>0){
            model.addAttribute("errors", errors);
            return "createoffer";
        }else {
            Offer offer = new Offer();
            offer.setHeader(header);
            offer.setDescription(description);
            offer.setPrice(Float.parseFloat(price));
            offer.setDate(new Date());
            offerDao.create(offer);

            return "forward:user";
        }

    }

}
