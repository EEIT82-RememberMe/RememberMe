package message.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import message.model.MessageBean;
import message.model.MessageResponseBean;
import message.model.MessageResponseService;
import message.model.MessageService;

@WebServlet("/message.controller/MessageServlet")
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String messageId = request.getParameter("messageId");
		String messageContent = request.getParameter("messageContent");
		String action = request.getParameter("action");
//		System.out.println("@@@"+action);
		String memberId = request.getParameter("memberId");
//		System.out.println("@@@"+memberId);
		
		MessageService messageService = new MessageService();
		 MessageResponseService service = new MessageResponseService();
		
		if("新增".equals(action)){
//			System.out.println("!!!!");
			MessageBean bean = new MessageBean();
			bean.setMemberId(memberId);
			bean.setMessageContent(messageContent);
			bean.setMessageTime(new Timestamp(new Date().getTime()));
			messageService.insert(bean);
//			request.getRequestDispatcher("/admin/createMessage.jsp").forward(request, response);
		}
		
		if(messageId!=null){
			int id = new Integer(messageId);
			messageService.deleteById(id);
		}
		
		List<MessageBean> beans = messageService.select();
		 List<String> times = new ArrayList<String>();
		 SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 for(MessageBean e :beans){
//			 System.out.println(sf.format(e.getGuestTime()));
			 times.add(sf.format(e.getMessageTime()));
		 }
		request.setAttribute("message", beans);
		request.setAttribute("times", times);
//		request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
		
		List<MessageResponseBean> responseBeans = service.select();
		List<String> responseTimes = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		for(MessageResponseBean a:responseBeans){
			responseTimes.add(sdf.format(a.getMessageResponseTime()));
		}
		
		request.setAttribute("messageResponse", responseBeans);
		request.setAttribute("responseTimes", responseTimes);
		request.getRequestDispatcher("/admin/replyMessage.jsp").forward(request, response);
		
		return;
	}
	
	
}
