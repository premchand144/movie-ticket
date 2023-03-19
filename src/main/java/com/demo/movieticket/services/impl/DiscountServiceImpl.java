package com.demo.movieticket.services.impl;

import com.demo.movieticket.entities.DiscountEntity;
import com.demo.movieticket.entities.TheaterEntity;
import com.demo.movieticket.entities.TheaterSeatEntity;
import com.demo.movieticket.enums.DiscountType;
import com.demo.movieticket.repositories.DiscountRepository;
import com.demo.movieticket.rest.dtos.BookingDto;
import com.demo.movieticket.services.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class DiscountServiceImpl implements DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public double calculateDiscount(BookingDto bookingDto, List<TheaterSeatEntity> theaterSeats) {
        List<DiscountEntity> discounts = discountRepository.findByCityIdAndTheaterId(bookingDto.getCityId(), bookingDto.getTheaterId());
        if(discounts.isEmpty())
            return 0;
        double totalDiscount = 0;
        if(theaterSeats.size() > 2) {
            Optional<DiscountEntity> fiftyPercentDiscountOpt = discounts.stream().filter(discount -> discount.getDiscountType() == DiscountType.FIFTY_PERCENT).findAny();

            TheaterEntity theater = new TheaterEntity();
            theater.setId(bookingDto.getTheaterId());

            if (fiftyPercentDiscountOpt.isPresent()) {
                TheaterSeatEntity theaterSeatEntity = theaterSeats.get(2);
                totalDiscount += theaterSeatEntity.getPrice() * 50 / 100;
            }
        }
        if (bookingDto.getShowTime().isAfter(LocalTime.of(12, 00))) {
            Optional<DiscountEntity> twentyPercentDiscountOpt = discounts.stream().filter(discount -> discount.getDiscountType() == DiscountType.TWENTY_PERCENT).findAny();
            if(twentyPercentDiscountOpt.isPresent()) {
                double totalSum = theaterSeats.stream().mapToDouble(TheaterSeatEntity::getPrice).sum();
                totalDiscount += totalSum * 20 / 100;
            }
        }
        return totalDiscount;
    }
}
