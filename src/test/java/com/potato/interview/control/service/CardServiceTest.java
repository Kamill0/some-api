package com.potato.interview.control.service;

import com.potato.interview.boundary.dto.CardCreateDto;
import com.potato.interview.boundary.exception.UserNotFoundException;
import com.potato.interview.control.repository.CardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CardServiceTest {

    @Mock
    UserService userService;

    @Mock
    CardRepository cardRepository;
    @InjectMocks
    CardService cardService;

    /**
     * Unit tests of other methods here would be pointless as they would test just the mock behavior
     */
    @Test
    void shouldNotSaveCardWhenUserWasNotFound() {
        // given
        String userEmail = "test@email.com";
        String errorMessage = "email = " + userEmail;
        when(userService.getUserByEmail(anyString())).thenThrow(new UserNotFoundException(errorMessage));

        // when && then
        assertThatThrownBy(() -> cardService.save(new CardCreateDto().withUserEmail(userEmail)))
                .isInstanceOf(UserNotFoundException.class)
                .hasMessage("User not found for: " + errorMessage);
        verifyNoInteractions(cardRepository);
    }
}