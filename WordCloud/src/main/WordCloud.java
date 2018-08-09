package main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WordCloud
 */
@WebServlet("/WordCloud")
public class WordCloud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordCloud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int num,length;
		double val,max=0,min=9999;
		double q;
		String text = request.getParameter("input_text");
		String split_var = request.getParameter("split_var");
		String words[]= text.split(split_var);
		
		
		HashMap<String,Double> word_count = new HashMap<String,Double>();
		for(String s : words){
			if(!word_count.containsKey(s)){
				word_count.put(s, (double) 1);
			}
			else{
				word_count.put(s, word_count.get(s)+1);
			}
				
		}
		num=2;
		length = word_count.size();
		q=2;
		while(q>1){
			
			q=length/Math.pow(num, num);
			num++;
		}
		if(num>3){
			num-=2;
		}
		else{
			num=2;	
		}
		for(String word:word_count.keySet()){
			if(max<word_count.get(word))
				max=word_count.get(word);
			if(min>word_count.get(word))
				min=word_count.get(word);
		}
		System.out.println(max +" " +min);
		// scaling
		/*for(String word: word_count.keySet()){
			val = ((word_count.get(word)-min)/(max-min));
			word_count.put(word, val);
		}*/
		for(String s : word_count.keySet()){
			System.out.println( s + word_count.get(s));
		}
		
		request.setAttribute("num", num);
		request.setAttribute("word_count", word_count);
		request.getRequestDispatcher("rendered.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
