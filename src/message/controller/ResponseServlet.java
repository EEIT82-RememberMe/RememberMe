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

@WebServlet("/message.controller/ResponseServlet")
public class ResponseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String messageResponseId = request.getParameter("messageResponseId");
		System.out.println("messageResponseId======"+messageResponseId);
		String messageId=request.getParameter("messageId");
//		System.out.println("======"+messageId);
		String send = request.getParameter("send");
//		System.out.println("@@@@!!$$"+delete);
		String reply_content = request.getParameter("reply_content");
		String memberId = request.getParameter("memberId");
		
		MessageResponseService service = new MessageResponseService();
		
		if("Send".equals(send)){
		MessageResponseBean bean = new MessageResponseBean();
		bean.setMessageResponseContent(reply_content);
		bean.setMemberId(memberId);
		bean.setMessageId(new Integer(messageId));
		bean.setMessageResponseTime(new Timestamp(new Date().getTime()));
		
		 service.insert(bean);
		}
		
		if(messageResponseId!=null){
		int id = new Integer(messageResponseId);
		service.deleteById(id);
		}
		
		
		MessageService messageService = new MessageService();
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
