package message.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.txw2.Document;

import message. model.MessageBean;
import message.model.MessageResponseBean;
import message.model.MessageResponseService;
import message.model.MessageService;

@WebServlet("/message.controller/ProcessMessage")
public class ProcessMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    
    public ProcessMessage() {
     super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//接收資料
		request.setCharacterEncoding("UTF-8");
		String temp1=request.getParameter("messageId");
//		System.out.println("---------"+temp1);
		String temp3=request.getParameter("messageContent");
//		String temp4=request.getParameter("guestTime");
		String passbtn=request.getParameter("passbtn");
		String memberId = request.getParameter("memberId");
//		System.out.println("&&&&&&"+memberId);
//		String guest_delete = request.getParameter("guestId");
//		System.out.println("&&&&&&"+guest_delete);
		//檢驗資料
		Map<String, String> errors = new HashMap<String,String>();
		request.setAttribute("errors", errors);

//		int messageIdNew = MessageBean.converId(temp1);
		
		MessageService messageService = new MessageService();
		 MessageResponseService service = new MessageResponseService();
		
		//呼叫model
		 if("留言".equals(passbtn)){
		MessageBean bean = new MessageBean();
//		bean.setGuestID(guestIdNew);
		bean.setMemberId(memberId);
//			System.out.println(mem.getMemberId());
		bean.setMessageContent(temp3);
//		bean.setGuestTime(GuestBean.converTime(temp4));
		bean.setMessageTime(new Timestamp(new Date().getTime()));
		//根據model結果,執行view
		 //post功能
			 messageService.insert(bean);
//			 request.setAttribute("Post", result);		
		 }
		 //刪除留言
	//	if("guest_delete".equals(guest_delete)){
//			System.out.println("+++++++++"+guest_delete);
		 if(temp1!=null){
			 System.out.println("#####"+temp1);
			 int id = new Integer(temp1); 
			 messageService.deleteById(id);		 
		 }
//			request.setAttribute("message_delete", result);
//			System.out.println("$$$$$$$"+bean.getGuestID());
	//	}
		 
		 //留言紀錄
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
		request.getRequestDispatcher("/pages/message.jsp").forward(request, response);
//		response.sendRedirect("/RememberMe/pages/message.jsp");
		
//		return;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

}
