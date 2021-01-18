package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletApuestas
 */
@WebServlet(name = "/ServletApuestas", urlPatterns = { "/ServletApuestas" })
public class ServletApuestas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletApuestas() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("Los datos se están mandando por el método post, no por aquí");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		PrintWriter out = response.getWriter();

		if (request.getParameter("enviar") != null) {

			String apuesta = request.getParameter("apuesta");

			float cantidad = Float.parseFloat(request.getParameter("cantidadApostada"));

			String nombre = request.getParameter("nombre");

			if (apuesta.equals("1")) {
				cantidad *= 1.45;
				// out.println("El jugador " + nombre + " ha ganado : " + cantidad + " euros");

			}
			if (apuesta.equals("x")) {
				cantidad *= 2.10;
				// out.println("El jugador " + nombre + " ha ganado : " + cantidad + " euros");
			}
			if (apuesta.equals("2")) {
				cantidad *= 5.00;
				// out.println("El jugador " + nombre + " ha ganado : " + cantidad + " euros");
			}
			request.setAttribute("cantidadApostada", cantidad);
			request.setAttribute("nombre", nombre);
		}

		else {
			float cantidad = Float.parseFloat(request.getParameter("cantidadApostada"));
			String azar = request.getParameter("azar");
			String boton = request.getParameter("confirmar");
			String nombre = request.getParameter("nombre");

			if (azar.equals("ganar")) {
				request.setAttribute("acierto", true);
			}
			if (azar.equals("perder")) {
				request.setAttribute("acierto", false);
			}
			request.setAttribute("nombre", nombre);
			request.setAttribute("boton", boton);
			request.setAttribute("cantidadApostada", cantidad);
		}

		request.getRequestDispatcher("confirmarApuesta.jsp").forward(request, response);
	}

}
