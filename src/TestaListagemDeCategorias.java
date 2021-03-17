import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDao;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;



public class TestaListagemDeCategorias {

	public static void main(String[] args) throws SQLException {
		
		
		try(Connection connection = new ConnectionFactory().recuperarConexao()){
			
			CategoriaDao categoriaDao = new CategoriaDao(connection);
			List<Categoria> listaDeCategorias = categoriaDao.listar();
			
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				
				for (Produto produto: ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
					
				}
			
		}
					
//					try {
//						for(Produto produto : new ProdutoDAO(connection).buscar(ct)) {
//							System.out.println(ct.getNome() + "-" + produto.getNome());
//					} catch (Exception e) {
//						e.printStackTrace()
//					}
//				}
			);
			
		}
		

		
	}

}
