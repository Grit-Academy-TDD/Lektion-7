package org.example.services;

import org.example.BookingRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class BookingServiceTest {

    private RoomService roomService;
    private MailService mailService;
    private PaymentService paymentService;
    private BookingService bookingService;
    private ArgumentCaptor<Integer> payArgumentCaptor;

    @BeforeEach
    public void setUp() {
        roomService = mock(RoomService.class);
        mailService = mock(MailService.class);
        paymentService = mock(PaymentService.class);
        bookingService = new BookingService(mailService, roomService, paymentService);
        payArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
    }

    @Test
    public void should_payRightAmountOfMoney_When_prepaid() {
        BookingRequest bookingRequest = new BookingRequest("1", 3, 1, true, "1");
        bookingService.bookRoom(bookingRequest);
        verify(paymentService, times(1)).pay(payArgumentCaptor.capture());
        int amountToPay = payArgumentCaptor.getValue();
        // System.out.println(amountToPay);
        assertEquals(150, amountToPay);
    }

    @Test
    public void two_bookings_should_pay_right_amount_of_money_when_prepaid() {
        BookingRequest bookingRequest = new BookingRequest("1", 3, 1, true, "1");
        BookingRequest bookingRequest2 = new BookingRequest("2", 4, 2, true, "1");
        bookingService.bookRoom(bookingRequest);
        bookingService.bookRoom(bookingRequest2);
        verify(paymentService, times(2)).pay(payArgumentCaptor.capture());
        List<Integer> actualValues = payArgumentCaptor.getAllValues();
        List<Integer> expectedValues = Arrays.asList(400, 150);
        //System.out.println(amountToPay);
        assertEquals(expectedValues, actualValues);
    }

    @Test
    public void three_bookings_should_pay_right_amount_of_money_when_prepaid() {
        BookingRequest bookingRequest = new BookingRequest("1", 3, 1, true, "1");
        BookingRequest bookingRequest2 = new BookingRequest("2", 4, 2, true, "1");
        BookingRequest bookingRequest3 = new BookingRequest("2", 1, 2, true, "1");
        bookingService.bookRoom(bookingRequest);
        bookingService.bookRoom(bookingRequest2);
        bookingService.bookRoom(bookingRequest3);
        verify(paymentService, times(3)).pay(payArgumentCaptor.capture());
        List<Integer> actualValues = payArgumentCaptor.getAllValues();
        List<Integer> expectedValues = Arrays.asList(150, 400, 100);
        //System.out.println(amountToPay);
        assertEquals(expectedValues, actualValues);
    }

}