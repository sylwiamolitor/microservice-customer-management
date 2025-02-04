package org.sylwia.customer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import org.sylwia.clients.fraud.FraudCheckHistoryResponse;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CustomerService customerService;

    private CustomerRegistrationRequest validRequest;

    @BeforeEach
    void setUp() {
        validRequest = new CustomerRegistrationRequest("John", "Doe", "john.doe@example.com");
    }

    @Test
    void givenValidEmail_whenRegisterCustomer_thenNoExceptionThrown() {
        when(customerRepository.findCustomerByEmail(validRequest.email())).thenReturn(Optional.empty());
        when(customerRepository.saveAndFlush(any(Customer.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(restTemplate.getForObject(any(String.class), eq(FraudCheckHistoryResponse.class), Optional.ofNullable(any()))).thenReturn(new FraudCheckHistoryResponse(false));

        assertDoesNotThrow(() -> customerService.registerCustomer(validRequest));

        verify(customerRepository).saveAndFlush(any(Customer.class));
    }

    @Test
    void givenInvalidEmail_whenRegisterCustomer_thenThrowException() {
        CustomerRegistrationRequest invalidEmailRequest = new CustomerRegistrationRequest("John", "Doe", "invalid-email");

        Exception exception = assertThrows(IllegalStateException.class, () -> customerService.registerCustomer(invalidEmailRequest));
        assertEquals("Email not valid", exception.getMessage());
    }

    @Test
    void givenTakenEmail_whenRegisterCustomer_thenThrowException() {
        when(customerRepository.findCustomerByEmail(validRequest.email())).thenReturn(Optional.of(new Customer()));

        Exception exception = assertThrows(IllegalStateException.class, () -> customerService.registerCustomer(validRequest));
        assertEquals("Email taken", exception.getMessage());
    }

    @Test
    void givenFraudulentEmail_whenRegisterCustomer_thenThrowException() {
        when(customerRepository.findCustomerByEmail(validRequest.email())).thenReturn(Optional.empty());
        when(customerRepository.saveAndFlush(any(Customer.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(restTemplate.getForObject(any(String.class), eq(FraudCheckHistoryResponse.class), Optional.ofNullable(any()))).thenReturn(new FraudCheckHistoryResponse(true));

        Exception exception = assertThrows(IllegalStateException.class, () -> customerService.registerCustomer(validRequest));
        assertEquals("fraudster", exception.getMessage());
    }
}
