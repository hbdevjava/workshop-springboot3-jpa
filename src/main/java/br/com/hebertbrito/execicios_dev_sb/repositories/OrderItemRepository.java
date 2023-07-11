package br.com.hebertbrito.execicios_dev_sb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.hebertbrito.execicios_dev_sb.entities.OrderItem;


public interface OrderItemRepository extends JpaRepository <OrderItem, Long>{

}

/**
 * NESSA CASO VC ESPECÍFICO NÃO HÁ NECESSIDADE DE SE IMPLEMENTAR ESSA INTERFACE
 * PQ O SPRING.DATA.JPA ELE JA TEM UM IMPLEMENTAÇÃO PADRÃO PRA ESSA INTERFACE,
 * COMO ESTA DEFINIDO NO GENERICS <User, Long> JA VOU TEM UMA IMPLEMENTAÇAO PADRÃO 
 * PARA ESSE TIPO...
 * */
