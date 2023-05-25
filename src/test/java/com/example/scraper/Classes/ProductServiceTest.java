package com.example.scraper.Classes;

import com.example.scraper.DAL.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;
    private ProductService underTest;

    @BeforeEach
    void setUp() {
        underTest = new ProductService(productRepository);
    }

    @Test
    void canAddUser() {
        //Given
        Product product = new Product(
                "After",
                "Link",
                15.0,
                "Jumbo"
        );

        //When
        underTest.AddUser(product);

        //Then
        ArgumentCaptor<Product> productArgumentCaptor =
                ArgumentCaptor.forClass(Product.class);

        verify(productRepository)
                .save(productArgumentCaptor.capture());

        Product capturedProduct = productArgumentCaptor.getValue();

        assertThat(capturedProduct).isEqualTo(product);
    }
}