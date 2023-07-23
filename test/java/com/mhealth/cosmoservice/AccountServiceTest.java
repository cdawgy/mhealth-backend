package com.mhealth.cosmoservice;

import main.java.com.mhealth.cosmoservice.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

//@SpringBootTest
class AccountServiceTest {

//	@Mock
//	private AccountRepository mockedAccountRepository;

//	@BeforeEach
//	public void setup() {
//		mockedAccountRepository = Mock(AccountRepository.class)
//	}

	@Test
	void givenGoogleId_whenFindingAccount_thenReturnOptionalAccount() {
		assertTrue(true);
	}

}
