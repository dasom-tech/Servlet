package com.mystudy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sungjuk")
public class Ex05 extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//요청 정보 추출
		String name = request.getParameter("name");
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String math = request.getParameter("math");
		
		//서버 콘솔에 출력
		System.out.println("-------------------");
		System.out.println("name : " + name);
		System.out.println("kor : " + kor);
		System.out.println("eng : " + eng);
		System.out.println("math : " + math);
		
		//클라이언트(브라우저) 쪽으로 응답 처리
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int sum = Integer.parseInt(kor) + Integer.parseInt(eng) + Integer.parseInt(math);
		//double avg = (int)(sum / 3.0 * 100) / 100.0;
		double avg = sum / 3.0;
		
		out.println("<h2>성적처리결과</h2>");
		out.println("<table border>");
		out.println("<tr>");
		out.println("<th>이름  </th>");
		out.println("<td>" + name + "</td>");		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>국어  </th>");
		out.println("<td>" + kor + "</td>");		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>영어  </th>");
		out.println("<td>" + eng + "</td>");		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>수학  </th>");
		out.println("<td>" + math + "</td>");		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>총점  </th>");
		out.println("<td>" + sum + "</td>");		
		out.println("</tr>");
		out.println("<tr>");
		out.println("<th>평균  </th>");
		//out.println("<td>" + avg + "</td>");
		out.println("<td>" + String.format("%.2f", avg) + "</td>");
		out.println("</tr>");
		out.println("</table>");
	}

}