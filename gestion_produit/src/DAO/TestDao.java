package DAO;

import java.util.List;

import metier.entities.Produit;

public class TestDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProduitDaoImpl dao=new ProduitDaoImpl();
	
		
		Produit p1=dao.save(new Produit( "HP6522",900,45));
		Produit p2=dao.save(new Produit("imprimante",9005,5));
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println("chercher les produits");
		List<Produit>prods=dao.produitsParMC("%H%");
		for(Produit p:prods) {
			System.out.println(p.toString());
		}
		
		
		

	}

}
