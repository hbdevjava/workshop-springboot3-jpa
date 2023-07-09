package br.com.hebertbrito.execicios_dev_sb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
@Entity
@Table(name = "tb_products")
public class Product implements Serializable {
		private static final long serialVersionUID = 1L;
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		private String name;
		private String description;
		private Double price;
		private String imgUrl;
		
		
		@Transient //-> IGNORA O ATRIBUTO (private Set<Category> cantegories = new HashSet<>());
//		@ManyToMany(mappedBy = "products")
		private Set<Category> cantegories = new HashSet<>();
		//-> SET É UMA INTERFACE E NAO PODE SER INSTANCIADA ENTAO SE USA HashSet QUE É UMA CLASSE CORRESPONDENTE A ESSA INTERFACE
		//-> OUTRO EX: list -> ArraysList
		
		
		public Product() {
			
		}

		//NAO COLOCA A COLEÇAO NO CONSTRUTOR PQ ELA JA ESTA SENDO INSTANCIADA A CIMA

		public Product(Long id, String name, String description, Double price, String imgUrl) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.price = price;
			this.imgUrl = imgUrl;
			
		}



		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getImgUrl() {
			return imgUrl;
		}

		public void setImgUrl(String imgUrl) {
			this.imgUrl = imgUrl;
		}

		public Set<Category> getCantegories() {
			return cantegories;
		}

		

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			return Objects.equals(id, other.id);
		}

		
		
}
