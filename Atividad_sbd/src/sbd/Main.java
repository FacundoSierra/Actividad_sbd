package sbd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
	static Connection con = null;
	static PreparedStatement pst = null;
	ResultSet rs = null;

	public static void main(String[] args) {
		Conexion cx = new Conexion();
		con = cx.conn();
		a();
		b();
		c();
		d();
		e();
	}

	public static void a() {
		try {
			String sql_a = "SELECT gt.nombre_tema, SUM(c.dinero_gastado) AS total_gastado " + "FROM Gusta_Tema gt "
					+ "JOIN Clientes c ON gt.DNI = c.DNI " + "GROUP BY gt.nombre_tema " + "ORDER BY total_gastado DESC "
					+ "LIMIT 1;";

			pst = con.prepareStatement(sql_a);
			ResultSet rs = pst.executeQuery(sql_a);
			System.out.println("Query 1:");
			while (rs.next()) {
				String tema = rs.getString("nombre_tema");
				double totalGastado = rs.getDouble("total_gastado");

				System.out.println("Tema mas rentable: " + tema + " con un gasto total de: " + totalGastado);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void b() {
		try {
			String sql_b = "SELECT nombre_art FROM Artistas WHERE (estilo = 'pintura' AND estilo = 'escultura')";

			pst = con.prepareStatement(sql_b);
			ResultSet rs = pst.executeQuery(sql_b);
			System.out.println("Query 2:");
			while (rs.next()) {
				String nombre_art = rs.getString("nombre_art");

				System.out.println("Artista: " + nombre_art);
			}
			if (!rs.next()) {
				System.out.println("No hay Artistas con esas caracteristicas");
			}
		} catch (Exception e) {
			System.out.println("" + e);
		}
	}

	public static void c() {
		try {
			String sql_c = "SELECT o.nombre_art, SUM(o.precio) AS valor_total " + "FROM Obra o "
					+ "GROUP BY o.nombre_art " + "ORDER BY valor_total DESC " + "LIMIT 1;";

			pst = con.prepareStatement(sql_c);
			ResultSet rs = pst.executeQuery(sql_c);
			System.out.println("Query 3:");
			while (rs.next()) {
				String nombre_art = rs.getString("nombre_art");
				double valorTotal = rs.getDouble("valor_total");

				System.out.println("Artista con mayor valor: " + nombre_art + " con un valor total de: " + valorTotal);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void d() {
		try {
			String sql_d = "SELECT o.titulo, o.año_creacion " + "FROM Obra o "
					+ "JOIN Pertenece p ON o.titulo = p.titulo " + "JOIN Temas t ON p.nombre_tema = t.nombre_tema "
					+ "WHERE o.año_creacion < 2000 AND t.nombre_tema = 'retratos';";
			pst = con.prepareStatement(sql_d);
			ResultSet rs = pst.executeQuery(sql_d);
			System.out.println("Query 4: ");
			while (rs.next()) {
				String obra = rs.getString("titulo");
				int año = rs.getInt("año_creacion");
				System.out.println("Obra: " + obra + ", año de creación: " + año);
			}
			if (!rs.next()) {
				System.out.println("No hay obras antes del 2000 con tema = retrato");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void e() {

		try {
			String sql_e = "SELECT c.nombre_cliente, a.nombre_art FROM Clientes c JOIN Artistas a ON c.direccion_CP = a.CP "
					+ "LEFT JOIN Gusta_Artista ga ON c.DNI = ga.DNI AND a.nombre_art = ga.nombre_art "
					+ "WHERE ga.nombre_art IS NULL;";

			pst = con.prepareStatement(sql_e);
			ResultSet rs = pst.executeQuery(sql_e);
			System.out.println("Query 5:");
			while (rs.next()) {
				String nombreCliente = rs.getString("nombre_cliente");
				String nombreArt = rs.getString("nombre_art");
				System.out.println("Cliente: " + nombreCliente + " -Artista: " + nombreArt);
			}

		} catch (Exception e) {
			System.out.println("" + e);
		}
	}

}
