package web;

import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;





import DAO.IProduitDao;
import DAO.ProduitDaoImpl;
import metier.entities.Produit;


//@WebServlet(name="cs", urlPatterns=".*do")
//@WebServlet("/cs")
public class ControleurServlet  extends HttpServlet{
	private IProduitDao metier;
    
	@Override
	public void init() throws ServletException {
		// on n a pas besoin de cette cmd avec spring
		//metier=new ProduitDaoImpl();
		// recuperer le context de spring
		ApplicationContext springContext=
				WebApplicationContextUtils.getRequiredWebApplicationContext
				(this.getServletContext());
		//metier= (IProduitDao)springContext.getBean("dao"); 
		//ou bien the same code
		metier= springContext.getBean(IProduitDao.class);
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse 
			response) throws ServletException, IOException {
	String path=request.getServletPath();
	if(path.equals("/index.do")) {
		request.getRequestDispatcher("produits.jsp").forward(request, response);
		
	}
	
	else if(path.equals("/chercher.do")) {
		String motCle=request.getParameter("motCle");
		ProduitModel model=new ProduitModel();
		model.setMotCle(motCle);
		List<Produit> produits=metier.produitsParMC("%"+motCle+"%");
	model.setProduits(produits);
	request.setAttribute("model",model);
	request.getRequestDispatcher("produits.jsp").forward(request, response);
	
	}
	else if (path.equals("/Saisie.do")) {
		request.setAttribute("produit",new Produit());
		request.getRequestDispatcher("SaisieProduit.jsp").forward(request, response);
	}
	else if (path.equals("/saveProduit.do")&&(request.getMethod().equals("POST")))
	{ 
	String des=request.getParameter("designation");
	double prix=Double.parseDouble(request.getParameter("prix"));
	int quantite=Integer.parseInt(request.getParameter("quantite"));
	Produit p= metier.save(new Produit(des,prix,quantite));
	request.setAttribute("produit", p);
	request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
		
	}
	else if(path.equals("/supprime.do"))
	{
		
		Long id=Long.parseLong(request.getParameter("id"));
		metier.deleteProduit(id);
		//request.getRequestDispatcher("produits.jsp").forward(request, response);
	    response.sendRedirect("chercher.do?motCle=");
	
	}
	else if(path.equals("/edit.do"))
		
	{
		Long id=Long.parseLong(request.getParameter("id"));
		Produit p= metier.getProduit(id);
		request.setAttribute("produit", p);
		request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
		
		
		
	}
	else if (path.equals("/updateProduit.do")&&(request.getMethod().equals("POST")))
	{ 
		Long id= Long.parseLong(request.getParameter("id"));
	String des=request.getParameter("designation");
	double prix=Double.parseDouble(request.getParameter("prix"));
	int quantite=Integer.parseInt(request.getParameter("quantite"));
	Produit p= new Produit(des,prix,quantite);
	p.setId(id);
	metier.updateProduit(p);
	request.setAttribute("produit", p);
	request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
		
	}
	else {
		response.sendError(HttpServletResponse.SC_NOT_FOUND);
	}
	
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse
			response) throws ServletException, IOException {
		
		doGet(request, response);
	}
}