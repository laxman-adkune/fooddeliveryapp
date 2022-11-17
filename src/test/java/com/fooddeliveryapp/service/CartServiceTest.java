package com.fooddeliveryapp.service;

import com.fooddeliveryapp.entity.Cart;
import com.fooddeliveryapp.entity.CartItem;
import com.fooddeliveryapp.exception.CartNotFoundException;
import com.fooddeliveryapp.exception.InvalidCartItemDataException;
import com.fooddeliveryapp.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CartServiceTest {

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private Cart cart;

    @InjectMocks
    CartItem cartItem;

    @BeforeEach
    public void setUp() {
        cart.setCartId(1L);
        cart.setTotalAmount(0.0);

        cartItem.setCartItemId(1L);
        cartItem.setCartItemName("Thali");
        cartItem.setCartItemType("Lunch");
        cartItem.setCartItemImage("C:\\Users\\kdigamba\\OneDrive - Capgemini\\Pictures\\wallpaper");
        cartItem.setCartItemDescription("Delicious Thali");
        cartItem.setCartItemPrice(120.0);
        cartItem.setCartItemQuantity(1);
    }

    @Test
    public void testGetCartById() throws CartNotFoundException {
        Long cartId=1L;
        Mockito.when(cartRepository.findById(cartId)).thenReturn(Optional.of(cart));
        assertEquals(cart, cartService.getCartById(cartId));
        assertEquals(cart.getCartId(), cartService.getCartById(cartId).getCartId());
    }

//    @Test
//    public void testAddToCart() throws InvalidCartItemDataException, CartNotFoundException {
//        Mockito.doReturn(cart).when(cartRepository).save(cart);
//        assertEquals(cart.getCartId(), cartRepository.save(cart).getCartId());
//        assertEquals(cartService.addToCart(cart.getCartId(),cartItem.getCartItemId()),cartRepository.save(cart));
//        assertEquals(cart.getTotalAmount(), cartService.addToCart(cart.getCartId(),cartItem.getCartItemId()).getTotalAmount());
//        assertEquals(Stream.of(cart).collect(Collectors.toList()), cartService.addToCart(cart.getCartId(),cartItem.getCartItemId()).getCartItems());
//    }


}
