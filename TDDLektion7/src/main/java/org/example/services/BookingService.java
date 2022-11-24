package org.example.services;

import org.example.BookingRequest;

public class BookingService {
    private MailService mailService;
    private RoomService roomService;
    private PaymentService paymentService;
    private static int PAY_PER_DAY = 50;

    public int calculatePrice(BookingRequest bookingRequest) {
        return PAY_PER_DAY * bookingRequest.getGuestCount() * bookingRequest.getDaysStaying();
    }

    public int calculatePriceInEuro(BookingRequest bookingRequest){
        return (CurrencyConverter.toEuro(PAY_PER_DAY * bookingRequest.getGuestCount() * bookingRequest.getDaysStaying()));
    }

    public void bookRoom(BookingRequest bookingRequest) {
        int amountToPay = calculatePrice(bookingRequest);
        if (bookingRequest.isPrepaid()) {
            paymentService.pay(amountToPay);
        }
    }

    public BookingService(MailService mailService, RoomService roomService, PaymentService paymentService) {
        this.mailService = mailService;
        this.roomService = roomService;
        this.paymentService = paymentService;
    }

    public MailService getMailService() {
        return mailService;
    }

    public RoomService getRoomService() {
        return roomService;
    }

    public PaymentService getPaymentService() {
        return paymentService;
    }
}
