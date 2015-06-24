package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import options.BlackScholes;

/**
 * Servlet implementation class OptionsController
 */
@WebServlet("/OptionsController")
public class OptionsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OptionsController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action == null) {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);

		} else if (action.equals("docalculate")) {

			request.setAttribute("sprice", "");
			request.setAttribute("strike", "");
			request.setAttribute("rate", "");
			request.setAttribute("time", "");
			request.setAttribute("volatility", "");
			request.setAttribute("validation1", "");
			// request.setAttribute(validation2, "");

			request.getRequestDispatcher("/options.jsp").forward(request,
					response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		if (action != null) {

			String spotPrice = request.getParameter("sprice");
			String strikePrice = request.getParameter("strike");
			String interestRate = request.getParameter("rate");
			String timeTo = request.getParameter("time");
			String vol = request.getParameter("volatility");
			
			double sprice = Double.parseDouble(spotPrice);
			double strike = Double.parseDouble(strikePrice);
			double rate = Double.parseDouble(interestRate);
			double time = Double.parseDouble(timeTo);
			double volatility = Double.parseDouble(vol);

			double carryrate = rate;

			BlackScholes BS = new BlackScholes(carryrate);

			//for (int i = 0; sprice != null; i++) {
				// Map<Integer, Double> resultC = new HashMap<Integer,
				// Double>();
				// Map<Integer, Double> resultP = new HashMap<Integer,
				// Double>();
				BS.bscholEprice(sprice, strike, volatility, time, rate);
				double currentpriceC = BS.getCalle();
				double currentpriceP = BS.getPute();
				//resultC.put(i, currentpriceC);
				// result2.put(i, currentpriceP);
			//	request.setAttribute("result1", resultC);
				// request.setAttribute("result2", resultP);
				request.setAttribute("validation1", currentpriceC);
				request.setAttribute("validation2", currentpriceP);
		//	}
			
			request.setAttribute("sprice", sprice);
			request.setAttribute("strike", strike);
			request.setAttribute("rate", rate);
			request.setAttribute("time", time);
			request.setAttribute("volatility", volatility);
			
			request.getRequestDispatcher("/options.jsp").forward(request,
					response);

		} else {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}
	}
}
