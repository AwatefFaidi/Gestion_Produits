package DAO;

import java.util.List;

import metier.entities.Produit;

public interface IProduitDao {
	public Produit save(Produit p);
	public Produit getProduit(long id);
	public Produit updateProduit(Produit p);
	public void  deleteProduit(long id);
	public List<Produit> produitsParMC(String mc);

}
