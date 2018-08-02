package com.matheus.myOrder;

import java.sql.Array;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.matheus.myOrder.domain.Categoria;
import com.matheus.myOrder.domain.Produto;
import com.matheus.myOrder.repositories.CategoriaRepository;
import com.matheus.myOrder.repositories.ProdutoRepository;


@SpringBootApplication
public class TccApplication implements CommandLineRunner{

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TccApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Pizza");
		Categoria cat2 = new Categoria(null, "Bebida");
		Categoria cat3 = new Categoria(null, "Sobremesa");
		
		Produto p1 = new Produto(null, "Calabresa",4 ,30.00);
		Produto p2 = new Produto(null, "mussarela", 5, 25.00);
		Produto p3 = new Produto(null, "Coca-Cola", 1, 8.00);
		Produto p4 = new Produto(null, "Pudim", 1, 3.00);
		cat1.getProdutos().addAll(Arrays.asList(p1,p2));
		cat2.getProdutos().addAll(Arrays.asList(p3));
		cat3.getProdutos().addAll(Arrays.asList(p4));
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1));
		p3.getCategorias().addAll(Arrays.asList(cat2));
		p4.getCategorias().addAll(Arrays.asList(cat3));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2,cat3));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3,p4));
}
	

}
